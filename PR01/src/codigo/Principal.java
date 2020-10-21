package codigo;
 
import java.sql.SQLException;
import java.util.ArrayList;

import codigo.cfg.Config;
import codigo.db.DbObject;
import codigo.models.Persona;
import codigo.models.Producto;
import codigo.models.Usuario;

public class Principal {

	public static void main(String[] args) { 
				
		Config.getInstance();
		
		DbObject model = new Persona();
		if ("Pulso Persona".isEmpty()) {
			model = new Persona();
		}
		if ("Pulso Producto".isEmpty()) {
			model = new Producto();
		}
		if ("Pulso Usuario".isEmpty()) {
			model = new Usuario();
		} 
		
		try{
		
			for (DbObject obj : model.list()) {
				Persona p1 = (Persona) obj;
				System.out.println("=>"+p1.toString() );
			}
		
		}catch(Exception e) {
			 e.printStackTrace();
		}
		
		
		// =============================
		// Persona
		// =============================
		MenuPersona.iniciar();
		
		// =============================
		// Producto
		// =============================
		MenuProducto.iniciar();
		
		// =============================
				// Producto
				// =============================
				MenuProducto.iniciar();
		
	 

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
