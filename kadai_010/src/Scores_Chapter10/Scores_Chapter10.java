package Scores_Chapter10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Scores_Chapter10 {
    public static void main(String[] args) {
        Connection con = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/challenge_java",
                    "root",
                    "XXxmryg0142@"
            );
            System.out.println("データベース接続成功: " + con);

            //SQLクエリ準備
            statement = con.createStatement();
            String Sql = "UPDATE scores SET score_math = 95, score_english = 80 WHERE id = 5";
            System.out.println("レコード更新を実行します" + statement.toString() );
            int rowCnt = statement.executeUpdate(Sql);
            System.out.println(rowCnt + "件のレコードが更新されました。");


            String selectSql = "SELECT id, name, score_math, score_english FROM scores ORDER BY score_math DESC, score_english DESC";
            result = statement.executeQuery(selectSql);
            System.out.println("数学・英語の点数が高い順に並べ替えました");

            while(result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int scoreMath = result.getInt("score_math");
                int scoreEnglish = result.getInt("score_english");
                System.out.println(result.getRow() + "件目: 生徒ID = " + id + " / 氏名 = " + name + " / 数学 = " + scoreMath + " / 英語 = " + scoreEnglish);
            }
        }
        catch(SQLException e) {
            System.out.println("エラー発生：" + e.getMessage());
        }
        finally {
            // 使用したオブジェクトを解放
            if( statement != null ) {
                try { statement.close(); } catch(SQLException ignore) {}
            }
            if( con != null ) {
                try { con.close(); } catch(SQLException ignore) {}
            }
        }
    }
}