package connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DeleteSuppliersFromDatabase {
	    public static boolean deleteSuppliersByTitle(String Sname) {  
	        String deleteQuery = "DELETE FROM suppliers WHERE Sname = ?";   
	        try (Connection connection = DatabaseConnector.getConnection();  
	             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {  
	            statement.setString(1, Sname);  
	  
	            int rowsAffected = statement.executeUpdate();  
	            return rowsAffected > 0; // 如果受影响的行数大于0，则表示成功删除了书籍  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	            return false; // 如果发生异常，则返回false表示删除失败  
	        }  
	    }  
	}