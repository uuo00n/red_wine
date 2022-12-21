package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.ProfileDAO;
import entity.Profile;

/**
 * @author uuo00_n(Hwang Jumbo)
 * @Date 2022/12/21 14:50
 */
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {

    // 跳转资源
    private String uri;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取操作的类型
        String method = request.getParameter("method");

        // 判断
        if ("list".equals(method)) {
            // 展示
            list(request, response);
        } else if ("add".equals(method)) {
            // 添加
            add(request, response);
        } else if ("delete".equals(method)) {
            // 删除
            delete(request, response);
        } else if ("Jump".equals(method)) {
            // 跳转更新页
            Jump(request, response);
        } else if ("update".equals(method)) {
            // 更新
            update(request, response);
        }
    }

    // 公司简介展示
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 调用dao对象的方法，得到结果
            ProfileDAO dao = new ProfileDAO();
            Profile result = dao.getAll();
            // 保存
            request.setAttribute("result", result);
            // 跳转
            uri = "/sys/profile/profile.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 转发
        request.getRequestDispatcher(uri).forward(request, response);
    }

    // 添加
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1. 获取请求数据封装
            String Content = request.getParameter("content");
            Profile profile = new Profile();
            profile.setContent(Content);
            // 2. 调用dao执行添加
            ProfileDAO dao = new ProfileDAO();
            dao.add(profile);
            // 3. 跳转
            uri = "/servlet/ProfileServlet?method=list";
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 转发
        request.getRequestDispatcher(uri).forward(request, response);
    }

    // 删除
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1. 获取请求数据封装
            int Id = Integer.parseInt(request.getParameter("id"));
            Profile profile = new Profile();
            profile.setId(Id);
            // 2. 调用dao执行删除
            ProfileDAO dao = new ProfileDAO();
            dao.delete(profile);
            // 3. 跳转
            uri = "/servlet/ProfileServlet?method=list";
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 转发
        request.getRequestDispatcher(uri).forward(request, response);
    }

    // 更新跳转
    public void Jump(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 获取请求数据封装
            int Id = Integer.parseInt(request.getParameter("id"));
            Profile profile = new Profile();
            profile.setId(Id);
            // 调用dao对象的方法，得到结果
            ProfileDAO dao = new ProfileDAO();
            Profile result = dao.getone(profile);
            // 保存
            request.setAttribute("result", result);
            // 跳转
            uri = "/sys/profile/update.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 转发
        request.getRequestDispatcher(uri).forward(request, response);
    }

    // 更新
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1. 获取请求数据封装
            int Id = Integer.parseInt(request.getParameter("id"));
            String Content = request.getParameter("content");
            Profile profile = new Profile();
            profile.setId(Id);
            profile.setContent(Content);
            // 2. 调用dao执行更新
            ProfileDAO dao = new ProfileDAO();
            dao.update(profile);
            // 3. 跳转
            uri = "/servlet/ProfileServlet?method=list";
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 转发
        request.getRequestDispatcher(uri).forward(request, response);
    }
}
