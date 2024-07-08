package com.bank.principal;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.cuentas.CuentaAdmin;
import com.bank.cuentas.CuentaUsuario;
import com.bank.cuentas.Transaccion;
public class SistemaBancario {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<CuentaUsuario> listaUsuarios = new ArrayList<>();
		ArrayList<CuentaAdmin> listaAdmin = new ArrayList<>();
		final ArrayList<Transaccion> historialTrans = new ArrayList<>();
		// USUARIO ADMINNISTRADOR
		listaAdmin.add(new CuentaAdmin("admin01", "admin01", "pablot1804"));
		int salir = 0;
		double tasa = 35;
		do {
			int ingresar = 0;
			System.out.println("Sistema bancario");
			System.out.println("1-Iniciar Sesion");
			System.out.println("2-Salir");
			ingresar = scan.nextInt();
			if(ingresar == 1) {
				int menu = 0;
				scan.nextLine();
				System.out.println("INICIO DE SESION");
				System.out.print("Usuario: ");
				String chequeoUsuario = scan.nextLine();
				System.out.print("Contraseña: ");
				String chequeoContraseña = scan.next();
				for (CuentaUsuario corroborar : listaUsuarios) {
					if ((corroborar.getUsuario().equals(chequeoUsuario)
							|| corroborar.getCorreo().equals(chequeoUsuario))
							&& corroborar.getContraseña().equals(chequeoContraseña)) {
						do {
							System.out.println("Menu USUARIO");
							System.out.println("1- Depositar");
							System.out.println("2-Transferencia");
							System.out.println("3-Retiro");
							System.out.println("4-Pago Movil");
							System.out.println("5 Informacion del usuario");
							System.out.println("6-Historial");
							System.out.println("7-Salir");
							int opcion = scan.nextInt();
							if (opcion == 1) {
								do {
									System.out.println("Depositar");
									corroborar.depositar(historialTrans, scan, opcion);
									System.out.println("Desea salir?");
									System.out.println("1-Si 2-No");
									menu = scan.nextInt();
								} while (menu != 1);
							} else if (opcion == 2) {
								do {
									System.out.println("Transferencia");
									corroborar.transferir(listaUsuarios, historialTrans, scan, opcion);
									System.out.println("Desea salir?");
									System.out.println("1-Si 2-No");
									menu = scan.nextInt();
								} while (menu != 1);

							} else if (opcion == 3) {
								do {
									System.out.println("Retiro");
									corroborar.retirar(scan, opcion, historialTrans);
									System.out.println("Desea salir?");
									System.out.println("1-Si 2-No");
									menu = scan.nextInt();
								} while (menu != 1);

							} else if (opcion == 4) {
								do {
									System.out.println("PagoMovil");
									corroborar.pagoMovil(listaUsuarios, historialTrans, scan, opcion);
									System.out.println("Desea salir?");
									System.out.println("1-Si 2-No");
									menu = scan.nextInt();
								} while (menu != 1);

							} else if (opcion == 5) {
								do {
									System.out.println("Ver informacion del usuario");
									corroborar.verInfo(tasa);
									System.out.println("Desea salir?");
									System.out.println("1-Si 2-No");
									menu = scan.nextInt();
								} while (menu != 1);

							} else if (opcion == 6) {
								do {
									System.out.println("Historial");
									corroborar.historial(tasa);
									System.out.println("Desea salir?");
									System.out.println("1-Si 2-No");
									menu = scan.nextInt();
								} while (menu != 1);

							} else if (opcion == 7) {
								System.out.println("VUELVA PRONTO");
								menu = 7;
							} else {
								System.err.println("INGRESE UNA OPCION VALIDA");
							}

						} while (menu != 7);

					}
				}
				for (CuentaAdmin corroborarAdmin : listaAdmin) {
					if (corroborarAdmin.getUsuario().equals(chequeoContraseña)) {
						do {
							System.out.println("Menu ADMIN");
							System.out.println("1-Hitorial transacciones");
							System.out.println("2-Registrar usuario");
							System.out.println("3-Tasa de cambio");
							System.out.println("4-Listado usuario");
							System.out.println("5-Estadisticas");
							System.out.println("6-salir");
							int opcion = scan.nextInt();
							if (opcion == 1) {
								do {
									System.out.println("HISTORIAL");
									corroborarAdmin.historialTranscacciones(historialTrans);
									System.out.println("Desea salir?");
									System.out.println("1-Si 2-No");
									menu = scan.nextInt();
								} while (menu != 1);

							} else if (opcion == 2) {
								do {
									scan.nextLine();
									System.out.println("Registrar usuario");
									System.out.print("NOMBRE: ");
									String nombre = scan.nextLine();
									System.out.print("CEDULA: ");
									String cedula = scan.nextLine();
									System.out.print("TELEFONO");
									String telefono = scan.nextLine();
									System.out.print("USUARIO: ");
									String usuario = scan.nextLine();
									System.out.println("CONTRASEÑA: ");
									String contraseña = scan.nextLine();
									System.out.println("CORREO: ");
									String correo = scan.nextLine();
									listaUsuarios.add(
											new CuentaUsuario(nombre, cedula, telefono, usuario, contraseña, correo));
									System.out.println("Desea salir?");
									System.out.println("1-Si 2-No");
									menu = scan.nextInt();
								} while (menu != 1);

							} else if (opcion == 3) {
								do {
									System.out.println("Tasa de cambio");
									System.out.println("Tasa actual: " + corroborarAdmin.getTasa());
									System.out.print("Ingrese la nueva tasa: ");
									tasa = scan.nextInt();
									corroborarAdmin.setTasa(tasa);
									System.out.println("Nueva tasa: " + corroborarAdmin.getTasa());
									System.out.println("Desea salir?");
									System.out.println("1-Si 2-No");
									menu = scan.nextInt();
								} while (menu != 1);

							} else if (opcion == 4) {
								do {
									System.out.println("LISTADO DE USUARIOS");
									corroborarAdmin.listadoUsuarios(listaUsuarios);
									System.out.println("Desea salir?");
									System.out.println("1-Si 2-No");
									menu = scan.nextInt();
								} while (menu != 1);

							} else if (opcion == 5) {
								System.out.println("ESTADISTICAS");
								System.out.println("HISTORIAL TRANSACCIONES");
								corroborarAdmin.actualizarHistorial(historialTrans);
								System.out.println("Cantidad total de usuarios: " + (listaUsuarios.size() + 1));
								System.out.println("BOVEDA DEL BANCO: ");
								System.out.println(corroborarAdmin.totalBoveda(historialTrans));
								System.out.println("BOVEDA DEL BANCO EN $: ");
								System.out.println(
										corroborarAdmin.totalBoveda(historialTrans) * corroborarAdmin.getTasa());

							} else if (opcion == 6) {
								System.out.println("VUELVA PRONTO");
								menu = 6;
							} else {
								System.err.println("INGRESE UNA OPCION VALIDA");
							}

						} while (menu != 6);

					}
				}
			}else {
				System.out.println("Vuelva pronto");
				salir = 1;
			}
		}while(salir == 0);

	}

}
