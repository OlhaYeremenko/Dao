package demo;



import java.sql.Connection;
import java.sql.SQLException;

import connect.ConnectorDB;
import dao_entities.CityDao;
import dao_entities.HabitAmountDao;
import dao_entities.HabitTypeDao;
import dao_entities.SQLHelper;
import dao_factory.DaoFactory;
import dao_factory.Factory;
import entities.City;
import entities.HabitAmount;
import entities.HabitType;

public class DemoDao {
	public static void main(String[] args) throws SQLException {
 Factory df = new  Factory();
 
 Connection connection = ConnectorDB.getConnection(); 
 CityDao city=df.getCityDao(connection);
 HabitTypeDao habitType= df.getHabitTypeDao(connection);
 HabitAmountDao habitAmount = df.getHabitAmountDao(connection);
 SQLHelper sql = df.getSQLHelper(connection);
 System.out.println("Table city : " +city.findAll());
 System.out.println("Find 2 city\n"+ city.findEntityById(2));
 System.out.println("Find city with nationality europeans \n"+ city.findCityByHabitType("europeans"));

 System.out.println("Table Habitance Type\n"+ habitType.findAll());
 System.out.println("Find Oldest Habit Type\n"+ habitType.findOldestHabitType());
 
 System.out.println("Table of amount of each nationality in city \n"+ habitAmount.findAll());
 System.out.println("Find amount of nationality in Kiev, that speek ukrainian \n"+ habitAmount.finbByCityAndLanguage("Kiev", "ukrainian"));
 System.out.println("Find all about city and nationality where amoun is 18000 \n"+ sql.finbByHabitAmount(180000));
 
		}	
}
