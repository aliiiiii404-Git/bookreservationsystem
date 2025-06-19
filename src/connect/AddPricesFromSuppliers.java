package connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class AddPricesFromSuppliers {
    // 添加书籍元组到数据库
    public static void addbookprices(String supplier, String title, double price) {
        // 使用 try-with-resources 自动关闭连接和 statement
        String sql = "INSERT INTO prices (supplier, title, price) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // 设置参数
            pstmt.setString(1, supplier);
            pstmt.setString(2, title);
            pstmt.setDouble(3, price);
            // 执行插入操作
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("书籍元组成功添加到数据库。");
            } else {
                System.out.println("添加书籍元组到数据库失败。");
            }

        } catch (SQLException e) {
            System.out.println("数据库错误: " + e.getMessage());
            e.printStackTrace();
        }
    }}


