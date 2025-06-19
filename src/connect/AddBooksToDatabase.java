package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBooksToDatabase {

    public static void addNeedBook(String title, String publisher, String author, String owner1, String owner2, String owner3) {
    	String sql = "INSERT INTO needbooks (title, publisher, author, Owner1, Owner2, Owner3) VALUES (?, ?, ?, ?, ?, ?)";
    	try (Connection connection = DatabaseConnector.getConnection();
    	     PreparedStatement pstmt = connection.prepareStatement(sql)) {
    	    pstmt.setString(1, title);
    	    pstmt.setString(2, publisher);
    	    pstmt.setString(3, author);
    	    pstmt.setString(4, owner1);
    	    pstmt.setString(5, owner2);
    	    pstmt.setString(6, owner3);
    	    pstmt.executeUpdate();
    	    System.out.println("成功将图书添加到 needbooks 数据库。");
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	    // 根据需要适当处理 SQLException
    	}
    }}


