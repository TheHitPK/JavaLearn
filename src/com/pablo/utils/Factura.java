package com.pablo.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Factura {
	private final String NOMBRE_EMPRESA = "MARHABAB.COM";
	private final String RIF_EMPRESA = "J-50302195-0";
	private String codigoFactura;
	private double iva;
	private double tasa;
	private double subTotal;
	private double total;
	private ArrayList<Producto> productosComprados;
	private ArrayList<Producto> productoSelecionado;
	private ArrayList<Integer> cantidades;
	private ArrayList<Integer> cantTotalProductosFacturados;
	private ArrayList<Double> Precios;
	private Inventario inventario;

	public Factura(ArrayList<Producto> productosComprados, double iva, double tasa, Scanner scan) {
		this.productosComprados = productosComprados;
		this.tasa = tasa;
		this.iva = iva;
		generarFactura(productosComprados, scan);
	}

	public String getNOMBRE_EMPRESA() {
		return NOMBRE_EMPRESA;
	}

	public String getRIF_EMPRESA() {
		return RIF_EMPRESA;
	}

	public String getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(String codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	public String generarCodigo() {
		String base = "00-";
		int estructura = (int) (Math.random() * 10000);
		String codigoGenerado = base + String.valueOf(estructura);
		return codigoGenerado;
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

	public ArrayList<Integer> getCantidades() {
		return cantidades;
	}

	public void setCantidades(ArrayList<Integer> cantidades) {
		this.cantidades = cantidades;
	}

	public ArrayList<Integer> getCantTotalProductosFacturados() {
		return cantTotalProductosFacturados;
	}

	public void setCantTotalProductosFacturados(ArrayList<Integer> cantTotalProductosFacturados) {
		this.cantTotalProductosFacturados = cantTotalProductosFacturados;
	}

	public ArrayList<Double> getPrecios() {
		return Precios;
	}

	public void setPrecios(ArrayList<Double> precios) {
		Precios = precios;
	}

	public Producto productoComprado(String codigo, int cantidad, ArrayList<Producto> iventario,
			ArrayList<Producto> carrito) {
		Producto busqueda = null;
		for (Producto encontrar : iventario) {
			if (codigo.equals(encontrar.getCodigo())) {
				busqueda = new Producto(encontrar.getDescripcion(), encontrar.getCodigo(), cantidad,
						encontrar.getPrecio());
				encontrar.setCantidad(encontrar.getCantidad() - cantidad);
				getCarrito().add(busqueda);
			}
		}
		return busqueda;

	}

	public double subTotal() {
		double subTotal = 0;
		for (Producto subTotales : productoSelecionado) {
			subTotal += subTotales.getPrecio() * subTotales.getCantidad();
		}
		return subTotal;
	}

	public double totalFactura() {
		double totalFactura = subTotal() * getIva();
		return totalFactura;
	}

	public void setCarrito(ArrayList<Producto> productoSelecionado) {
		this.productoSelecionado = productoSelecionado;
	}

	public ArrayList<Producto> getCarrito() {
		return productoSelecionado;
	}

	public void elegirProductos(ArrayList<Producto> iventario, Scanner scan) {
		int opc = 1;
		ArrayList<Producto> seleccion = new ArrayList<>();
		setCarrito(seleccion);
		do {
			System.out.println("Ingrese el codigo:");
			String codigo = scan.nextLine();
			System.out.println("Ingrese la cantidad que desea del producto");
			int cantidad = scan.nextInt();
			productoComprado(codigo, cantidad, iventario, getCarrito());
			System.out.println("1-ya   2-Seguir agregando");
			opc = scan.nextInt();
			scan.nextLine();
		} while (opc == 1);
	}

	public void visualizarProductos(ArrayList<Producto> iventario) {
		for (Producto productosEnCompra : iventario) {
			if (productosEnCompra.getCantidad() != 1) {
				System.out.println("x" + productosEnCompra.getCantidad());
			}
			System.out.println(productosEnCompra.getDescripcion() + " \t "
					+ (productosEnCompra.getCantidad() * productosEnCompra.getPrecio()) + "$");
			System.out.println("                             ");
		}
	}

	public void generarFactura(ArrayList<Producto> iventario, Scanner scan) {
		setCodigoFactura(generarCodigo());
		elegirProductos(iventario, scan);
		setSubTotal(subTotal());
		setTotal(totalFactura());
		mostrarFactura();
	}

	public void mostrarFactura() {
		System.out.println("---------------------------");
		System.out.println(getNOMBRE_EMPRESA());
		System.out.println(getRIF_EMPRESA());
		System.out.println(getCodigoFactura());
		System.out.println("PRODUCTOS: ");
		visualizarProductos(productoSelecionado);
		System.out.println("SUBTOTAL: " + getSubTotal() + "$");
		System.out.println("SUB TOTAL BS: " + (getSubTotal() * getTasa()) + "BS");
		System.out.println("TOTAL: " + getTotal() + "$");
		System.out.println("TOTAL BS: " + (getTotal() * getTasa()) + "BS");
		System.out.println("Tasa de cambio: " + getTasa() + "BS");
		System.out.println("...............................");
		System.out.println("                               ");
		System.out.println("                               ");
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}



}
