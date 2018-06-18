package ua.danit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author others
 * @author Alexei Leichenko
 *
 */

public class ConnectionToDB
{
	/*private static final String DB_URL = "jdbc:postgresql://danit.cukm9c6zpjo8.us-west-2.rds.amazonaws.com/fs5";
	private static final String USERNAME = "fs5_user";
	private static final String USER_PASS = "bArceloNa";*/

	private static final String DB_URL = "jdbc:postgresql://localhost:5432/fs5";
	private static final String USERNAME = "fs5_user";
	private static final String USER_PASS = "bArceloNa";


	protected static Connection getConnection(){

		Connection connection = null;

		try
		{
			connection = DriverManager.getConnection(DB_URL, USERNAME, USER_PASS);
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}

		return connection;
	}
}
