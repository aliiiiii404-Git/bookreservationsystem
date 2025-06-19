package connect.delete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.DatabaseConnector;
public class DeleteBookFromDatabase {
	    public static boolean deleteBookByTitle(String title) {  
	        String deleteQuery = "DELETE FROM needbooks WHERE title = ?";   
	        try (Connection connection = DatabaseConnector.getConnection();  
	             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {  
	            statement.setString(1, title);  
	  
	            int rowsAffected = statement.executeUpdate();  
	            return rowsAffected > 0; // 如果受影响的行数大于0，则表示成功删除了书籍  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	            return false; // 如果发生异常，则返回false表示删除失败  
	        }  
	    }  
	}

