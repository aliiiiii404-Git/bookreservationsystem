package connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class QueryPricesFromSuppliers {
	 public static String queryBooksFromDatabase() {
	        StringBuilder result = new StringBuilder();
	        String query = "SELECT * FROM prices ";

	        try (Connection connection = DatabaseConnector.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	            	String supplier = resultSet.getString("supplier");
	                String title = resultSet.getString("title");
	                double price = resultSet.getDouble("price");
	                result.append("\n")
	                .append("Supplier").append(supplier).append("\n")
	                .append("title").append(title).append("\n")
	                .append("Price: ").append(price).append("\n");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result.toString();
	    }
}
