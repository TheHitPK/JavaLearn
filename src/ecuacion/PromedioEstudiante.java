package ecuacion;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.*;
		
public class PromedioEstudiante {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Ingreso de datos de estudiante
		System.out.print("Ingrese el Nombre del estudiante: ");

		String nombreEstudiante = scan.nextLine();
		System.out.print("Ingrese la Cedula del estudiante: ");
		String cedulaEstudiante = scan.nextLine();
		System.out.println("Ingrese la fecha de nacimiento del estudiante del estudiante: ");
		System.out.print("Ingrese el año: ");
		int anioNacimiento= scan.nextInt();
		System.out.print("Ingrese el mes: ");
		int mesNacimiento= scan.nextInt();
		System.out.print("Ingrese el dia: ");
		int diaNacimiento= scan.nextInt();
		LocalDate cumpleanios= LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
		
		//fecha actual en años, meses y dias
		LocalDate hoy = LocalDate.now();	
		
		//Calculo de edad
		Period periodo = Period.between(cumpleanios,hoy);
		int edad = periodo.getYears();
		
		//Ingreso de notas
		System.out.print("Ingrese las notas del estudiante: ");
		int notas=0;
		for(int i=0;i<3;i++) {
			int nota = scan.nextInt();
			if(nota >= 0 && nota<= 20) {
				notas += nota;
			}else {
				System.out.println("Nota erronea");
			}
			
		}	
		int promedio = (notas)/3;
					
		System.out.println(nombreEstudiante+" "+cedulaEstudiante);		
		if(edad >= 18) {
			System.out.println("El estudiante es mayor de edad, tiene "+ edad);		
		}else {
			System.out.println("El estudiante es menor de edad, tiene "+ edad);
		}
					
		if(promedio >= 10) {
			System.out.println("El estudiante ha sido aprobado con un promedio de "+ promedio);
		}else {
			System.out.println("El estudiante ha sido reprobado con un promedio de "+ promedio);
		}
	}

}
