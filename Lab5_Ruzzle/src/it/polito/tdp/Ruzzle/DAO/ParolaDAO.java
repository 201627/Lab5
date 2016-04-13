package it.polito.tdp.Ruzzle.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParolaDAO {

	String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=";
	
	public boolean isPresente(String s){
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			String query ="select nome from parola where nome like ?";
			
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1 ,s+"%");
			ResultSet res = st.executeQuery();
			
			if (res.next()){
					res.close();
					conn.close();
					return true;
			}else{
				res.close();
				conn.close();
				return false;
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean isExactly(String s){
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			String query ="select nome from parola where nome = ?";
			
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1 ,s);
			ResultSet res = st.executeQuery();
			
			if (res.next()){
					res.close();
					conn.close();
					return true;
			}else{
				res.close();
				conn.close();
				return false;
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
