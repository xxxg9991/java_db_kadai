package Employees_Chapter04;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
public class Employees_Chapter04 {
    public static void main(String[] args) {
        Connection con = null;
        Statement statement = null;

        try {
            //データベース接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/challenge_java", "root", "XXxmryg0142@"
            );
            System.out.println("データベース接続成功" + con);

            //SQLクエリ準備
            statement = con.createStatement();
            String sql = """
                    CREATE TABLE new_users (
                                   id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                   name VARCHAR(60) NOT NULL,
                                   email VARCHAR(255) NOT NULL,
                                   age INT(11),
                                   address VARCHAR(255)
                                 );
                    """;

            //SQLクエリ実行コード
            int rowCnt = statement.executeUpdate(sql);
            System.out.println("テーブルを作成:rowCnt=" + rowCnt);
        } catch (SQLException e) {
            System.out.println("エラー発生：" + e.getMessage());
        } finally {
            //使用したオブジェクトを解放
            if (statement != null) {
                try { statement.close(); } catch (SQLException ignore) {}
            }
            if (con != null) {
                try { con.close(); } catch (SQLException ignore) {}
            }
        }
    }
}
