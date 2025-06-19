package connect.query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.DatabaseConnector;
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
	                int booknumber=  resultSet.getInt("booknumber") ;
	                result.append("\n")
	                .append("书目序号: ").append(id).append("\n")
	                .append("书名: ").append(title).append("\n")
	                .append("出版社:").append(publisher).append("\n")
	                .append("作者: ").append(author).append("\n")
	                .append("供货商1:").append(Owner1).append("\n")
	                .append("供货商2:").append(Owner2).append("\n")
	                .append("供货商3:").append(Owner3).append("\n")
	                .append("书目数量:").append(booknumber).append("\n");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result.toString();
	    }
	}
