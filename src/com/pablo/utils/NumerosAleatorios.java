package com.pablo.utils;

import java.util.Scanner;

public class NumerosAleatorios {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("NUMEROS ALEATORIOS");
		System.out.println("Ingrese cuantos numeros desea generar");
		int cantNum = scan.nextInt();
		GeneradorNumerosAleatorios(cantNum);
		scan.close();
	}
	static void GeneradorNumerosAleatorios(int cantNum) {
		int[] arrayNum = new int[cantNum];
		for (int i = 0; i < cantNum; i++) {
			double numAleatorio = (Math.random() * 1000);
			arrayNum[i] = (int) numAleatorio;
			System.out.println(arrayNum[i]);
		}
	}

}
