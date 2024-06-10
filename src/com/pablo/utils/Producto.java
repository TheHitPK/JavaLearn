package com.pablo.utils;

public class Producto {
	// Atributos
	private String descripcion;
	private String codigo;
	private int cantidad;
	private double precio$;
	private double precioBs;
	private double iva;
	private double tasa;

	// METODO CONSTRUCTOR
	public Producto(String descripcion, String codigo, int cantidad, double precio$) {
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.precio$ = precio$;


	}

	// SETTERS
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecio(double precio) {
		this.precio$ = precio;
	}

	// GETTERS
	public String getDescripcion() {
		return descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecio() {
		return precio$;
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

	public double getPrecioBs() {
		return precioBs;
	}

	public void setPrecioBs(double precioBs) {
		this.precioBs = precioBs;
	}
}
