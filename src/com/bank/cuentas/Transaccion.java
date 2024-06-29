package com.bank.cuentas;

public class Transaccion extends Cuentas {
	private int transaccion;
	private int tipo;

	@Override
	public void salir() {

	}

	public int getTransaccion() {
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
