import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MyClient {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;

        connection = JDBCUtil.getConnection();
        statement = connection.createStatement();

        String sql = "insert into t_user(username, password, gender, email) values ('shayne','123456',1, 'Shayne_Chen@outlook.com')";
        statement.executeUpdate(sql);

        JDBCUtil.release(connection,statement);
    }
}
