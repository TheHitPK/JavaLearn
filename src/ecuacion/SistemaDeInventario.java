package ecuacion;

import java.util.Scanner;

public class SistemaDeInventario {
	static Scanner scan = new Scanner(System.in);
	// variable
	static int cantTotalProductos = 0;
	static double IVA = 16, tasa = 36;
	static double ivaReal = IVA / 100;
	// ARRAYSGemerañes
	static String descripcionProducto[] = new String[99];
	static String codigoProducto[] = new String[99];
	// static String sexoEstudiante[] = new String[99];
	static int excento[] = new int[99];
	static int tipoProducto[] = new int[99];
	static int cantProductosAgregado[] = new int[99];
	static double precioProducto[] = new double[99];

	public static void main(String[] args) {
		boolean programa = false;
		do {
			System.out.println("MENU");
			System.out.println("1- Agregar Producto.");
			System.out.println("2- Modificar datos del Producto.");
			System.out.println("3- Listado de Productos.");
			System.out.println("4- Buscar por codigo");
			System.out.println("5- Estadistica.");
			System.out.println("6- Configuracion");
			System.out.println("7- Salir.");
			int opc = scan.nextInt();

			// MENU PRINCIPAL
			if (opc == 1) {
				do {
					System.out.println("Agregar Producto.");
					System.out.println("Ingrese la cantidad de productos a ingresar");
					int cantArticulos = scan.nextInt();
					// agregarProducto(cantArticulos);
					System.out.println("Desea continuar o volver al menu?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 2) {
				do {
					System.out.println("MODIFICAR PRODUCTOS");
					modificarProducto(cantTotalProductos);
					System.out.println("Desea continuar modificando?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 3) {
				do {
					System.out.println(" Listado de PRODUCTOS.");
					listado();
					System.out.println("Desea continuar viendo?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 4) {
				do {
					System.out.println("Buscar por Codigo");
					buscarPorCodigo();
					System.out.println("Desea continuar viendo?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 5) {
				do {
					System.out.println(" ESTADISTICAS");
					estadisticaInventario();
					System.out.println("Desea continuar viendo?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 6) {
				do {
					System.out.println("CONFIGURACIONES");
					configuracion();
					System.out.println("Desea continuar viendo?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 7) {
				System.out.println("Esta seguro que desea salir?");
				System.out.println("Si- 1 \t No-0");
				opc = scan.nextInt();
				if (opc == 1) {
					programa = true;
				}
			} else {
				System.out.println("Opcion incorrecta");
			}
		} while (programa == false);

	}



	static String verificarCodigo(int cantTotalProductos) {
		String codigo = scan.nextLine();
		for (int i = 0; i < cantTotalProductos; i++) {
			while (codigo.equals(codigoProducto[i])) {
				System.out.println("Codigo repetido, Ingrese un codigo Valido");
				codigo = scan.nextLine();
			}
		}
		return codigo;
	}

	static void buscarPorCodigo() {
		scan.nextLine();
		System.out.println("Ingrese el codigo del producto que desea visualizar");
		String codigo = scan.nextLine();
		for (int i = 0; i < cantTotalProductos; i++) {
			if (codigo.equals(codigoProducto[i])) {
				System.out.println("CODIGO: " + codigoProducto[i]);
				System.out.println("Descripcion:" + descripcionProducto[i]);
				mostrarExcento(i);
				mostrarTipo(i);
			}
		}
	}

	static void listado() {
		for (int i = 0; i < cantTotalProductos; i++) {
			System.out.println("CODIGO: " + codigoProducto[i]);
			System.out.println("Descripcion:" + descripcionProducto[i]);
			mostrarExcento(i);
			mostrarTipo(i);
		}
	}

	static void mostrarTipo(int i) {
		System.out.print("Tipo de Producto: ");
		if (tipoProducto[i] == 1) {
			System.out.println("Frutas y Verduras");
		} else if (tipoProducto[i] == 2) {
			System.out.println("Licores y Bebidas");
		} else if (tipoProducto[i] == 3) {
			System.out.println("Comida");
		} else if (tipoProducto[i] == 4) {
			System.out.println("Otros");
		}

		System.out.println("---------------------------");
	}

	static void configuracion() {
		System.out.println("Desea modificar El IVA o la Tasa BS");
		System.out.println("1- IVA");
		System.out.println("2- Tasa BS");
		int opcion = scan.nextInt();
		if (opcion == 1) {
			System.out.println("Ingrese el porcentaje del IVA correcto");
			IVA = scan.nextDouble();
			ivaReal = IVA / 100;
			System.out.println("IVA ACTUALIZADO: " + IVA);
			System.out.println(ivaReal);
		} else if (opcion == 2) {
			System.out.println("Ingrese la tasa Actualizada");
			tasa = scan.nextDouble();
			System.out.println("TASA ACTUALIZADA: " + tasa);
		}
	}

	static void mostrarExcento(int i) {

		if (excento[i] == 1) {
			double sumaIva = precioProducto[i] * ivaReal;
			System.out.println("Precio sin Iva:" + precioProducto[i] + "$");
			System.out.println("Precio sin Iva en Bolivares:" + (precioProducto[i] * tasa) + "BS");
			System.out.println("Precio con Iva: " + (precioProducto[i] + sumaIva) + "$");
			System.out.println("Precio Bolivares: " + ((precioProducto[i] + sumaIva) * tasa) + "BS");
			System.out.println("No excento de IVA");
		} else {
			System.out.println("Precio: " + precioProducto[i] + "$");
			System.out.println("Precio Bolivares: " + (precioProducto[i] * tasa) + "BS");
			System.out.println("Excento de IVA");
		}
	}

	static double verficarPrecio() {
		double precio = scan.nextDouble();
		while (precio < 0) {
			System.out.println("Error, precio negativo");
			precio = scan.nextDouble();
		}
		return precio;
	}

	static void eleccionTipoProducto(int cantTotalProducto) {
		boolean continuar;
		do {
			continuar = false;
			System.out.println("Ingrese que tipo el el producto?");
			System.out.println("1- Frutas y verduras");
			System.out.println("2- Licores y Bebidas");
			System.out.println("3- Comida");
			System.out.println("4 Otros");
			int eleccion = scan.nextInt();
			if (eleccion == 1) {
				System.out.println("Tipo: Frutas y Verduras");
				tipoProducto[cantTotalProducto] = eleccion;
			} else if (eleccion == 2) {
				System.out.println("Tipo: Licores y Bebidas");
				tipoProducto[cantTotalProducto] = eleccion;
			} else if (eleccion == 3) {
				System.out.println("Tipo: Comida");
				tipoProducto[cantTotalProducto] = eleccion;
			} else if (eleccion == 4) {
				System.out.println("Tipo: Otros");
				tipoProducto[cantTotalProducto] = eleccion;
			} else {
				System.out.println("Eleccion incorrecta");
				continuar = true;
			}

		} while (continuar == true);

	}

	static void eleccionExcento(int cantTotalProducto) {
		boolean continuar;
		do {
			continuar = false;
			System.out.println("Indique si el producto es excento de IVA o no");
			System.out.println("1- No \t  0-Si ");
			int eleccion = scan.nextInt();
			if (eleccion == 0) {
				System.out.println("Producto Excento de IVA");
				excento[cantTotalProducto] = eleccion;
			} else if (eleccion == 1) {
				System.out.println("Producto No Excento de IVA");
				excento[cantTotalProducto] = eleccion;
			} else {
				System.out.println("Eleccion incorrecta");
				continuar = true;
			}

		} while (continuar == true);
	}

	static void modificarProducto(int cantTotalProductos) {
		System.out.println("Ingrese el codigo del producto que desea modificar");
		scan.nextLine();
		String codigo = scan.nextLine();
		boolean continuar;
		for (int i = 0; i < cantTotalProductos; i++) {
			if (codigo.equals(codigoProducto[i])) {
				do {
					continuar = false;
					System.out.println("El estudiante es: " + descripcionProducto[i]);
					System.out.println("Que desea modificar?");
					System.out.println("1- Nombre");
					System.out.println("2- Precio");
					System.out.println("3- Cantidad");
					System.out.println("4- Excento");
					System.out.println("5- Tipo");
					int opcion = scan.nextInt();
					if (opcion == 1) {
						scan.nextLine();
						System.out.println("NOMBRE");
						System.out.println("Ingrese el nombre nuevo");
						descripcionProducto[i] = scan.nextLine();
						System.out.println("El nuevo nombre es : " + descripcionProducto[i]);
					} else if (opcion == 2) {
						scan.nextLine();
						System.out.println("PRECIO");
						System.out.println("Ingrese el precio");
						precioProducto[i] = verficarPrecio();
						System.out.println("El nuevo precio es : " + precioProducto[i]);
					} else if (opcion == 3) {
						scan.nextLine();
						System.out.println("CANTIDAD");
						System.out.println("Ingrese la cantidad correcta");
						cantProductosAgregado[i] = scan.nextInt();
						System.out.println("La cantidad nueva es: " + cantProductosAgregado[i]);
					} else if (opcion == 4) {
						System.out.println("EXCENTO");
						System.out.println("Ingrese correctamente los datos");
						eleccionExcento(i);
					} else if (opcion == 5) {
						System.out.println("MATERIA");
						System.out.println("Eliga correctamente la materia que cursa el estudiante");
						eleccionTipoProducto(i);
					} else {
						System.out.println("Codigo no registrado");
						System.out.println("Desea volver al menu o ingresar un codigo?");
						System.out.println("1- Menu     2-Codigo valido");
						int opc = scan.nextInt();
						if (opc != 1) {
							continuar = true;
						}
					}
				} while (continuar == true);

			}
		}
	}

	static void estadisticaInventario() {
		calculoTotalBruto_Neto();
		int sumaCant = 0;
		for (int i = 0; i < cantTotalProductos; i++) {
			sumaCant += cantProductosAgregado[i];
		}
		System.out.println("Cantidad Total de productos: " + sumaCant);
		System.out.println("Cantidad total de productos que sean Frutas y Verduras: ");
		cantTipoProducto(1, tipoProducto);
		System.out.println("Cantidad total de productos que sean Licores o Bebidas: ");
		cantTipoProducto(2, tipoProducto);
		System.out.println("Cantidad total de productos que sean Comida: ");
		cantTipoProducto(3, tipoProducto);
		System.out.println("Cantidad total de productos que sean OTROS: ");
		cantTipoProducto(4, tipoProducto);
		masMenosCostoso();
		mayorMenorCant();
		System.out.println("Excentos");
		listadoCondicion(0, excento);
		System.out.println("Productos Existencia 0");
		listadoCondicion(0, cantProductosAgregado);

	}

	static void mayorMenorCant() {
		int mayorCant = 0;
		int menorCant = 120;
		for (int i = 0; i < cantTotalProductos; i++) {
			if (cantProductosAgregado[i] > mayorCant) {
				mayorCant = cantProductosAgregado[i];
			}

			if (cantProductosAgregado[i] < menorCant) {
				menorCant = cantProductosAgregado[i];
			}
		}
		System.out.println("Productos con MAYOR CANTIDAD: " + mayorCant);
		listadoCondicion(mayorCant, cantProductosAgregado);
		System.out.println("Productos con MENOR CANTIDAD: " + menorCant);
		listadoCondicion(menorCant, cantProductosAgregado);
	}

	static void masMenosCostoso() {
		double masCostoso = 0;
		double menosCostoso = 120;
		for (int i = 0; i < cantTotalProductos; i++) {
			if (precioProducto[i] > masCostoso) {
				masCostoso = precioProducto[i];
			}

			if (precioProducto[i] < menosCostoso) {
				menosCostoso = precioProducto[i];
			}
		}
		System.out.println("Productos mas costoso: ");
		for (int i = 0; i < cantTotalProductos; i++) {
			if (masCostoso == precioProducto[i]) {
				System.out.println("CODIGO: " + codigoProducto[i]);
				System.out.println("Descripcion:" + descripcionProducto[i]);
				mostrarExcento(i);
				mostrarTipo(i);
			}
		}
		System.out.println("Productos menos costoso: ");
		for (int i = 0; i < cantTotalProductos; i++) {
			if (menosCostoso == precioProducto[i]) {
				System.out.println("CODIGO: " + codigoProducto[i]);
				System.out.println("Descripcion:" + descripcionProducto[i]);
				mostrarExcento(i);
				mostrarTipo(i);
			}
		}

	}

	static void cantTipoProducto(int tipo, int tipoProducto[]) {
		int canTotalProductoTipo = 0;
		for (int i = 0; i < cantTotalProductos; i++) {
			if (tipoProducto[i] == tipo) {
				canTotalProductoTipo += cantProductosAgregado[i];
			}
		}
		System.out.println(canTotalProductoTipo);
	}

	static void calculoTotalBruto_Neto() {
		double neto = 0;
		double bruto = 0;
		for (int i = 0; i < cantTotalProductos; i++) {
			neto += precioProducto[i] * cantProductosAgregado[i];
			if (excento[i] == 1) {
				double sumaIva = 0;
				double precioIva = 0;
				sumaIva = precioProducto[i] * ivaReal;
				precioIva = precioProducto[i] + sumaIva;
				bruto += precioIva * cantProductosAgregado[i];
			} else {
				bruto += precioProducto[i] * cantProductosAgregado[i];
			}
		}
		System.out.println("Total neto: " + neto);
		System.out.println("Total neto en Bs: " + (neto * tasa) + "BS");
		System.out.println("Total bruto: " + bruto);
		System.out.println("Total Bruto en Bs: " + (bruto * tasa) + "BS");
	}

	static void listadoCondicion(int tipo, int arrayTipo[]) {
		for (int i = 0; i < cantTotalProductos; i++) {
			if (arrayTipo[i] == tipo) {
				System.out.println("CODIGO: " + codigoProducto[i]);
				System.out.println("Descripcion:" + descripcionProducto[i]);
				mostrarExcento(i);
				mostrarTipo(i);
			}
		}
	}

}
