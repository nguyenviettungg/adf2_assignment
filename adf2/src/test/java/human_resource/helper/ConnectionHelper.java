package human_resource.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String DATABASE_NAME = "human_resource";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/"+DATABASE_NAME+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Bangkok&characterEncoding=utf-8";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PWD = "";
    private static Connection connection;

    public ConnectionHelper() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            System.out.println("Khởi tạo kết nối mới đến db.");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+DATABASE_NAME+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Bangkok&characterEncoding=utf-8", "root", "");
        }

        return connection;
    }
}
