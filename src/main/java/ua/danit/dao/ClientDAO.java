package ua.danit.dao;

import ua.danit.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends AbstractDAO<Client>
{
	@Override public void save(Client client)
	{
		String sql = "INSERT INTO client(login, password, name) VALUES(?,?,?)";

		try (Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
		{
			statement.setString(1, client.getLogin());
			statement.setString(2, client.getPassword());
			statement.setString(3, client.getName());


			statement.executeUpdate();
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
	}

	@Override public void update(Client client)
	{
		String sql = "UPDATE client SET password=?, name=?, WHERE login=?";

		try (
                Connection connection = ConnectionToDB.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
			)
		{

			statement.setString(4, client.getLogin());
			statement.setString(2, client.getName());
			statement.setString(1, client.getPassword());


			statement.executeUpdate();
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
	}

	@Override
	public Client get(Object pk)
	{
		Client client = new Client();

		String sql = "SELECT * FROM client WHERE login='" + pk + "'";

		try (
                Connection        connection  = ConnectionToDB.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
			)
		{
			while ( rSet.next() )
			{
				client.setLogin(rSet.getString("login"));
				client.setPassword(rSet.getString(2));
				client.setName(rSet.getString("name"));


				return client;
			}
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override public void delete(Object login)
	{
		String sql = "DELETE FROM client WHERE login=?";

		try (
                Connection connection = ConnectionToDB.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
			)
		{
			statement.setString(1, (String) login);
			statement.executeUpdate();
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
	}
}
