package co.com.bancolombia.factoring.google.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

public class agendaDB {
	public static Statement stm=null;
	public static ResultSet rs=null;
	private static Connection con=null;
	static ArrayList<String> nombresdb = new ArrayList<>();
	static String m;
	
	public static void main(String[] args) {
		   	conectar();
			System.out.println(ObtenerNombresAgenda());
			//insertarcomprobacion("prueba", "Johan Rojas");
			
	}
	
	public static void conectar() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/miprueba", "root", "");
			if (con!=null) {				 
				System.out.println("conexión exitosa");
			}else {
				System.out.println("Falló la conexión");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> ObtenerNombresAgenda() {		
		try {			
			conectar();
			stm = (Statement) con.createStatement();
			rs = stm.executeQuery("SELECT name FROM user_facebook");					
			while(rs.next()) {
				nombresdb.add(rs.getString("name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombresdb;
	}
	
	
//	public static String Comprobar(String nombre) {
//		
//		return nombre;		
//	}
	
	public static void insertarcomprobacion(String verificar,String nombre) {
		try {			
			conectar();
			stm = (Statement) con.createStatement();
			stm.executeUpdate("UPDATE user_facebook SET verify ='"+verificar+"' WHERE name ='"+nombre+"'");					
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void intoNewElement (String comment ,String nameFriend) {
		try {			
			conectar();
			stm = (Statement) con.createStatement();
			stm.executeUpdate("INSERT INTO user_facebook (name, verify) VALUES ('"+nameFriend+"','"+comment+"')");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
