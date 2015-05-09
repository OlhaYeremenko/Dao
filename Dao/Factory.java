package dao;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import connect.ConnectorDB;
import dao_entities.CityDao;
import dao_entities.HabitAmountDao;
import dao_entities.HabitTypeDao;
import dao_entities.SQLHelper;

public class Factory implements DaoFactory{
	
			@Override
		public java.sql.Connection getConnection() throws SQLException {
			return ConnectorDB.getConnection();
		}
		@Override
		public CityDao getCityDao(java.sql.Connection connection) {
			// TODO Auto-generated method stub
			return new CityDao();
		}
		@Override
		public HabitTypeDao getHabitTypeDao(java.sql.Connection connection) {
			// TODO Auto-generated method stub
			return new HabitTypeDao();
		}
		@Override
		public HabitAmountDao getHabitAmountDao(java.sql.Connection connection) {
			// TODO Auto-generated method stub
			return new HabitAmountDao();
		}
		@Override
		public SQLHelper getSQLHelper(java.sql.Connection connection) {
			// TODO Auto-generated method stub
			return  new SQLHelper();
		}
}
