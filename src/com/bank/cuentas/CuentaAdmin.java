package com.bank.cuentas;

import java.util.ArrayList;

public class CuentaAdmin extends Cuentas {
	private double tasa;
	private ArrayList<CuentaUsuario> listadoUsuarios;

	public CuentaAdmin(String usuario, String contraseña, String correo) {
		super(usuario, contraseña, correo);
	}

	public ArrayList<CuentaUsuario> getListadoUsuarios() {
		return listadoUsuarios;
	}

	public void setListadoUsuarios(ArrayList<CuentaUsuario> listadoUsuarios) {
		this.listadoUsuarios = listadoUsuarios;
	}

	public void listadoUsuarios(ArrayList<CuentaUsuario> listadoUsuarios) {
		for (CuentaUsuario listado : listadoUsuarios) {
			System.out.println("Nombre: " + listado.getNombre());
			System.out.println("Telefono: " + listado.getTelefono());
			System.out.println("Cedula: " + listado.getCedula());
		}
	}

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public void historialTranscacciones(ArrayList<Transaccion> transacciones) {
		System.out.println("HISTORIAL COMPLETO");
		int numTransacciones = 1;
		int totalCobres = 0;
		for (Transaccion historial : transacciones) {

			System.out.println("Transaccion " + numTransacciones);
			if (historial.getTipo() == 1) {
				historial.mostrarDeposito();
				totalCobres += historial.getTransaccion();
			} else if (historial.getTipo() == 2) {
				historial.mostrarTransferencia();
				totalCobres += historial.getTransaccion();
			} else if (historial.getTipo() == 3) {
				historial.mostrarRetiro();
				totalCobres += historial.getTransaccion();
			} else if (historial.getTipo() == 4) {
				historial.mostrarPagoMovil();
				totalCobres += historial.getTransaccion();
			}
			numTransacciones++;
		}
		System.out.println("Saldo total en el banco: " + totalCobres);
	}

	public void actualizarHistorial(ArrayList<Transaccion> transacciones) {
		System.out.println("HISTORIAL COMPLETO");
		int numTransacciones = 1;
		int totalCobres = 0;
		int cantTransfer = 0;
		int cantDeposito = 0;
		int cantRetiros = 0;
		int cantPagoMovil = 0;
		for (Transaccion historial : transacciones) {
			System.out.println("Transaccion " + numTransacciones);
			if (historial.getTipo() == 1) {
				totalCobres += historial.getTransaccion();
				cantDeposito++;
			} else if (historial.getTipo() == 2) {
				totalCobres += historial.getTransaccion();
				cantTransfer++;
			} else if (historial.getTipo() == 3) {
				totalCobres += historial.getTransaccion();
				cantRetiros++;
			} else if (historial.getTipo() == 4) {
				totalCobres += historial.getTransaccion();
				cantPagoMovil++;
			}
			numTransacciones++;
		}
		System.out.println("Cantidad de depositos: " + cantDeposito);
		System.out.println("Cantidad de transferencias: " + cantTransfer);
		System.out.println("Cantidad de Retiros: " + cantRetiros);
		System.out.println("Cantidad de Pago moviles: " + cantPagoMovil);
		System.out.println("Saldo total en el banco: " + totalCobres);
		System.out.println("Saldo total en el banco en BS: " + (totalCobres * getTasa()));
	}

	public double totalBoveda(ArrayList<Transaccion> transacciones) {
		System.out.println("HISTORIAL COMPLETO");
		int numTransacciones = 1;
		int totalCobres = 0;
		for (Transaccion historial : transacciones) {
			if (historial.getTipo() == 1) {
				// historial.mostrarDeposito();
				totalCobres += historial.getTransaccion();
			} else if (historial.getTipo() == 2) {
				// historial.mostrarTransferencia();
				totalCobres += historial.getTransaccion();
			} else if (historial.getTipo() == 3) {
				// historial.mostrarRetiro();
				totalCobres += historial.getTransaccion();
			} else if (historial.getTipo() == 4) {
				// historial.mostrarPagoMovil();
				totalCobres += historial.getTransaccion();
			}
			numTransacciones++;
		}
		return totalCobres;
	}
}

