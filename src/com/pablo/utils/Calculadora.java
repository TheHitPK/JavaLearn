package com.pablo.utils;
import java.util.Scanner;

public class Calculadora {
	static int result;
	//Metodo Suma
	static void suma(int a, int b){
		result = a +b;
	}
	
	//Metodo resta
	static void resta(int a, int b){
		result = a - b;
	}
	//Metodo multiplicacion
	static void multiplicacion(int a, int b){
		result = a * b;
	}
	//Metodo Division
	static void division(int a, int b){
		result = a / b;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escriba el primer numero:");
		int first =scan.nextInt();
		//Fix Bug del String luego del Int
		scan.nextLine();
		System.out.println("+ o - o * o /");
		String opc = scan.nextLine();
		System.out.println("Escriba el segundo numero");
		int second = scan.nextInt();
		
		//Operacion
		switch(opc) {
			case "+":
				suma(first,second);
			break;
			
			case "-":
				resta(first,second);
			break;
			
			case "*":
				multiplicacion(first,second);
			break;
			
			case "/":
				division(first,second);
			break;
			
			default:
				System.out.print("XD");
		}
		
		System.out.print(result);
	}

}
