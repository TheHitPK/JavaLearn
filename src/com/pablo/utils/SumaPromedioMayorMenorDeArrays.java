package com.pablo.utils;

import java.util.Scanner;

public class SumaPromedioMayorMenorDeArrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Cuantos numeros desea ingresar?");
		int cantNum = scan.nextInt();
		double[] arrayNum = new double[cantNum];
		for (int i = 0; i < arrayNum.length; i++) {
			System.out.println("Vez numero " + (i + 1) + " que ingresa");
			arrayNum[i] = scan.nextDouble();
		}
		System.out.println("La suma es: " + sumaArray(arrayNum));
		System.out.println("La promedio es: " + promedioArray(arrayNum));
		System.out.println("La Numero mayor es: " + numMayor(arrayNum));
		System.out.println("La Numero Menor es: " + numMenor(arrayNum));
	}

	static int sumaArray(double arrayNum[]) {
		int suma = 0;
		for (int i = 0; i < arrayNum.length; i++) {
			suma += arrayNum[i];
		}
		return suma;
	}

	static int promedioArray(double arrayNum[]) {
		int suma = 0;
		int promedio;
		for (int i = 0; i < arrayNum.length; i++) {
			suma += arrayNum[i];
		}
		promedio = suma / arrayNum.length;
		return promedio;
	}

	static int numMayor(double arrayNum[]) {
		int numMayor = 0;
		for (int i = 0; i < arrayNum.length; i++) {
			if (arrayNum[i] > numMayor) {
				numMayor = (int) arrayNum[i];
			}
		}
		return numMayor;
	}

	static int numMenor(double arrayNum[]) {
		int numMenor = Integer.MAX_VALUE;
		for (int i = 0; i < arrayNum.length; i++) {
			if (arrayNum[i] < numMenor) {
				numMenor = (int) arrayNum[i];
			}
		}
		return numMenor;
	}
}
