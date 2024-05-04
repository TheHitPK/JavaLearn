package ecuacion;
import java.util.Scanner;
public class SistemaDeInventario {
	static Scanner scan = new Scanner(System.in);
	//variables
	static int cantTotalProductos = 0;
	//arrays
	static String nombreProducto[] =new String [99];
	static String codigoProducto[] = new String [99];
	static double precioProducto[] = new double[99];
	static int cantidadProducto[] = new int[99];
	//metodos
	//Metodo para agregar productos, ingresando nombre,cantidad,precio y codigo
	static void agregarProducto(int cantProductos) {
		for(int i =0;i <cantProductos; i++){
			scan.nextLine();
			System.out.println("Ingrese el nombre del producto");
			nombreProducto[cantTotalProductos]= scan.nextLine();
			System.out.println("Ingrese el codigo del producto");
			String codigo= scan.nextLine();
				for(int j=0;j<codigoProducto.length;j++){
					if(codigo.equals(codigoProducto[j])) {
						while(codigo.equals(codigoProducto[j])) {
							System.out.println("Codigo repetido, ingrese un codigo valido");
							codigo= scan.nextLine();
						}						
					}						
				}		
			codigoProducto[cantTotalProductos] = codigo;
			System.out.println("Ingrese el precio del producto");
			precioProducto[cantTotalProductos] = scan.nextDouble();
			System.out.println("Ingrese la cantidad de articulos del producto ingresado");
			cantidadProducto[cantTotalProductos] = scan.nextInt();			
			cantTotalProductos++;
		}
		
	}
	//Metodo para visualizar el inventario de productos
	static void visualizarProductos(){
		System.out.println("NOMBRE"+"\t"+"CODIGO"+"\t"+"PRECIO"+"\t"+"EXISTENCIA");
		for(int i = 0; i<cantTotalProductos;i++) {			
			if(nombreProducto != null) {				
				System.out.println(nombreProducto[i]+"\t"+codigoProducto[i]+"\t"+precioProducto[i]+"\t"+cantidadProducto[i]);
			}			
		}
	}
	
	static void modificarProductos() {
		scan.nextLine();
		System.out.println("Ingrese el codigo del producto que desea modificar");
		String codigo = scan.nextLine();
		for(int i = 0; i<codigoProducto.length; i++) {
			if( codigo.equals(codigoProducto[i]) ) {
				System.out.println("NOMBRE"+"\t"+"CODIGO"+"\t"+"PRECIO"+"\t"+"EXISTENCIA");
				System.out.println(nombreProducto[i]+"\t"+codigoProducto[i]+"\t"+precioProducto[i]+"\t"+cantidadProducto[i]);
				System.out.println("Que desea modificar?");
				System.out.println("1- Nombre");
				System.out.println("2- Precio");
				System.out.println("3- Cantidad");
				System.out.println("4- Salir");
				int opcion = scan.nextInt();
				scan.nextLine();
				if(opcion == 1) {					
					System.out.println("Ingrese el nuevo nombre del producto");
					nombreProducto[i] = scan.nextLine();
				} else if (opcion == 2) {
					System.out.println("Ingrese el nuevo precio del producto");
					precioProducto[i] = scan.nextDouble();
				} else if (opcion == 3) {
					System.out.println("Ingrese la nueva cantidad de articulos en existencia del producto");
					cantidadProducto[i] = scan.nextInt();
				} else if (opcion == 4) {
				} else {
					System.out.println("Error- ingrese una opcion valida");
				}
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
			int opc= scan.nextInt();
			
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
				modificarProductos();
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
