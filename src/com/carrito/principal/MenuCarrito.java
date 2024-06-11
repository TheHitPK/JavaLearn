package com.carrito.principal;

import java.util.ArrayList;
import java.util.Scanner;

import com.pablo.utils.Inventario;
import com.pablo.utils.Producto;

public class MenuCarrito {
	private static final Scanner scan = new Scanner(System.in);
	static int cantTotalProductos = 0;

	public static void main(String[] args) {
		boolean programa = false;
		ArrayList<Producto> productos = new ArrayList<>();
		Inventario productosInventario = new Inventario();
		do {
			System.out.println("MENU CARRITO DE COMPRAS");
			System.out.println("1- Agregar Producto.");
			System.out.println("2- Modificar datos del Producto.");
			System.out.println("3- Listado de Productos.");
			System.out.println("4- Comprar");
			System.out.println("5- Buscar Factura");
			System.out.println("6- Estadistica.");
			System.out.println("7- Configuracion");
			System.out.println("8- Salir.");
			int opc = scan.nextInt();
			// MENU PRINCIPAL
			if (opc == 1) {
				do {
					System.out.println("Agregar Producto.");
					scan.nextLine();
					System.out.println("Ingrese el nombre");
					String descripcion = scan.nextLine();
					System.out.println("Ingrese el codigo");
					String codigo = scan.nextLine();
					System.out.println("Ingrese la cantidad de articulos del producto");
					int cantidad = scan.nextInt();
					System.out.println("Ingrese el precio de cada articulo");
					double precio = scan.nextDouble();
					productosInventario.agregarInventario(productos, descripcion, codigo, cantidad, precio);
					System.out.println("Desea continuar o volver al menu?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 2) {
				do {
					System.out.println("MODIFICAR PRODUCTOS");
					scan.nextLine();
					System.out.println("Ingrese el codigo del producto a modificar");
					String codigo = scan.nextLine();
					productosInventario.modificarInventario(productos, codigo);
					System.out.println("Desea continuar modificando?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 3) {
				do {
					System.out.println(" Listado de PRODUCTOS.");
					productosInventario.listadoInvetario(productos);
					System.out.println("Desea continuar viendo?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 4) {
				do {
					System.out.println("Buscar por Codigo");
					// buscarPorCodigo();
					System.out.println("Desea continuar viendo?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 5) {
				do {
					System.out.println(" ESTADISTICAS");
					productosInventario.estadisticas(productos);
					System.out.println("Desea continuar viendo?");
					System.out.println("1- Continuar 2-Volver al menu");
					opc = scan.nextInt();
				} while (opc == 1);
			} else if (opc == 6) {
				do {
					System.out.println("CONFIGURACIONES");
					productosInventario.configuracion();
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

}
