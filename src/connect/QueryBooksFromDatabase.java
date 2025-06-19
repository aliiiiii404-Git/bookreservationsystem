package connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	public class QueryBooksFromDatabase {
	    public static String queryBooksFromDatabase() {
	        StringBuilder result = new StringBuilder();
	        String query = "SELECT * FROM needbooks ";

	        try (Connection connection = DatabaseConnector.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String title = resultSet.getString("title");
	                String publisher = resultSet.getString("publisher");
	                String author = resultSet.getString("author");
	                String Owner1 = resultSet.getString("Owner1");
	                String Owner2 = resultSet.getString("Owner2");
	                String Owner3 = resultSet.getString("Owner3");

	                result.append("\n").append("ID: ").append(id).append("\n")
	                .append("BookName: ").append("\n").append(title).append("\n")
	                .append("Publisher:").append(publisher).append("\n")
	                .append("Author: ").append(author).append("\n")
	                .append("Owner1:").append(Owner1).append("\n")
	                .append("Owner2:").append(Owner2).append("\n")
	                .append("Owner3:").append(Owner3).append("\n");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result.toString();
	    }
	}
