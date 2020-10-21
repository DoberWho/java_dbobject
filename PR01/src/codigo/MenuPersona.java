package codigo;

import codigo.db.DbObject;
import codigo.models.Persona;

public class MenuPersona {
	
	public static void iniciar() {
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
			
			// -> 6.- Listar
			System.out.println("Persona :: Listar"); 
			for (DbObject obj : per.list()) {
				Persona p1 = (Persona) obj;
				System.out.println("=>"+p1 );
			}
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
	}

}
