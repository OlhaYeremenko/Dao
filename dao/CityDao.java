package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectorDB;
import entities.City;

public class CityDao extends AbstractDAO<Integer, City> {
	public static final String SQL_SELECT_ALL_CITIES = "SELECT * FROM City";

	/*
	 * public static final String SQL_SELECT_ABONENTS_BY_LASTNAME=
	 * "SELECT idphonebook, phone FROM phonebook WHERE lastname=?";
	 */

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

		return null;
	}

	@Override
	public City findEntityById(Integer Id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(Integer Id) {
		throw new UnsupportedOperationException();
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
