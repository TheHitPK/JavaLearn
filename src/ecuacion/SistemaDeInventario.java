package ecuacion;
import java.util.Scanner;
public class SistemaDeInventario {
	static Scanner scan = new Scanner(System.in);
	//variables
	static double IVA = 16;
	static int cantTotalProductos = 0;
	static int mayorCantArticulos = Integer.MIN_VALUE;
	static int menorCantArticulos = Integer.MAX_VALUE;
	static double productoMasCostoso = Double.MIN_VALUE;
	static double productoMenosCostoso = Double.MAX_VALUE;
	static double tasaUsdBs = 36.40;
	static String nombreMasCostoso;
	static String nombreMenosCostoso;
	static String nombreMayorCant;
	static String nombreMenorCant;

	//arrays
	static String nombreProducto[] =new String [99];
	static String codigoProducto[] = new String [99];
	static double precioProducto[] = new double[99];
	static int cantidadProducto[] = new int[99];

	// metodo main
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
			int opc = scan.nextInt();

			// MENU PRINCIPAL
			if (opc == 1) {
				System.out.println("Agregar producto.");
				System.out.println("Ingrese la cantidad de productos que sea agregar");
				int cantProductos = 0;
				cantProductos = scan.nextInt();
				agregarProducto(cantProductos);
			} else if (opc == 2) {
				System.out.println(" Visualizar Productos.");
				visualizarProductos();
			} else if (opc == 3) {
				modificarProductos();
			} else if (opc == 4) {
				estadisticas();
			} else if (opc == 5) {

			} else if (opc == salir) {
				programa = true;

			} else {
				System.out.println("Opcion incorrecta");
			}

		} while (programa == false);

	}
	// Metodos
	static void agregarProducto(int cantProductos) {
		for(int i =0;i <cantProductos; i++){
			scan.nextLine();
			System.out.println("Ingrese el nombre del producto");
			nombreProducto[cantTotalProductos]= scan.nextLine();
			System.out.println("Ingrese el codigo del producto");
			String codigo = scan.nextLine();
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
			// Mayor y menor precio
			if (precioProducto[cantTotalProductos] > productoMasCostoso) {
				productoMasCostoso = precioProducto[cantTotalProductos];
				nombreMasCostoso = nombreProducto[i];
			}
			if (precioProducto[cantTotalProductos] < productoMenosCostoso) {
				productoMenosCostoso = precioProducto[cantTotalProductos];
				nombreMenosCostoso = nombreProducto[i];
			}
			System.out.println("Ingrese la cantidad de articulos del producto ingresado");
			cantidadProducto[cantTotalProductos] = scan.nextInt();
			// Cantidad mayor y menor de producto
			if (cantidadProducto[cantTotalProductos] > mayorCantArticulos) {
				mayorCantArticulos = cantidadProducto[cantTotalProductos];
				nombreMayorCant = nombreProducto[i];
			}
			if (cantidadProducto[cantTotalProductos] < menorCantArticulos) {
				menorCantArticulos = cantidadProducto[cantTotalProductos];
				nombreMenorCant = nombreProducto[i];
			}

			cantTotalProductos++;
		}
	}

	static void configuracion() {
		System.out.println("Configuracion");
		System.out.println("1- IVA");
		System.out.println("2- Tasa USD/BS");
		System.out.println("3-Salir");
		int opcion = scan.nextInt();
		if (opcion == 1) {
			System.out.println("IVA");
			System.out.println("Tasa actual: " + IVA + "%");
			System.out.println("Ingrese la nueva tasa:");
			IVA = scan.nextInt();
			System.out.println("Nueva tasa: " + IVA + "%");

		} else if (opcion == 2) {
			System.out.println("TASA USD/BS");
			System.out.println("Tasa actual: " + tasaUsdBs);
			System.out.println("Ingrese la nueva tasa");
			tasaUsdBs = scan.nextInt();
			System.out.println("Nueva tasa: " + tasaUsdBs);
		}
	}

	static void estadisticas() {
		int cantTotalArticulos = 0;
		double cantTotalPrecios = 0;
		for (int i = 0; i < cantTotalProductos; i++) {
			cantTotalArticulos += cantidadProducto[i];
			cantTotalPrecios += precioProducto[i];
		}
		double ivaReal = (cantTotalPrecios * (IVA / 100));
		System.out.println("Cantidad total bruta: " + (cantTotalPrecios + ivaReal));
		System.out.println("Cantitad total neta: " + cantTotalPrecios);
		System.out.println("Cantidad de mercancia");
		System.out.println(cantTotalArticulos);
		System.out.println("Producto mas costoso");
		System.out.println(nombreMasCostoso);
		System.out.println("Producto menos costoso");
		System.out.println(nombreMenosCostoso);
		System.out.println("Producto con mayor cantidad de extistencia");
		System.out.println(nombreMayorCant);
		System.out.println("Producto con menor cantidad de existencia");
		System.out.println(nombreMenorCant);
		System.out.println("Productos con existencia 0:");
		for (int k = 0; k < cantTotalProductos; k++) {
			if (cantidadProducto[k] == 0) {
				System.out.println(nombreProducto[k] + " " + cantidadProducto[k]);
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
					productoMasCostoso = Double.MIN_VALUE;
					productoMenosCostoso = Double.MAX_VALUE;
					for (int k = 0; k < cantTotalProductos; k++) {
						if (precioProducto[k] > productoMasCostoso) {
							productoMasCostoso = precioProducto[k];
							nombreMasCostoso = nombreProducto[k];
						}
						if (precioProducto[k] < productoMenosCostoso) {
							productoMenosCostoso = precioProducto[k];
							nombreMenosCostoso = nombreProducto[k];
						}
					}

				} else if (opcion == 3) {
					System.out.println("Ingrese la nueva cantidad de articulos en existencia del producto");
					cantidadProducto[i] = scan.nextInt();
					mayorCantArticulos = Integer.MIN_VALUE;
					menorCantArticulos = Integer.MAX_VALUE;
					for (int k = 0; k < cantTotalProductos; k++) {
						if (cantidadProducto[k] > mayorCantArticulos) {
							mayorCantArticulos = cantidadProducto[k];
							nombreMayorCant = nombreProducto[k];
						}
						if (cantidadProducto[k] < menorCantArticulos) {
							menorCantArticulos = cantidadProducto[k];
							nombreMenorCant = nombreProducto[k];
						}
					}

				} else if (opcion == 4) {
				} else {
					System.out.println("Error- ingrese una opcion valida");
				}
			}
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

}
