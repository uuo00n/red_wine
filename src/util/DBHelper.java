package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author uuo00_n(Hwang Jumbo)
 * cmd * @Date 2022/11/24 17:06
 */
public class DBHelper {
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    private static final String url = "jdbc:mysql://localhost:3306/red_wine?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";

    private static final String username = "root";

    private static final String password = "huang1107";

    private static Connection conn = null;

    static {
        try {
            Class.forName(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        if (conn == null) {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        return conn;
    }


    public static void main(String[] args) {
        try {
            Connection conn = DBHelper.getConnection();
            if (conn != null) {
                System.out.println("数据库连接正常");
            } else {
                System.out.println("数据库连接异常");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
