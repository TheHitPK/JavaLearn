package com.bank.cuentas;

import java.util.ArrayList;

public class CuentaAdmin extends Cuentas {
	private int tasa;
	private ArrayList<CuentaUsuario> listadoUsuarios;

	public CuentaAdmin(String usuario, String contraseña, String correo) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
	}

	@Override
	public void salir() {
		// TODO Auto-generated method stub

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

	public int getTasa() {
		return tasa;
	}

	public void setTasa(int tasa) {
		this.tasa = tasa;
	}

	public void historialTranscacciones(ArrayList<Integer> transacciones) {
		System.out.println("HISTORIAL COMPLETO");
		for (Integer xd : transacciones) {
			System.out.println("Montuuuu");
			System.out.println(xd);
		}
	}
}
