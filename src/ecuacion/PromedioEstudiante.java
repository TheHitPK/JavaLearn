package ecuacion;
import java.util.Scanner;
import java.time.LocalDate;

public class PromedioEstudiante {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Ingreso de datos de estudiante
		System.out.print("Ingrese el Nombre del estudiante: ");
		String nameStudent = scan.nextLine();
		System.out.print("Ingrese la Cedula del estudiante: ");
		String dniStudent = scan.nextLine();
		System.out.println("Ingrese la fecha de nacimiento del estudiante del estudiante: ");
		System.out.print("Ingrese el año: ");
		int yearBorn= scan.nextInt();
		System.out.print("Ingrese el mes: ");
		int monthBorn= scan.nextInt();
		System.out.print("Ingrese el dia: ");
		int dayBorn= scan.nextInt();
		
		//fecha actual en años, meses y dias
		LocalDate today = LocalDate.now();
		int yearDate = today.getYear();
		int monthDate = today.getMonthValue();
		int dayDate = today.getDayOfMonth();
		int edad = 0;
		
		//Calculo de la edad
		if(yearDate > yearBorn) {
			edad = yearDate-yearBorn;
			if(monthDate < monthBorn) {
				edad--;
			}else if(monthDate == monthBorn) {
				if(dayDate < dayBorn) {
					edad--;
				}
			}
		}		 
		int edadActual = edad;
		//Ingreso de notas
		System.out.print("Ingrese las notas del estudiante: ");
		
		int nota1= scan.nextInt();		
		
		if(nota1 >= 0 && nota1<= 20) {
			int nota2= scan.nextInt();
			if(nota2 >= 0 && nota2<= 20) {
				int nota3= scan.nextInt();
				scan.close();
				if(nota3 >= 0 && nota3<= 20) {
					int promedio = (nota1+nota2+nota3)/3;
					
					System.out.println(nameStudent+" "+dniStudent);		
					if(edadActual >= 18) {
						System.out.println("El estudiante es mayor de edad, tiene "+ edadActual);		
					}else {
						System.out.println("El estudiante es menor de edad, tiene "+ edadActual);
					}
					
					if(promedio >= 10) {
						System.out.println("El estudiante ha sido aprobado con un promedio de "+ promedio);
					}else {
						System.out.println("El estudiante ha sido reprobado con un promedio de "+ promedio);
					}
					
				}else{
					System.out.println("Nota erronea");
				}
			}else{
				System.out.println("Nota erronea");
			}
			
		}else{
			System.out.println("Nota erronea");
		}
		

	}

}
