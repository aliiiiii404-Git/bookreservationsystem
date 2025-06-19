package connect.alter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connect.DatabaseConnector;

public class alterSupplier {

    public static void altersupplier(String Sname, String contactmethod) {
        String sql = "UPDATE suppliers SET ContactMethod=? WHERE Sname=?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, contactmethod);
            pstmt.setString(2, Sname);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("成功更新供应商信息。");
            } else {
                System.out.println("未找到匹配的供应商记录，更新失败。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

