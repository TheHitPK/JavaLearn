package com.pablo.utils;
import java.util.Scanner;
public class OperacionesAritmeticas {
	//global
	static int mayor;
//Metodo comparativo a mayor
	static void numeroMayor(int a,int b) {
		mayor = Math.max(a, b);
	}
//Metodo Main
	public static void main(String[] args) {
		//Apertura de Clase Scanner
		Scanner scan = new Scanner(System.in);
		//Entrada de datos
		System.out.println("Eliga 2 numeros");
		System.out.print("Primero: ");
		int x = scan.nextInt();
		System.out.print("Segundo: ");
		int y = scan.nextInt();
		//Cierre Clase Scanner
		scan.close();
		numeroMayor(x,y);
		//Impresion
		System.out.print("El numero mayor es: " + mayor);
		
	}

}
