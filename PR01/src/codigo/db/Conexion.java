package codigo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {

	private static Conexion instance;

	private Conexion() {
		try {
			//Class.forName(ConfigDB.DB_DRIVER);
			Class.forName("com.mysql.jdbc.Driver");
			String host = ConfigDB.DB_HOST;
			String user = ConfigDB.DB_USER;
			String pass = ConfigDB.DB_PASS;
			System.out.println("DB_HOST: "+host);
			System.out.println("DB_USER: "+user);
			System.out.println("DB_PASS: "+pass);  
			
			connection = DriverManager.getConnection(host, user, pass);
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "root", "A.joker.1");
			initiateDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		
	}

	private void initiateDatabase() throws SQLException {

		ArrayList<String> queries = ConfigDB.queries;
		
		for (String query : queries) {
			this.executeQuery(query);	
		}  
		
	}

	public static Conexion getInstance() {
		if (instance == null) {
			instance = new Conexion();
		}
		return instance;
	}

	private Connection connection = null;

	private Statement getState() throws SQLException {
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30); // set timeout to 30 sec.

		return statement;
	}

	public void close() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// connection close failed.
			System.err.println(e.getMessage());
		}
	}

	private String getTailValues(ArrayList values) {
		// "XXX", "YYY"
		String res = "";
		// ('Don Jose'),('Pepito')
		// ('Don Jose', 'Pepito')
		for (Object value : values) {
			
			String resValue = ""+value;
			if (value instanceof String) {
				resValue = "'" + value + "'";
			} 			
			res = res + ","+resValue;
		}
		res = res.substring(1);
		res = "("+res+")";
		return res;
	}

	private String getStringArray(ArrayList values) {
		// "XXX", "YYY"
		String res = "";
		for (Object value : values) {
			
			String resValue = ""+value;
			if (value instanceof String) {
				resValue = "`" + value + "`";
			} 			
			res = res + ","+resValue;
		}
		res = res.substring(1);
		return res;
	}

	private String getStringArray(ArrayList cols, ArrayList values, String separador) {
		// `name`='Buri'
		String res = "";
		for (int i = 0; i < cols.size(); i++) {
			Object value = values.get(i);
			String col = (String) cols.get(i);
			
			String resValue = ""+value;
			if (value instanceof String) {
				resValue = "'" + value + "'";
			} 

			res = res + separador + "`" + col + "`="+resValue;

		}

		res = res.substring(separador.length());
		// res = res.replace( separador, "" );

		return res;
	}

	/**
	 * 
	 * Esta función sirve para insertar datos en una tabla.
	 * 
	 * @param TABLA  Nombre de la tabla que quiero usar para insertar
	 * @param values Array de valores a insertar en la tabla
	 * @return Devolverá <strong>True</strong>/<strong>False</strong> según
	 *         insertara bien o no
	 * @throws SQLException Error de SQL, ¿Quizá la tabla no existe?
	 */
	public boolean insertar(String TABLA, ArrayList cols, ArrayList values) throws SQLException {
		String tail = this.getTailValues(values);
		String head = this.getStringArray(cols);
		String query = "insert into " + TABLA + " (" + head + ") values " + tail + "";

		this.executeQuery(query);	
		return false;
	}

	public ResultSet select(String TABLA) throws SQLException {
		Statement state = this.getState();
		return state.executeQuery("select * from " + TABLA);
	}

	public ResultSet select(String TABLA, ArrayList cols, ArrayList values) throws SQLException {
		String tail = this.getStringArray(cols, values, " AND ");
		Statement state = this.getState();
		return state.executeQuery("select * from " + TABLA + " WHERE " + tail);
	}

	public void update(String TABLA, Integer ID, ArrayList cols, ArrayList values) throws SQLException {
		// UPDATE "+TABLA+" SET `name`='Buri' WHERE `id`="+ID;
		String tail = this.getStringArray(cols, values, ", ");
		String query = "UPDATE 	 " + TABLA + " SET " + tail + "  WHERE  `id`=" + ID;
		this.executeQuery(query);	
	}

	public void delete(String TABLA, Integer ID) throws SQLException {

		// DELETE FROM XXXXX WHERE ID = YYYY
		String query = "DELETE FROM " + TABLA + " WHERE id=" + ID;
		this.executeQuery(query);		
	}
	
	private void executeQuery(String query) throws SQLException {
		Statement state = this.getState();
		state.executeUpdate(query);
	}

	public boolean isConnected() throws SQLException {
		if (connection == null) {
			return false;
		}
		return !connection.isClosed();
	}

}
