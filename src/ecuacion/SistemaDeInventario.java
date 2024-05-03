package ecuacion;
import java.util.Scanner;
public class SistemaDeInventario {
	static Scanner scan = new Scanner(System.in);
	//variables
	static int aux = 0;
	//arrays
	static String producto[]=new String [10];
	
	
	//metodos
	static void agregarProducto(int cantProductos) {
		for(int i = 0;i <=cantProductos; i++){
			producto[aux]= scan.nextLine();
			aux++;
		}
		
	}
	
	static void visualizarProductos(){
		for(int i = 0; i<aux;i++) {
			if(producto != null) {
				System.out.println(producto[i]);
			}
			
			
		}
	}

	public static void main(String[] args) {
		int salir = 6;
		boolean programa = false;
		do {
			System.out.println("MENU");
			System.out.println("1- Agregar producto.");
			System.out.println("2- Visualizar productos.");
			System.out.println("3- Modificar producto.");
			System.out.println("4- Estadistica.");
			System.out.println("5- Configuraciones (IVA / TASA DE CAMBIO).");
			System.out.println("6- Salir.");
			int opc= 0;
			opc = scan.nextInt();
			//MENU PRINCIPAL
			
			if(opc==1) {
				System.out.println("Agregar producto.");
				System.out.println("Ingrese la cantidad de productos que sea agregar");
				int cantProductos = 0;
				cantProductos = scan.nextInt();
				agregarProducto(cantProductos);
			}else if(opc == 2) {
				System.out.println(" Visualizar Productos.");
				visualizarProductos();
			}else if(opc == 3) {
				
			}else if(opc == 4) {
				
			}else if(opc == 5) {
				
			}else if(opc == salir) {
				programa = true;
				
			}else {
				System.out.println("Opcion incorrecta");
			}
				
			
			
		}while(programa == false);

	}

}
