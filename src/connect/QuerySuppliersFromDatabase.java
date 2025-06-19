package connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class QuerySuppliersFromDatabase {
	  public static String queryBooksFromDatabase() {
	        StringBuilder result = new StringBuilder();
	        String query = "SELECT * FROM suppliers";

	        try (Connection connection = DatabaseConnector.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {

	            while (resultSet.next()) {
	                String name = resultSet.getString("Sname");
	                String contactmethod = resultSet.getString("ContactMethod");

	                result.append("\n").append("supplier name: ").append(name).append(",ContactMethod:  ").append(contactmethod)
	                        .append("\n");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return result.toString();
	    }
}
