package com.bank.cuentas;

import java.util.ArrayList;
import java.util.Scanner;

public class CuentaUsuario extends Cuentas {
	private String nombre;
	private String cedula;
	private String telefono;
	private ArrayList<Integer> transacciones;
	private ArrayList<CuentaUsuario> listadoUsuarios;

	public CuentaUsuario(String nombre, String cedula, String telefono, String usuario, String contraseña,
			String correo) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
		setTransacciones(crearTransacciones());
	}

	public ArrayList<Integer> crearTransacciones() {
		ArrayList<Integer> creacionTransacciones = new ArrayList<Integer>();
		return creacionTransacciones;
	}

	@Override
	public void salir() {
		// TODO Auto-generated method stub

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

	public ArrayList<Integer> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(ArrayList<Integer> transacciones) {
		this.transacciones = transacciones;
	}

	public void depositar(ArrayList<Integer> historial, Scanner scan) {
		System.out.println("Ingrese el monto a depositar a la cuenta");
		int deposito = scan.nextInt();
		transacciones.add(deposito);
		historial.add(deposito);
	}

	public void transferir(ArrayList<CuentaUsuario> listadoUsuarios, Scanner scan) {
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
				corroboro.getTransacciones().add(monto);
				monto *= -1;
				transacciones.add(monto);
			}
		}

	}

	public void historial() {
		int saldoTotal = 0;
		for (int listadoTransacciones : transacciones) {
			System.out.println("Monto");
			System.out.println(listadoTransacciones);
			saldoTotal += listadoTransacciones;
		}
		System.out.println("DISPONIBLE EN CUENTA: ");
		System.out.println(saldoTotal);
	}

	public void verInfo() {
		System.out.print("Nombre: " + getNombre());
		System.out.print("Cedula:" + getCedula());
		System.out.print("Correo: " + getCorreo());
		System.out.print("Usuario: " + getUsuario());
		System.out.print("Contraseña: " + getContraseña());
		System.out.print("Telefono: " + getTelefono());
		System.out.println("USUARIO");
		System.out.println("HISTORIAL DE TRANSACCIONES");
		historial();
	}

	public void retirar(Scanner scan) {
		System.out.println("Ingrese el monto que desea retirar");
		int retiro = scan.nextInt();
		retiro *= -1;
		transacciones.add(retiro);
	}

	public void pagoMovil(ArrayList<CuentaUsuario> listadoUsuarios, Scanner scan) {
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
				corroboro.getTransacciones().add(monto);
				monto *= -1;

				transacciones.add(monto);
			}
		}

	}
}
