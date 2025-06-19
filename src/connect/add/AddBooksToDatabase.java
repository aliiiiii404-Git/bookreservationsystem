package connect.add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.DatabaseConnector;

public class AddBooksToDatabase {

    public static void addNeedBook(String title, String publisher, String author,int booknumber, String owner1, String owner2, String owner3) {
    	String sql = "INSERT INTO needbooks (title, publisher, author,booknumber, Owner1, Owner2, Owner3) VALUES (?, ?, ?, ?, ?, ?, ?)";
    	try (Connection connection = DatabaseConnector.getConnection();
    	     PreparedStatement pstmt = connection.prepareStatement(sql)) {
    	    pstmt.setString(1, title);
    	    pstmt.setString(2, publisher);
    	    pstmt.setString(3, author);
    	    pstmt.setInt(4,booknumber);
    	    pstmt.setString(5, owner1);
    	    pstmt.setString(6, owner2);
    	    pstmt.setString(7, owner3);
    	    
    	    pstmt.executeUpdate();
    	    System.out.println("成功添加图书。");
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	    // 根据需要适当处理 SQLException
    	}
    }}


