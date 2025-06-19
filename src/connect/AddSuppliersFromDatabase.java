package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddSuppliersFromDatabase {

    // 添加新供货商元组添加到数据库
    public static void addsuppliers(String supplier, String connectmethod) {
        // 使用 try-with-resources 自动关闭连接和 statement
        String sql = "INSERT INTO Suppliers (Sname, ContactMethod) VALUES (?, ?)";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // 设置参数
            pstmt.setString(1, supplier); // 使用方法参数设置 PreparedStatement 的参数
            pstmt.setString(2, connectmethod);

            // 执行插入操作
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("供应商元组成功添加到数据库。");
            } else {
                System.out.println("添加供应商元组到数据库失败。");
            }

        } catch (SQLException e) {
            System.out.println("数据库错误: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

