package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Task;

public class TaskRepository {
	
	private static Connection getConnection() throws SQLException {
		// Create a connection string
		String host = "localhost"; // This computer is the server host. We don't have a server externally
		String sqlInstance = "KAITSSURFACE\\SQLEXPRESS"; // Look at the server name in SSMS
		String sqlDatabase = "TaskManager";
		String sqlUser = "TaskManagerLogin";
		String sqlPassword = "taskManager";
		
		String jdbcConnection = String.format("jdbc:sqlserver://%s:1433;instance=%s;databaseName=%s;encrypt=true;trustServerCertificate=true",
				host,
				sqlInstance,
				sqlDatabase);
		
		Connection connection = DriverManager.getConnection(jdbcConnection, sqlUser, sqlPassword);
		System.out.println("Connection to database successful!");
		
		return connection;
	}
	
	/*
	 * CRUD Operations
	 * 
	 * (C)reate - creates a new Task
	 * (R)ead - get a single Task or multiple Tasks
	 * (U)pdate - updates a Task
	 * (D)elete - delete a Task
	 */
	
	// method that returns all of the tasks in our database
	public static ArrayList<Task> getAllTasks() throws SQLException {
		Statement statement = getConnection().createStatement();
		String sql = "SELECT * FROM Task";
		ArrayList<Task> allTasks = new ArrayList<Task>();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			// for each result, create a new Task object using column values
			Task taskToAdd = new Task(
					resultSet.getInt("ID"),
					resultSet.getInt("ListId"),
					resultSet.getString("Description"),
					resultSet.getInt("Priority"),
					resultSet.getInt("Difficulty"),
					resultSet.getString("DueDate") != null 
						? LocalDateTime.parse(resultSet.getString("DueDate"))
						: null
					);
			
			
			// add the Task to the list
			allTasks.add(taskToAdd);
		}
		
		return allTasks;
		
		
	}
	
	// method that returns a single task
	public static Task getTaskById(int id) throws SQLException {
		Statement statement = getConnection().createStatement();
		String sql = "SELECT * FROM Task WHERE ID = " + id;
		
		// execute the query
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		
		// make a Task object from the results
		Task task = new Task(
				resultSet.getInt("ID"),
				resultSet.getInt("ListId"),
				resultSet.getString("Description"),
				resultSet.getInt("Priority"),
				resultSet.getInt("Difficulty"),
				resultSet.getString("DueDate") != null 
					? LocalDateTime.parse(resultSet.getString("DueDate"))
					: null
				);
		
		// return the task
		return task;
	}
	
	// method that adds a new task
	
	// method that deletes a task
	
	// method that updates a task

}
