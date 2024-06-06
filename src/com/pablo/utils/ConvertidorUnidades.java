package com.pablo.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConvertidorUnidades {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Ingrese la temperatura: ");
		double temp = 0;
		boolean good;
		do {
			try {
				good = false;
				temp = scan.nextDouble();
			} catch (InputMismatchException e) {
				good = true;
				System.out.println("Ingrese un decimal");
				scan.nextLine();
			}
		} while (good == true);

		System.out.println("En que medida?");
		System.out.println("F- Farenheit");
		System.out.println("K- Kelvin");
		System.out.println("C- Celcius");
		String unidad = scan.next();
		System.out.println("La temperatura es:" + temp + unidad);
		if (unidad.equalsIgnoreCase("F")) {
			convertirFarenheit(temp, unidad);
		} else if (unidad.equalsIgnoreCase("C")) {
			convertirCelcius(temp, unidad);
		} else if (unidad.equalsIgnoreCase("K")) {
			convertirKelvin(temp, unidad);
		}
	}

	static void convertirFarenheit(double temperatura, String unidad) {
		System.out.println("Desea transformar a:");
		System.out.println("C- Celcius o K- Kelvin");
		unidad = scan.next();
		if (unidad.equalsIgnoreCase("c")) {
			temperatura -= 32;
			temperatura *= 5;
			temperatura /= 9;
			System.out.println("La temperatura en Celcius: " + temperatura);
		} else if (unidad.equalsIgnoreCase("k")) {
			temperatura -= 32;
			temperatura *= 5;
			temperatura /= 9;
			temperatura += 273.15;
			System.out.println("La temperatura en Kelvin: " + temperatura);
		}
	}

	static void convertirCelcius(double temperatura, String unidad) {
		System.out.println("Desea transformar a:");
		System.out.println("f- Farenheit o K- Kelvin");
		unidad = scan.next();
		if (unidad.equalsIgnoreCase("F")) {
			temperatura *= 9;
			temperatura /= 5;
			temperatura += 32;
			System.out.println("La temperatura en Farenheit: " + temperatura);
		} else if (unidad.equalsIgnoreCase("k")) {
			temperatura += 273.15;
			System.out.println("La temperatura en Kelvin: " + temperatura);
		}
	}

	static void convertirKelvin(double temperatura, String unidad) {
		System.out.println("Desea transformar a:");
		System.out.println("f- Farenheit o C- Celsius");
		unidad = scan.next();
		if (unidad.equalsIgnoreCase("F")) {
			temperatura -= 273.15;
			temperatura *= 9;
			temperatura /= 5;
			temperatura += 32;
			System.out.println("La temperatura en Farenheit: " + temperatura);
		} else if (unidad.equalsIgnoreCase("c")) {
			temperatura -= 273.15;
			System.out.println("La temperatura en Celcius: " + temperatura);
		}
	}

}
