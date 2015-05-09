package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
	public Connection getConnection() throws SQLException;

	public CityDao getCityDao(Connection connection);

	public HabitTypeDao getHabitTypeDao(Connection connection);

	public HabitAmountDao getHabitAmountDao(Connection connection);
}