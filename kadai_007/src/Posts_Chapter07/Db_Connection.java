package Posts_Chapter07;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class Db_Connection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/challenge_java";
        String username = "root";  // 適宜変更してください
        String password = "XXxmryg0142@";  // 適宜変更してください

        try {
            // JDBCドライバーをロード
            Class.forName("com.mysql.cj.jdbc.Driver");

            // データベースに接続
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection successful!");

            // 接続を閉じる
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed.");
            e.printStackTrace();
        }
    }
}
