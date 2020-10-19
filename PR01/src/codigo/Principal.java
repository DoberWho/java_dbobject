package codigo;
 
import java.sql.SQLException;
import java.util.ArrayList;

import codigo.cfg.Config;
import codigo.db.DbObject;
import codigo.models.Persona;

public class Principal {

	public static void main(String[] args) { 
				
		Config.getInstance();
		
		try {
			
			Persona per = new Persona();
			per.name     = "Don Jose";
			per.lastname = "Pepito";
			per.setId(1);
			
			per.insertar();
			ArrayList lista = per.list();
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
