package connect.query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.DatabaseConnector;
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
	                .append("供货商：").append(supplier).append("\n")
	                .append("书名").append(title).append("\n")
	                .append("价格: ").append(price).append("\n");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result.toString();
	    }
}
