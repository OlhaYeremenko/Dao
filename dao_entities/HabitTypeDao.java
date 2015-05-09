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
import entities.HabitType;

public class HabitTypeDao extends AbstractDAO<Integer, HabitType> {
	public static final String SQL_SELECT_ALL_HABITTYPE = "SELECT * FROM HabitType";
	public static final String SQL_SELECT_HABITTYPE = "SELECT * FROM HabitType WHERE idhabit = ?";
	public static final String SQL_DELETE_HABITTYPE = "DELETE * FROM HabitType WHERE idhabit = ?";
	public static final String SQL_HABITTYPE = "select habittype.* FROM habitamount LEFT JOIN city ON habitamount.idcity=city.idcity LEFT JOIN habittype ON habitamount.idhabit=habittype.idhabit WHERE age in  (SELECT min(age) from city)";
	public List<HabitType> findOldestHabitType() {
		List<HabitType> habitTypes = new ArrayList<>();
		Connection cn = null;
		PreparedStatement st = null;
		HabitAmount c = null;
		try {
			cn = ConnectorDB.getConnection();
			st = (PreparedStatement) cn.prepareStatement(SQL_HABITTYPE);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String type = rs.getString(2);
				String language = rs.getString(3);
				habitTypes.add(new HabitType(id, type, language));
			}

		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}
		return habitTypes;
	}

	@Override
	public List<HabitType> findAll() {
		List<HabitType> habitTypes = new ArrayList<>();
		Connection cn = null;
		Statement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_ALL_HABITTYPE);
			while (rs.next()) {
				int id = rs.getInt(1);
				String type = rs.getString(2);
				String language = rs.getString(3);
				habitTypes.add(new HabitType(id, type, language));
			}

		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}
		return habitTypes;
	}

	@Override
	public HabitType findEntityById(Integer Id) {
		Connection cn = null;
		PreparedStatement st = null;
		HabitType h = null;
		try {
			cn = ConnectorDB.getConnection();
			st = (PreparedStatement) cn.prepareStatement(SQL_SELECT_HABITTYPE);
			st.setInt(1, Id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String type = rs.getString(2);
				String language = rs.getString(3);
				h = new HabitType(id, type, language);
			}
		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}

		return h;

	}

	@Override
	public boolean delete(Integer Id) {
		Connection cn = null;
		PreparedStatement st = null;

		try {
			cn = ConnectorDB.getConnection();
			st = (PreparedStatement) cn.prepareStatement(SQL_DELETE_HABITTYPE);
			st.setInt(1, Id);
			ResultSet rs = st.executeQuery();

		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}
		return true;

	}

	@Override
	public boolean delete(HabitType entity) {
		throw new UnsupportedOperationException();

	}

	@Override
	public boolean create(HabitType entity) {
		throw new UnsupportedOperationException();

	}

	@Override
	public HabitType update(HabitType entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
