package com.bank.cuentas;

public abstract class Cuentas {
	private String usuario;
	private String contraseña;
	private String correo;

	public Cuentas(String usuario, String contraseña, String correo) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
	}

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
