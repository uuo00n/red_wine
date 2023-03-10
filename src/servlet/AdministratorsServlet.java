package servlet;

import entity.Administrators;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import dao.AdministratorsDAO;
import entity.Administrators;
import util.PageBean;

/**
 * @author uuo00_n(Hwang Jumbo)
 * @Date 2022/12/21 14:29
 */
@WebServlet(name = "AdministratorsServlet")
public class AdministratorsServlet extends HttpServlet {
    //跳转资源
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
        if ("add".equals(method)) {
            // 添加
            add(request, response);
        } else if ("list".equals(method)) {
            // 列表展示
            list(request, response);
        } else if ("search".equals(method)) {
            // 更新
            search(request, response);
        } else if ("delete".equals(method)) {
            // 删除
            delete(request, response);
        } else if ("Jumpup".equals(method)) {
            // 跳转更新页
            Jumpup(request, response);
        } else if ("update".equals(method)) {
            // 更新
            update(request, response);
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 1. 获取请求数据封装
            String administratorsName = request.getParameter("name");
            String administratorsPassword = request.getParameter("password");

            Administrators cc = new Administrators();
            cc.setName(administratorsName);
            cc.setPassword(administratorsPassword);

            // 2. 调用dao执行添加
            AdministratorsDAO dao = new AdministratorsDAO();
            dao.add(cc);

            // 3. 跳转
            uri = "/servlet/AdministratorsServlet?method=list";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 转发
        request.getRequestDispatcher(uri).forward(request, response);

    }

    // b.展示
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //1. 获取“当前页”参数；（当第一次访问当前页为null）
            String currPage = request.getParameter("currentPage");
            //判断
            if (currPage == null || "".equals(currPage.trim())) {
                currPage = "1";       //第一次访问，设置当前页为1；
            }
            //转换
            int currentPage = Integer.parseInt(currPage);

            //2. 创建dao对象，设置当前页参数；
            PageBean pageBean = new PageBean();
            pageBean.setCurrentPage(currentPage);

            AdministratorsDAO dao = new AdministratorsDAO();
            // 调用dao对象的getAll方法，得到结果
            Map<String, Object> result = dao.getAll(pageBean);

            //保存
            request.setAttribute("result", result);

            // 跳转页
            uri = "/sys/administrators/administrators.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 转发
        request.getRequestDispatcher(uri).forward(request, response);

    }

    // c.删除
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 1. 获取请求数据封装
            int administratorsId = Integer.parseInt(request.getParameter("id"));

            Administrators cc = new Administrators();
            cc.setId(administratorsId);

            // 2. 调用dao执行删除
            AdministratorsDAO dao = new AdministratorsDAO();
            dao.delete(cc);

            // 3. 跳转
            uri = "/servlet/AdministratorsServlet?method=list";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 转发
        request.getRequestDispatcher(uri).forward(request, response);

    }

    // d.查找
    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            //获取“当前页”参数；（当第一次访问当前页为null）
            String currPage = request.getParameter("currentPage");
            //获取查找的管理员用户名
            String administratorsName = request.getParameter("name");
            //判断
            if (currPage == null || "".equals(currPage.trim())) {
                currPage = "1";       //第一次访问，设置当前页为1；
            }
            //转换
            int currentPage = Integer.parseInt(currPage);

            //创建dao对象，设置当前页参数；
            PageBean pageBean = new PageBean();
            pageBean.setCurrentPage(currentPage);

            Administrators title = new Administrators();
            title.setName(administratorsName);
            // 调用dao对象的search方法，得到结果
            AdministratorsDAO dao = new AdministratorsDAO();
            Map<String, Object> result = dao.search(pageBean, title);

            //保存
            request.setAttribute("result", result);

            // 跳转页
            uri = "/sys/administrators/administrators.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 转发
        request.getRequestDispatcher(uri).forward(request, response);

    }

    // e.更新跳转展示
    public void Jumpup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            // 1. 获取请求数据封装
            int administratorsId = Integer.parseInt(request.getParameter("id"));

            Administrators cc = new Administrators();
            cc.setId(administratorsId);

            // 2. 调用dao执行添加
            AdministratorsDAO dao = new AdministratorsDAO();

            // 调用dao对象的getone方法，得到结果
            Administrators result = dao.getone(cc);

            // 保存
            request.setAttribute("listClass", result);
            // 跳转页
            uri = "/sys/administrators/update.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 转发
        request.getRequestDispatcher(uri).forward(request, response);

    }

    // f.更新管理员
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 1. 获取请求数据封装
            int administratorsId = Integer.parseInt(request.getParameter("id"));
            String administratorsName = request.getParameter("name");
            String administratorsPassword = request.getParameter("password");

            Administrators cc = new Administrators();
            cc.setId(administratorsId);
            cc.setName(administratorsName);
            cc.setPassword(administratorsPassword);

            // 2. 调用dao执行添加
            AdministratorsDAO dao = new AdministratorsDAO();
            dao.update(cc);

            // 3. 跳转
            uri = "/servlet/AdministratorsServlet?method=list";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 转发
        request.getRequestDispatcher(uri).forward(request, response);

    }

}
