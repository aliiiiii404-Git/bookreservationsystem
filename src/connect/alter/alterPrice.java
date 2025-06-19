package connect.alter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connect.DatabaseConnector;

public class alterPrice {
    public static void alterprice(String supplier, String title, Double price, int id) {
        String sql = "UPDATE prices SET supplier=?, title=?, price=? WHERE id=?";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, supplier);
            pstmt.setString(2, title);
            if (price != null) {
                pstmt.setDouble(3, price);
            } else {
                pstmt.setNull(3, java.sql.Types.DOUBLE);
            }
            pstmt.setInt(4, id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("成功更新价格信息。");
            } else {
                System.out.println("未找到匹配的图书记录，更新失败。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 根据需要适当处理 SQLException
        }
    }
}

