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

public class HabitAmountDao extends AbstractDAO<Integer, HabitAmount> {
	public static final String SQL_SELECT_ALL_HABITAMOUNT = "SELECT * FROM habitamount";
	public static final String SQL_ADD_HABITAMOUNT = "INSERT INTO HabitAmount VALUES (?,?,?)";
	public static final String SQL_SELECT_HABITAMOUNT = "SELECT * FROM HabitAmount WHERE idcity = ?";
	public static final String SQL_DELETE_HABITAMOUNT = "DELETE * FROM HabitAmount WHERE idcity = ?";
	public static final String SQL_HABIT = "SELECT habitamount.* FROM habitamount LEFT JOIN city ON habitamount.idcity=city.idcity LEFT JOIN habittype ON habitamount.idhabit=habittype.idhabit WHERE ncity= ? AND language= ? ";

	
	
	
	public List<HabitAmount> finbByCityAndLanguage(String city, String language) {
		List<HabitAmount> haList = new ArrayList<>();
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = (PreparedStatement) cn
					.prepareStatement(SQL_HABIT);

			st.setString(1, city);
			st.setString(2, language);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id= rs.getInt(1);
				int idCity = rs.getInt(2);
				int idHabit = rs.getInt(3);
				int amount = rs.getInt(4);
				haList.add(new HabitAmount(id, idCity, idHabit, amount));  
			}

		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}
		return haList;
	}

	@Override
	public List<HabitAmount> findAll() {
		List<HabitAmount> haList = new ArrayList<>();
		Connection cn = null;
		Statement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_ALL_HABITAMOUNT);
			while (rs.next()) {
				int id = rs.getInt(1);
				int idCity = rs.getInt(2);
				int idHabit = rs.getInt(3);
				int amount = rs.getInt(4);
				haList.add(new HabitAmount(id, idCity, idHabit, amount));
			}
		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}

		return haList;
	}

	@Override
	public HabitAmount findEntityById(Integer Id) {
		Connection cn = null;
		PreparedStatement st = null;
		HabitAmount c = null;
		try {
			cn = ConnectorDB.getConnection();
			st = (PreparedStatement) cn
					.prepareStatement(SQL_DELETE_HABITAMOUNT);
			st.setInt(1, Id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int idCity = rs.getInt(2);
				int idHabit = rs.getInt(3);
				int amount = rs.getInt(4);
				c = new HabitAmount(id, idCity, idHabit, amount);
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
			st = (PreparedStatement) cn
					.prepareStatement(SQL_DELETE_HABITAMOUNT);
			st.setInt(1, Id);
			ResultSet rs = st.executeQuery();
		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}
		return true;
	}

	@Override
	public boolean delete(HabitAmount entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(HabitAmount entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HabitAmount update(HabitAmount entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
