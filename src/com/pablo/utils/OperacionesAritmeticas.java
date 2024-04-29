package com.pablo.utils;
import java.util.Scanner;
public class OperacionesAritmeticas {
//Metodo comparativo a mayor
		static int numeroMayor(int a,int b) {
		return Math.max(a, b);
	}
//Metodo Main
	public static void main(String[] args) {
		//Apertura de Clase Scanner
		Scanner scan = new Scanner(System.in);
		//Entrada de datos
		System.out.println("Ingrese 2 numeros");
		System.out.print("Primero: ");
		int x = scan.nextInt();
		System.out.print("Segundo: ");
		int y = scan.nextInt();
		//Cierre Clase Scanner
		scan.close();
		//Impresion		
		System.out.print("El numero mayor es: " + numeroMayor(x,y));
		
	}

}
