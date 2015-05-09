package dao_entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connect.ConnectorDB;
import entities.City;
import entities.HabitAmount;

public class SQLHelper {
public static final String SQL_SELECT_HABITTYPE_CITY = "select city.*,habittype.* FROM habitamount LEFT JOIN city ON habitamount.idcity=city.idcity LEFT JOIN habittype ON habitamount.idhabit=habittype.idhabit WHERE amount=?";

	
	public List<Object> finbByHabitAmount (int amount) {
		List<Object> haList = new ArrayList();
		List<HabitAmount> haList2 = new ArrayList<>();
		List<City> haList3 = new ArrayList<>();
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = (PreparedStatement) cn
					.prepareStatement(SQL_SELECT_HABITTYPE_CITY);

			st.setInt(1, amount);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
			/*if(isNumber(rs.getObject(i))==true ){
				haList.add(rs.getInt(i));
			}
			else{
				haList.add(rs.getString(i));
			}
				System.out.println(i);
				i++;*/
				//haList.add("id "+rs.getInt(1));
				haList.add("city= "+rs.getString(2));
				haList.add("square= " +rs.getInt(3));
				haList.add("age= "+rs.getInt(4));
				//haList.add(rs.getInt(5));
				haList.add("type= "+rs.getString(6));
				haList.add("languauge= "+rs.getString(7));			
			}

		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}
		return haList;
	}
	public static boolean isNumber(Object input){
	    boolean parsable = true;
	    try{
	        Integer.parseInt(String.valueOf(input));
	    }catch(NumberFormatException e){
	        parsable = false;
	    }
	    return parsable;
	}
	
}
