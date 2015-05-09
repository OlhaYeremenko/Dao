package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao_entities.CityDao;
import dao_entities.HabitAmountDao;
import dao_entities.HabitTypeDao;
import dao_entities.SQLHelper;

public interface DaoFactory {
	public Connection getConnection() throws SQLException;

	public CityDao getCityDao(Connection connection);

	public HabitTypeDao getHabitTypeDao(Connection connection);

	public HabitAmountDao getHabitAmountDao(Connection connection);
	
	public SQLHelper getSQLHelper(Connection connection);

	
}