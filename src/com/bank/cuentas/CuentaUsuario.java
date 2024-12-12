package com.bank.cuentas;

import java.util.ArrayList;
import java.util.Scanner;

public class CuentaUsuario extends Cuentas {
	private String nombre;
	private String cedula;
	private String telefono;
	private double tasa;
	private ArrayList<Transaccion> transacciones;
	private ArrayList<CuentaUsuario> listadoUsuarios;

	public CuentaUsuario(String nombre, String cedula, String telefono, String usuario, String contraseña,
			String correo) {
		super(usuario, contraseña, correo);
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		setTransacciones(crearTransacciones());
	}

	public ArrayList<Transaccion> crearTransacciones() {
		ArrayList<Transaccion> creacionTransacciones = new ArrayList<>();
		return creacionTransacciones;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(ArrayList<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public void depositar(ArrayList<Transaccion> historial, Scanner scan, int tipo) {
		System.out.println("Ingrese el monto a depositar a la cuenta");
		int deposito = scan.nextInt();

		transacciones.add(new Transaccion(getNombre(), getCedula(), getTelefono(), getUsuario(), getContraseña(),
				getCorreo(), deposito, tipo));
		historial.add(new Transaccion(getNombre(), getCedula(), getTelefono(), getUsuario(), getContraseña(),
				getCorreo(), deposito, tipo));
	}

	public void transferir(ArrayList<CuentaUsuario> listadoUsuarios, ArrayList<Transaccion> historial, Scanner scan,
			int tipo) {
		scan.nextLine();
		System.out.println("Ingrese los datos de la cuenta a transferir");
		System.out.print("CEDULA: ");
		String cedula = scan.nextLine();
		System.out.print("Usuario o correo: ");
		String user_mail = scan.nextLine();
		for (CuentaUsuario corroboro : listadoUsuarios) {
			if (cedula.equals(corroboro.getCedula())
					&& (user_mail.equals(corroboro.getUsuario()) || user_mail.equals(corroboro.getCorreo()))) {
				System.out.println("Ingrese el monto a transferir");
				int monto = scan.nextInt();
				corroboro.getTransacciones().add(new Transaccion(getNombre(), getCedula(), getTelefono(), getUsuario(),
						getContraseña(), getCorreo(), monto, tipo));
				historial.add(new Transaccion(corroboro.getNombre(), corroboro.getCedula(), corroboro.getTelefono(),
						corroboro.getUsuario(), corroboro.getContraseña(), corroboro.getCorreo(), monto, tipo));
				monto *= -1;
				transacciones.add(new Transaccion(getNombre(), getCedula(), getTelefono(), getUsuario(),
						getContraseña(), getCorreo(), monto, tipo));
				historial.add(new Transaccion(getNombre(), getCedula(), getTelefono(), getUsuario(), getContraseña(),
						getCorreo(), monto, tipo));
			}
		}

	}

	public void historial(double tasa) {
		double saldoTotal = 0;
		for (Transaccion listadoTransacciones : transacciones) {
			System.out.println("Monto");
			System.out.println(listadoTransacciones.getTransaccion());
			saldoTotal += listadoTransacciones.getTransaccion();
		}
		System.out.println("DISPONIBLE EN CUENTA: ");
		System.out.println(saldoTotal);
		System.out.println("DISPONIBLE EN Cuenta en BS: " + (saldoTotal * tasa));

	}

	public void verInfo(double tasa) {
		System.out.println("Nombre: " + getNombre());
		System.out.println("Cedula:" + getCedula());
		System.out.println("Correo: " + getCorreo());
		System.out.println("Usuario: " + getUsuario());
		System.out.println("Contraseña: " + getContraseña());
		System.out.println("Telefono: " + getTelefono());
		System.out.println("USUARIO");
		System.out.println("HISTORIAL DE TRANSACCIONES");
		historial(tasa);
	}

	public void retirar(Scanner scan, int tipo, ArrayList<Transaccion> historial) {
		System.out.println("Ingrese el monto que desea retirar");
		int retiro = scan.nextInt();
		retiro *= -1;
		historial.add(new Transaccion(getNombre(), getCedula(), getTelefono(), getUsuario(), getContraseña(),
				getCorreo(), retiro, tipo));
		transacciones.add(new Transaccion(getNombre(), getCedula(), getTelefono(), getUsuario(), getContraseña(),
				getCorreo(), retiro, tipo));
	}

	public void pagoMovil(ArrayList<CuentaUsuario> listadoUsuarios, ArrayList<Transaccion> historial, Scanner scan,
			int tipo) {
		scan.nextLine();
		System.out.println("Ingrese los datos del pago movil a transferir");
		System.out.print("CEDULA: ");
		String cedula = scan.nextLine();
		System.out.print("Usuario o correo: ");
		String telefono = scan.nextLine();
		for (CuentaUsuario corroboro : listadoUsuarios) {
			if (cedula.equals(corroboro.getCedula()) && telefono.equals(corroboro.getTelefono())) {
				System.out.println("Ingrese el monto a transferir");
				int monto = scan.nextInt();
				corroboro.getTransacciones().add(new Transaccion(getNombre(), getCedula(), getTelefono(), getUsuario(),
						getContraseña(), getCorreo(), monto, tipo));
				monto *= -1;
				historial.add(new Transaccion(getNombre(), getCedula(), getTelefono(), getUsuario(), getContraseña(),
						getCorreo(), monto, tipo));
				transacciones.add(new Transaccion(getNombre(), getCedula(), getTelefono(), getUsuario(),
						getContraseña(), getCorreo(), monto, tipo));
			}
		}

	}

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
}
