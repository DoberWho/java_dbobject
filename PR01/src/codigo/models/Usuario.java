package codigo.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import codigo.db.DbObject;

public class Usuario extends DbObject {
	
	private static final String TABLE = "usuario";
	private static final ArrayList COLS = getArrayCols();
	
	public String login = "";
	public String pass = "";
	public int edad = 0;
	

	private int id = 0;
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getTable() { 
		return TABLE;
	} 
	
	@Override
	public ArrayList getCols() { 
		return COLS;
	}
	private static ArrayList getArrayCols() {
		ArrayList list = new ArrayList();
		list.add("login");
		list.add("pass"); 
		list.add("edad"); 
		return list;
	}

	@Override
	public ArrayList getValues() {
		ArrayList list = new ArrayList();
		list.add( this.login );
		list.add( this.pass ); 
		list.add( this.edad ); 
		return list;
	}

	@Override
	public DbObject parse(ResultSet rs) throws SQLException {
		Usuario obj = new Usuario();
		obj.id = rs.getInt("id");
		
		obj.login = rs.getString("login");
		obj.pass  = rs.getString("pass");
		obj.edad  = rs.getInt("edad");
		
		return obj;	
	}
	  

}
