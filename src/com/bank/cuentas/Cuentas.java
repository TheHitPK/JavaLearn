package com.bank.cuentas;

public abstract class Cuentas {
	protected String usuario;
	protected String contraseña;
	protected String correo;


	public abstract void salir();

	public String getUsuario() {
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getCorreo() {
		return correo;
	}

}
