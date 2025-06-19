package connect.alter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connect.DatabaseConnector;
public class alterBooksInDatabase {
    public static void alterbooks(String title, String publisher, String author, String owner1, String owner2, String owner3,int booknumber,int id) {
        String sql = "UPDATE needbooks SET title=?, publisher=?, author=?, Owner1=?, Owner2=?, Owner3=?,booknumber=? WHERE id=?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, publisher);
            pstmt.setString(3, author);
            pstmt.setString(4, owner1);
            pstmt.setString(5, owner2);
            pstmt.setString(6, owner3);
            pstmt.setInt(7, booknumber);
            pstmt.setInt(8, id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("成功更新图书信息。");
            } else {
                System.out.println("未找到匹配的图书记录，更新失败。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 根据需要适当处理 SQLException
        }
    }
}
