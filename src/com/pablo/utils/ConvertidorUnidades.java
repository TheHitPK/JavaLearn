package com.pablo.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConvertidorUnidades {
	static final String UNIDAD_CELSIUS_KEY = "C";
	static final String UNIDAD_FARENHEIT_KEY = "F";
	static final String UNIDAD_KELVIN_KEY = "K";
	private static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Ingrese la temperatura: ");
		double temp = 0;
		boolean datoValido;
		do {
			try {
				datoValido = false;
				temp = scan.nextDouble();
			} catch (InputMismatchException e) {
				datoValido = true;
				System.err.println("ERROR-Ingrese un valor numerico");
				scan.nextLine();
			}
		} while (datoValido);
		String unidad;
		do {
			scan.nextLine();
			System.out.println("En que unidad?");
			System.out.println("F- Farenheit");
			System.out.println("K- Kelvin");
			System.out.println("C- Celcius");
			unidad = scan.next();
			if (unidad.equalsIgnoreCase(UNIDAD_FARENHEIT_KEY)) {
				System.out.println("La temperatura es:" + temp + unidad);
				convertirFarenheit(temp, unidad);
				break;
			} else if (unidad.equalsIgnoreCase(UNIDAD_CELSIUS_KEY)) {
				System.out.println("La temperatura es:" + temp + unidad);
				convertirCelcius(temp, unidad);
				break;
			} else if (unidad.equalsIgnoreCase(UNIDAD_KELVIN_KEY)) {
				System.out.println("La temperatura es:" + temp + unidad);
				convertirKelvin(temp, unidad);
				break;
			} else {
				System.err.println("ERROR-Ingrese una unidad correcta");
			}
		} while (unidad != UNIDAD_FARENHEIT_KEY && unidad != UNIDAD_CELSIUS_KEY && unidad != UNIDAD_KELVIN_KEY);

	}

	static void convertirFarenheit(double temperatura, String unidad) {
		do {
			System.out.println("Desea transformar a:");
			System.out.println("C- Celcius o K- Kelvin");
			unidad = scan.next();
			if (unidad.equalsIgnoreCase(UNIDAD_CELSIUS_KEY)) {
				temperatura -= 32;
				temperatura *= 5;
				temperatura /= 9;
				System.out.println("La temperatura en Celcius: " + temperatura);
				break;
			} else if (unidad.equalsIgnoreCase(UNIDAD_KELVIN_KEY)) {
				temperatura -= 32;
				temperatura *= 5;
				temperatura /= 9;
				temperatura += 273.15;
				System.out.println("La temperatura en Kelvin: " + temperatura);
				break;
			} else {
				System.err.println("ERROR-Ingrese una unidad correcta");
			}
		} while (unidad != UNIDAD_CELSIUS_KEY || unidad != UNIDAD_KELVIN_KEY);

	}

	static void convertirCelcius(double temperatura, String unidad) {
		do {
			System.out.println("Desea transformar a:");
			System.out.println("f- Farenheit o K- Kelvin");
			unidad = scan.next();
			if (unidad.equalsIgnoreCase(UNIDAD_FARENHEIT_KEY)) {
				temperatura *= 9;
				temperatura /= 5;
				temperatura += 32;
				System.out.println("La temperatura en Farenheit: " + temperatura);
				break;
			} else if (unidad.equalsIgnoreCase(UNIDAD_KELVIN_KEY)) {
				temperatura += 273.15;
				System.out.println("La temperatura en Kelvin: " + temperatura);
				break;
			} else {
				System.err.println("ERROR-Ingrese una unidad correcta");
			}
		} while (unidad != UNIDAD_FARENHEIT_KEY || unidad != UNIDAD_KELVIN_KEY);
	}

	static void convertirKelvin(double temperatura, String unidad) {
		do {
			System.out.println("Desea transformar a:");
			System.out.println("f- Farenheit o C- Celsius");
			unidad = scan.next();
			if (unidad.equalsIgnoreCase(UNIDAD_FARENHEIT_KEY)) {
				temperatura -= 273.15;
				temperatura *= 9;
				temperatura /= 5;
				temperatura += 32;
				System.out.println("La temperatura en Farenheit: " + temperatura);
				break;
			} else if (unidad.equalsIgnoreCase(UNIDAD_CELSIUS_KEY)) {
				temperatura -= 273.15;
				System.out.println("La temperatura en Celcius: " + temperatura);
				break;
			} else {
				System.err.println("ERROR-Ingrese una unidad correcta");
			}

		} while (unidad != UNIDAD_FARENHEIT_KEY || unidad != UNIDAD_CELSIUS_KEY);

	}

}
