package mySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void createPersonTable() {
		// TODO Auto-generated method stub

		Connection connection = null;
		Statement statement = null;

		try {

			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS person" + "(id int NOT NULL AUTO_INCREMENT, "
					+ " first_name VARCHAR(55)," + "last_name VARCHAR(55)," + " PRIMARY KEY ( id ))";

			statement.execute(sql);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void insert(Person person) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection
					.prepareStatement("INSERT INTO person (first_name, last_name )" + "VALUES(?,?)");
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.executeUpdate();
			System.out.println("The information has been submited to the database" + person);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {

				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public Person selectById(int id) {
		// TODO Auto-generated method stub

		Person person = new Person();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id = ? ");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				person.setId(resultSet.getInt("id"));
				person.setFirstName(resultSet.getString("first_name"));
				person.setLastName(resultSet.getString("last_name"));

			}

		} catch (Exception e) {

		} finally {

			if (resultSet != null) {

				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (preparedStatement != null) {

					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (connection != null) {

					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		}

		return person;
	}

	@Override
	public List<Person> selectAll() {
		// TODO Auto-generated method stub

		List<Person> persons = new ArrayList<Person>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM person");

			while (resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setFirstName(resultSet.getString("first_name"));
				person.setLastName(resultSet.getString("last_name"));

				persons.add(person);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (resultSet != null) {

				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return persons;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			System.out.println("Record deleted at id number " + id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {

				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void update(Person person, int id) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection
					.prepareStatement("UPDATE person SET " + "first_name = ?, last_name = ? WHERE ID = ?");
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();

			System.out.println("You have updated your record at id 3, your new record is now " + person);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {

				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
