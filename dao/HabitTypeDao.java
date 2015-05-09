package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectorDB;
import entities.City;
import entities.HabitType;

public class HabitTypeDao extends AbstractDAO<Integer, HabitType> {
	public static final String SQL_SELECT_ALL_HABITTYPE = "SELECT * FROM HabitType";

	@Override
	public List<HabitType> findAll() {
		List<HabitType>  habitTypes= new ArrayList<>();
		  Connection cn=null;
		  Statement st=null;
		  try {
		cn=ConnectorDB.getConnection();
		st=cn.createStatement();
		ResultSet rs= st.executeQuery(SQL_SELECT_ALL_HABITTYPE);
		while(rs.next()){
		int id=rs.getInt(1);
		String type=rs.getString(2);
		String language=rs.getString(3);
		habitTypes.add(new HabitType(id,type,language));
		}

		} catch (SQLException e) {
		System.err.println("SQL Exeption (request or table failed):"+e);
		}
		return null;
	}

	@Override
	public HabitType findEntityById(Integer Id) {
		throw new UnsupportedOperationException();

	}

	@Override
	public boolean delete(Integer Id) {
		throw new UnsupportedOperationException();

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
