package com.pablo.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
	private double iva;
	private double tasa;
	private Scanner scan = new Scanner(System.in);

	public void agregarInventario(ArrayList<Producto> inventarioProductos,String descripcion,String codigo, int cantidad, double precio) {
		inventarioProductos.add(new Producto(descripcion, codigo, cantidad, precio));
	}

	public void listadoInvetario(ArrayList<Producto> inventarioProductos) {
		for (int i = 0; i < inventarioProductos.size(); i++) {
			System.out.println("-------------------------------");
			System.out.println("Nombre " + inventarioProductos.get(i).getDescripcion());
			System.out.println("Codigo " + inventarioProductos.get(i).getCodigo());
			System.out.println("Cantidad " + inventarioProductos.get(i).getCantidad());
			System.out.println("Precio " + inventarioProductos.get(i).getPrecio());
			System.out.println("-------------------------------");
		}
	}

	public void listadoProductosMasMenosCostoso(ArrayList<Producto> inventarioProductos, double masMenosCostoso) {
		for (int i = 0; i < inventarioProductos.size(); i++) {
			if (masMenosCostoso == inventarioProductos.get(i).getPrecio()) {
				System.out.println("Nombre " + inventarioProductos.get(i).getDescripcion());
			}
		}
	}

	public void listadoProductosMasMenosCant(ArrayList<Producto> inventarioProductos, int masMenosCant) {
		for (int i = 0; i < inventarioProductos.size(); i++) {
			if (masMenosCant == inventarioProductos.get(i).getCantidad()) {
				System.out.println("Nombre " + inventarioProductos.get(i).getDescripcion());
			}
		}
	}

	public void modificarInventario(ArrayList<Producto> inventarioProductos, String codigo) {
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
				} else if (opc == 2) {
					System.out.println("Precio");
					System.out.println("Ingrese el nuevo Precio");
					Double nuevoPrecio = scan.nextDouble();
					inventarioProductos.get(i).setPrecio(nuevoPrecio);
					System.out.println("El nuevo Precio es : " + inventarioProductos.get(i).getPrecio());
				} else if (opc == 3) {
					System.out.println("Cantidad");
					System.out.println("Ingrese la nueva Cantidad");
					int nuevaCantidad = scan.nextInt();
					inventarioProductos.get(i).setCantidad(nuevaCantidad);
					System.out.println("La nueva cantidad es: " + inventarioProductos.get(i).getCantidad());
				}
			}
		}
	}

	public void encontrarCodigo(ArrayList<Producto> inventarioProductos, String codigo) {
		for (int i = 0; i < inventarioProductos.size(); i++) {
			if (codigo.equals(inventarioProductos.get(i).getCodigo())) {
				System.out.println("Nombre " + inventarioProductos.get(i).getDescripcion());
			}
		}
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public void configuracion() {
		System.out.println("Que desea configurar");
		System.out.println("1-Tasa conversion ");
		System.out.println("2- Iva");
		int opc = scan.nextInt();
		if (opc == 1) {
			System.out.println("La tasa actual es: " + getTasa());
			System.out.println("Ingrese la nueva tasa");
			double tasaBs = scan.nextDouble();
			setTasa(tasaBs);
		} else if (opc == 2) {
			System.out.println("El iva actual es: " + getTasa());
			System.out.println("Ingrese la nueva tasa");
			double iva = scan.nextDouble();
			setIva(iva);
		}

	}

	public double totalNeto(ArrayList<Producto> inventarioProductos) {
		double neto = 0;
		for (int i = 0; i < inventarioProductos.size(); i++) {
			neto += inventarioProductos.get(i).getPrecio() * inventarioProductos.get(i).getCantidad();
		}
		return neto;
	}

	public double totalNetoBs(double totalNeto) {
		double netoBs = totalNeto * getTasa();
		return netoBs;
	}

	public void estadisticas(ArrayList<Producto> inventarioProductos) {
		double productoMasCostoso = 0;
		double productoMenosCostos = Double.MAX_VALUE;
		int productoMayorCant = 0;
		int productoMenorCant = Integer.MAX_VALUE;
		for (int i = 0; i < inventarioProductos.size(); i++) {
			if (inventarioProductos.get(i).getPrecio() > productoMasCostoso) {
				productoMasCostoso = inventarioProductos.get(i).getPrecio();
			}
			if (inventarioProductos.get(i).getPrecio() < productoMenosCostos) {
				productoMenosCostos = inventarioProductos.get(i).getPrecio();
			}
			if (inventarioProductos.get(i).getCantidad() > productoMayorCant) {
				productoMayorCant = inventarioProductos.get(i).getCantidad();
			}
			if (inventarioProductos.get(i).getCantidad() < productoMenorCant) {
				productoMenorCant = inventarioProductos.get(i).getCantidad();
			}
		}
		System.out.println("Los productos mas costosos son: ");
		listadoProductosMasMenosCostoso(inventarioProductos, productoMasCostoso);
		System.out.println("Los productos menos costosos son: ");
		listadoProductosMasMenosCostoso(inventarioProductos, productoMenosCostos);
		System.out.println("Los productos con mayor cantidades son: ");
		listadoProductosMasMenosCant(inventarioProductos, productoMayorCant);
		System.out.println("Los productos con menor cantidades son:");
		listadoProductosMasMenosCant(inventarioProductos, productoMenorCant);
		System.out.println("Total neto: " + totalNeto(inventarioProductos));
		System.out.println("Total netoBs:" + totalNetoBs(totalNeto(inventarioProductos)));
	}
}
