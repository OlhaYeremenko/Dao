package dao_entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connect.ConnectorDB;
import dao.AbstractDAO;
import entities.City;
import entities.HabitAmount;

public class CityDao extends AbstractDAO<Integer, City> {
	public static final String SQL_SELECT_ALL_CITIES = "SELECT City.* FROM City";
	public static final String SQL_ADD_CITIES = "INSERT INTO City VALUES (?,?,?)";
	public static final String SQL_SELECT_CITY = "SELECT * FROM City WHERE idcity = ?";
	public static final String SQL_DELETE_CITY = "DELETE * FROM City WHERE idcity = ?";
	public static final String SQL_CITY = "SELECT city.* FROM city,habitamount,habittype where habitamount.idcity=city.idcity and habitamount.idhabit=habittype.idhabit AND habittype.type =?";


	public List<City> findCityByHabitType(String type) {
		List<City> cities = new ArrayList<>();
		Connection cn = null;
		PreparedStatement st = null;
		HabitAmount c = null;
		try {
			cn = ConnectorDB.getConnection();
			st = (PreparedStatement) cn
					.prepareStatement(SQL_CITY);
			st.setString(1, type);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String ncity = rs.getString(2);
				int square = rs.getInt(3);
				int age = rs.getInt(4);
				cities.add(new City(id, ncity, square, age));
			}
		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}

		return  cities;
	}

	@Override
	public List<City> findAll() {
		List<City> cities = new ArrayList<>();
		Connection cn = null;
		Statement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_ALL_CITIES);
			while (rs.next()) {
				int id = rs.getInt(1);
				String ncity = rs.getString(2);
				int square = rs.getInt(3);
				int age = rs.getInt(4);
				cities.add(new City(id, ncity, square, age));
			}
		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}

		return cities;
	}

	@Override
	public City findEntityById(Integer Id) {
		Connection cn = null;
		PreparedStatement st = null;
		City c = null;
		try {
			cn = ConnectorDB.getConnection();
			st = (PreparedStatement) cn.prepareStatement(SQL_SELECT_CITY);
			st.setInt(1, Id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String ncity = rs.getString(2);
				int square = rs.getInt(3);
				int age = rs.getInt(4);
				c = new City(id, ncity, square, age);
			}
		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}

		return c;
	}

	@Override
	public boolean delete(Integer Id) {
		Connection cn = null;
		PreparedStatement st = null;

		try {
			cn = ConnectorDB.getConnection();
			st = (PreparedStatement) cn.prepareStatement(SQL_DELETE_CITY);
			st.setInt(1, Id);
			ResultSet rs = st.executeQuery();	
			
		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}
		return true;
	}

	@Override
	public boolean delete(City entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean create(City entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public City update(City entity) {

		return null;
	}

}
