package codigo;
 
import java.sql.SQLException;
import java.util.ArrayList;

import codigo.cfg.Config;
import codigo.db.DbObject;
import codigo.models.Persona;

public class Principal {

	public static void main(String[] args) { 
				
		Config.getInstance();
		
		// =============================
		// Persona
		// =============================
		
		Persona per = new Persona();
		try{
			// ->  1.- Listar
			System.out.println("Persona :: Listar"); 
			for (DbObject obj : per.list()) {
				Persona p1 = (Persona) obj;
				System.out.println("=>"+p1.toString() );
			}
			
			// -> 2.- Insertar
			per.name     = "Nombre Persona 01";
			per.lastname = "Apellido Persona 01"; 	 
			per.insertar();
			
			per.name     = "Nombre Persona 02";
			per.lastname = "Apellido Persona 02"; 
			per.insertar();
			
			// -> 3.- Update
			per.name     = "Nombre Persona 03";
			per.lastname = "Apellido Persona 03"; 
			per.setId(3);
			per.update();
			
			// -> 4.- Listar
			System.out.println("Persona :: Listar"); 
			for (DbObject obj : per.list()) {
				Persona p1 = (Persona) obj;
				System.out.println("=>"+p1.toString() );
			}
			
			// -> 5.- Delete
			per.setId(1);
			per.delete();
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		
		
		try {
			
			
			
			
			ArrayList<Persona> lista2 = lista;
			for (Persona persona : lista2) {
				System.out.println("1-Persona:"+persona.name);
			}
			
			per.name     = "Don";
			per.lastname = "Jose"; 
			per.update();
			
			lista = per.list();
			lista2 = lista;
			for (Persona persona : lista2) {
				System.out.println("Persona:"+persona.name);
			}
			
			//per.delete();
			
			
			
		}catch(SQLException e) {
			System.out.println( e.getMessage() );
		}  

		// create a database connection

		/*
		 * 
		 * statement.executeUpdate("drop table if exists person");
		 * 
		 * statement.executeUpdate("create table person (id integer, name string)");
		 * 
		 * statement.executeUpdate("insert into person values(1, 'leo')");
		 * statement.executeUpdate("insert into person values(2, 'yui')");
		 * 
		 * 
		 * 
		 * ResultSet rs = statement.executeQuery("select * from person");
		 * while(rs.next()) { // read the result set System.out.println("name = " +
		 * rs.getString("name")); }
		 * 
		 * 
		 * //
		 */

	}

}
