import java.sql.*;

public class JDBCUtil {
    // Driver类全名
    public static String DRIVER = "com.mysql.jdbc.Driver";

    // jdbc协议:自协议://ip:port/数据库名
    public static String URL = "jdbc:mysql://10.64.22.200:3306/test";

    public static String USERNAME = "uiadmin";

    public static String PASSWORD = "uiadmin";

    private static Connection connection = null;


    /**
     * 获取 JDBC 连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            // 通过反射加载驱动程序，静态代码块中：创建 Driver 对象，并注册到 DriverManager
            Class.forName(DRIVER);

            // 获取 Connection
            // 在获取 Connection 对象之前，DriverManager 会校验 driver 的信息是否正确
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Connection conn, Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            st = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            st = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
