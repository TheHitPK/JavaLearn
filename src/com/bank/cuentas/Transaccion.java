package com.bank.cuentas;

public class Transaccion extends CuentaUsuario {
	private double transaccion;
	private int tipo;

	public Transaccion(String nombre, String cedula, String telefono, String usuario, String contraseña, String correo,
			int transaccion, int tipo) {
		super(nombre, cedula, telefono, usuario, contraseña, correo);
		this.transaccion = transaccion;
		this.tipo = tipo;

	}

	public void mostrarTransferencia() {
		System.out.println("TRANSFERENCIA");
		System.out.println("Nombre: " + getNombre());
		System.out.println("Usuario: " + getUsuario());
		System.out.println("Correo: " + getCorreo());
		System.out.println("MONTO: " + getTransaccion());
	}

	public void mostrarPagoMovil() {
		System.out.println("PAGO MOVIL");
		System.out.println("Nombre: " + getNombre());
		System.out.println("Telefono: " + getTelefono());
		System.out.println("Cedula: " + getCedula());
		System.out.println("MONTO: " + getTransaccion());
		System.out.println("-----------------");
		System.out.println("                        ");
	}

	public void mostrarDeposito() {
		System.out.println("DEPOSITO");
		System.out.println("Nombre: " + getNombre());
		System.out.println("Usuario: " + getUsuario());
		System.out.println("MONTO: " + getTransaccion());
		System.out.println("-----------------");
		System.out.println("                        ");
	}

	public void mostrarRetiro() {
		System.out.println("Retiro");
		System.out.println("Nombre: " + getNombre());
		System.out.println("Usuario: " + getUsuario());
		System.out.println("MONTO: " + getTransaccion());
		System.out.println("-----------------");
		System.out.println("                        ");
	}
	public double getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(int transaccion) {
		this.transaccion = transaccion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
