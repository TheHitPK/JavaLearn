package com.pablo.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
	private int cantTotalProductos;
	private Scanner scan = new Scanner(System.in);

	public void agregarInventario(ArrayList<Producto> inventarioProductos) {
		System.out.println("Ingrese el nombre:");
		String descripcion = scan.nextLine();
		System.out.println("Ingrese el codigo:");
		String codigo = scan.nextLine();
		System.out.println("Ingrese el precio:");
		double precio = scan.nextDouble();
		System.out.println("Ingrese la cantidad:");
		int cantidad = scan.nextInt();
		inventarioProductos.add(new Producto(descripcion, codigo, cantidad, precio));
	}

	public void listadoInvetario(ArrayList<Producto> inventarioProductos) {
		for (int i = 0; i < inventarioProductos.size(); i++) {
			System.out.println("Nombre " + inventarioProductos.get(i).getDescripcion());
		}
	}

	public void modificarInventario(ArrayList<Producto> inventarioProductos) {
		scan.nextLine();
		System.out.println("Ingrese el codigo del producto a modificar");
		String codigo = scan.nextLine();
		for (int i = 0; i < inventarioProductos.size(); i++) {
			if (codigo.equals(inventarioProductos.get(i).getCodigo())) {
				System.out.println("Nombre " + inventarioProductos.get(i).getDescripcion());
				System.out.println("Que desea modificar?");
				System.out.println("1- nombre");
				System.out.println("2-Precio");
				System.out.println("3- cantidad");
				int opc = scan.nextInt();
				if (opc == 1) {
					scan.nextLine();
					System.out.println("NOMBRE");
					System.out.println("Ingrese el nombre nuevo");
					String nuevoCodigo = scan.nextLine();
					inventarioProductos.get(i).setDescripcion(nuevoCodigo);
					System.out.println("El nuevo nombre es : " + inventarioProductos.get(i).getDescripcion());
				}
			}
		}
	}

	public int getCantTotalProductos() {
		return cantTotalProductos;
	}

	public void setCantTotalProductos(int cantTotalProductos) {
		this.cantTotalProductos = cantTotalProductos;
	}
}
