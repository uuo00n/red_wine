package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import dao.CommodityDAO;
import entity.Commodity;
import util.PageBean;

/**
 * @author uuo00_n(Hwang Jumbo)
 * @Date 2022/12/21 14:38
 */
@WebServlet(name = "CommodityServlet")
public class CommodityServlet extends HttpServlet {
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
            // 列表展示
            list(request, response);
        } else if ("search".equals(method)) {
            // 搜索
            search(request, response);
        } else if ("delete".equals(method)) {
            // 删除
            delete(request, response);
        } else if ("Jumpup".equals(method)) {
            // 跳转更新页
            Jumpup(request, response);
        }
    }

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

            CommodityDAO dao = new CommodityDAO();
            // 调用dao对象的getAll方法，得到结果
            Map<String, Object> result = dao.getAll(pageBean);
            // 保存
            request.setAttribute("result", result); // 结果
            // 跳转
            uri = "/sys/goods/goods.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 转发
        request.getRequestDispatcher(uri).forward(request, response);
    }

    // c.删除商品
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 1. 获取请求数据封装
            int CommodityId = Integer.parseInt(request.getParameter("id"));

            Commodity cc = new Commodity();
            cc.setId(CommodityId);

            // 2. 调用dao执行删除
            CommodityDAO dao = new CommodityDAO();
            dao.delete(cc);

            // 3. 跳转
            uri = "/servlet/CommodityServlet?method=list";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 转发
        request.getRequestDispatcher(uri).forward(request, response);

    }

    // d.查找商品
    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //获取“当前页”参数；（当第一次访问当前页为null）
            String currPage = request.getParameter("currentPage");
            //获取查找的商品名称
            String CommodityTitle = request.getParameter("title");
            //判断
            if (currPage == null || "".equals(currPage.trim())) {
                currPage = "1";       //第一次访问，设置当前页为1；
            }
            //转换
            int currentPage = Integer.parseInt(currPage);

            //2创建dao对象，设置当前页参数；
            PageBean pageBean = new PageBean();
            pageBean.setCurrentPage(currentPage);

            Commodity title = new Commodity();
            title.setTitle(CommodityTitle);
            // 调用dao对象的search方法，得到结果
            CommodityDAO dao = new CommodityDAO();
            Map<String, Object> result = dao.search(pageBean, title);
            // 保存
            request.setAttribute("result", result);
            // 跳转
            uri = "/sys/goods/goods.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 转发
        request.getRequestDispatcher(uri).forward(request, response);

    }

    // e.商品更新跳转展示
    public void Jumpup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            // 1. 获取请求数据封装
            int CommodityId = Integer.parseInt(request.getParameter("id"));

            Commodity cc = new Commodity();
            cc.setId(CommodityId);

            // 2. 调用dao执行添加
            CommodityDAO dao = new CommodityDAO();

            // 调用dao对象的getone方法，得到结果
            Commodity result = dao.getone(cc);

            // 保存
            request.setAttribute("listClass", result);
            // 跳转
            uri = "/sys/goods/update.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 转发
        request.getRequestDispatcher(uri).forward(request, response);

    }
}
