package codigo;

import codigo.db.DbObject;
import codigo.models.Persona;
import codigo.models.Producto;

public class MenuProducto {
	
	public static void iniciar() {
		Producto per = new Producto();
		try{
			// ->  1.- Listar
			System.out.println("Producto :: Listar"); 
			for (DbObject obj : per.list()) {
				Persona p1 = (Persona) obj;
				System.out.println("=>"+p1.toString() );
			}
			
			// -> 2.- Insertar
			per.name     = "Nombre Producto 01"; 
			per.insertar();
			
			per.name     = "Nombre Producto 02"; 
			per.insertar();
			
			// -> 3.- Update
			per.name     = "Nombre Producto 03"; 
			per.setId(3);
			per.update();
			
			// -> 4.- Listar
			System.out.println("Producto"); 
			for (DbObject obj : per.list()) {
				Persona p1 = (Persona) obj;
				System.out.println("=>"+p1.toString() );
			}
			
			// -> 5.- Delete
			per.setId(1);
			per.delete();
			
			// -> 6.- Listar
			System.out.println("Producto :: Listar"); 
			for (DbObject obj : per.list()) {
				Persona p1 = (Persona) obj;
				System.out.println("=>"+p1 );
			}
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
	}

}
