package com.pablo.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
	private double iva;
	private double tasa;
	private Scanner scan = new Scanner(System.in);
	private final ArrayList<Producto> productos;

	public Inventario(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public void listadoInvetario() {
		for (Producto productosInventario : productos) {
			System.out.println("------------------------------");
			System.out.println("Nombre: " + productosInventario.getDescripcion());
			System.out.println("Codigo: " + productosInventario.getCodigo());
			System.out.println("Cantidad: " + productosInventario.getCantidad());
			System.out.println("Precio: " + productosInventario.getPrecio());
			System.out.println("--------------------------------");
		}
	}

	public void listadoProductosMasMenosCostoso(double masMenosCostoso) {
		for (Producto productosCostosos : productos) {
			if (masMenosCostoso == productosCostosos.getPrecio()) {
				System.out.println(productosCostosos.getDescripcion() + " " + productosCostosos.getCodigo());
			}
		}
	}

	public void listadoProductosMasMenosCant(int masMenosCant) {
		for (Producto productosCantidad : productos) {
			if (masMenosCant == productosCantidad.getCantidad()) {
				System.out.println(productosCantidad.getDescripcion() + " " + productosCantidad.getCodigo());
			}
		}
	}

	public void modificarInventario(String codigo) {
		for (Producto modificar : productos) {
			if (codigo.equals(modificar.getCodigo())) {
				System.out.println("Nombre " + modificar.getDescripcion());
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
					modificar.setDescripcion(nuevoCodigo);
					System.out.println("El nuevo nombre es : " + modificar.getDescripcion());
				} else if (opc == 2) {
					System.out.println("Precio");
					System.out.println("Ingrese el nuevo Precio");
					Double nuevoPrecio = scan.nextDouble();
					modificar.setPrecio(nuevoPrecio);
					System.out.println("El nuevo Precio es : " + modificar.getPrecio() + "$");
				} else if (opc == 3) {
					System.out.println("Cantidad");
					System.out.println("Ingrese la nueva Cantidad");
					int nuevaCantidad = scan.nextInt();
					modificar.setCantidad(nuevaCantidad);
					System.out.println("La nueva cantidad es: " + modificar.getCantidad());
				}
			}
		}
	}

	public void encontrarCodigo(String codigo) {
		for (Producto encontrar : productos) {
			if (codigo.equals(encontrar.getCodigo())) {
				System.out.println("Nombre " + encontrar.getDescripcion());
			}
		}
	}

	public Producto encontrarCodigoProducto(String codigo) {
		Producto busqueda = null;
		for (Producto encontrar : productos) {
			if (codigo.equals(encontrar.getCodigo())) {
				busqueda = encontrar;
			}
		}
		return busqueda;
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
			System.out.println("El iva actual es: " + getIva());
			System.out.println("Ingrese la nueva tasa");
			double iva = scan.nextDouble();
			setIva(iva);
		}

	}

	public double totalNeto() {
		double neto = 0;
		for (Producto inventarioNeto : productos) {
			neto += inventarioNeto.getPrecio() * inventarioNeto.getCantidad();
		}
		return neto;
	}

	public double totalBruto() {
		double bruto = totalNeto() * getIva();
		return bruto;
	}

	public double totalNetoBs(double totalNeto) {
		double netoBs = totalNeto * getTasa();
		return netoBs;
	}

	public void estadisticas() {
		double productoMasCostoso = 0;
		double productoMenosCostos = Double.MAX_VALUE;
		int productoMayorCant = 0;
		int productoMenorCant = Integer.MAX_VALUE;
		for (Producto inventarioEstadisticas : productos) {
			if (inventarioEstadisticas.getPrecio() > productoMasCostoso) {
				productoMasCostoso = inventarioEstadisticas.getPrecio();
			}
			if (inventarioEstadisticas.getPrecio() < productoMenosCostos) {
				productoMenosCostos = inventarioEstadisticas.getPrecio();
			}
			if (inventarioEstadisticas.getCantidad() > productoMayorCant) {
				productoMayorCant = inventarioEstadisticas.getCantidad();
			}
			if (inventarioEstadisticas.getCantidad() < productoMenorCant) {
				productoMenorCant = inventarioEstadisticas.getCantidad();
			}
		}
		System.out.println("Los productos mas costosos son: ");
		listadoProductosMasMenosCostoso(productoMasCostoso);
		System.out.println("Los productos menos costosos son: ");
		listadoProductosMasMenosCostoso(productoMenosCostos);
		System.out.println("Los productos con mayor cantidades son: ");
		listadoProductosMasMenosCant(productoMayorCant);
		System.out.println("Los productos con menor cantidades son:");
		listadoProductosMasMenosCant(productoMenorCant);
		System.out.println("Total neto: " + totalNeto());
		System.out.println("Total netoBs:" + totalNetoBs(totalNeto()));
		System.out.println("Total Bruto " + totalBruto());
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

}
