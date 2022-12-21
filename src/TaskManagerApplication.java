import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business.TaskLogic;
import model.Task;

public class TaskManagerApplication {

	public static void main(String[] args) throws SQLException {
		
		// loop through all the tasks in our database
		for (Task task : TaskLogic.getAllTasksByList(0))
		{
			// print out each task
			System.out.println(task);
		}
		
		System.out.println(TaskLogic.getTaskById(1));
		
		
		
		
		
		
	

//		
//		String insertSql = "INSERT INTO Task (ListId, Description, Priority, Difficulty) "
//				+ "VALUES (?, ?, ?, ?)";
//		PreparedStatement insertPs = connection.prepareStatement(insertSql);
//		insertPs.setInt(1, 1);
//		insertPs.setString(2, "Clean out fridge");
//		insertPs.setInt(3, 1);
//		insertPs.setInt(4, 3);
//		int rowCount = insertPs.executeUpdate();
//		System.out.println(rowCount + " rows were added");
		
//		String updateSQL = "UPDATE Task SET "
//				+ "Description = ? "
//				+ "WHERE ID = ?";
//		PreparedStatement updatePs = connection.prepareStatement(updateSQL);
//		updatePs.setString(1, "Mop the floors");
//		updatePs.setInt(2, 5);
//		int rowCount = updatePs.executeUpdate();
//		System.out.println(rowCount + " rows updated");
		
//		String deleteSql = "DELETE FROM Task "
//				+ "WHERE ID = ?";
//		PreparedStatement deletePs = connection.prepareStatement(deleteSql);
//		deletePs.setInt(1, 6);
//		int rowCount = deletePs.executeUpdate();
//		System.out.println(rowCount + " rows deleted");
//		
//		connection.close();
	}

}
