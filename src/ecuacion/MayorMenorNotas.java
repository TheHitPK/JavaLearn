package ecuacion;
import java.util.Scanner;
import java.time.LocalDate;
public class MayorMenorNotas {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean program = false;
		int menosNotas= Integer.MAX_VALUE;
		int masNotas = Integer.MIN_VALUE;
		int menorPromedio = Integer.MAX_VALUE;
		int mayorPromedio = Integer.MIN_VALUE;
		String menosCantidadNotas="";
		String masCantidadNotas="";
		String mejorPromedio="";
		String peorPromedio="";
		int aux = 0;
		int mayorEdad=0;
		int menorEdad=0;
		int masculino=0;
		int femenino=0;
		int programacion = 0;
		int fisica=0;
		int matematica=0;
		int materia=0;
		do {	
			System.out.println("Cuantos estudiantes desea ingresar?");
			int numStudent = scan.nextInt();
			for(int i=0; i<numStudent;i++) {
				System.out.println("Nombre del estudiante numero "+ (aux+1));
				scan.nextLine();
				String nameStudent = scan.nextLine();
				//Fecha de nacimiendo del estudiante
				System.out.println("Ingrese la fecha de nacimiento del estudiante del estudiante: ");
				System.out.print("Ingrese el año: ");
				int yearBorn= scan.nextInt();
				System.out.print("Ingrese el mes: ");
				int monthBorn= scan.nextInt();
				System.out.print("Ingrese el dia: ");
				int dayBorn= scan.nextInt();
				
				//Sexo del estudiante
				System.out.println("Ingrese el tipo sexo del estudiante H/Hombre  M/Mujer");
				String sex = scan.next();
				switch(sex) {
					case "H":
						masculino++;
					break;
					
					case "h":
						masculino++;
					break;
					
					case "M":
						femenino++;
					break;
					
					case "m":
						femenino++;
					break;
					
					default:
						System.out.println("No binario");
				}
				
				
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
				if(edadActual >= 18) {
					System.out.println("El estudiante es mayor de edad, tiene "+ edadActual);
					 mayorEdad++;
					
				}else {
					System.out.println("El estudiante es menor de edad, tiene "+ edadActual);
					menorEdad--;
				}
				//numero de notas
				System.out.println("Cantidad de notas del estudiante ");
				int numRating = scan.nextInt();
				System.out.println("Ingrese que materia esta cursando el estudiante:  1/programacion 2/fisica 3/Matematicas");
				materia = scan.nextInt();
				switch(materia) {
					case 1:
						programacion++;
					break;
					
					case 2 :
						fisica++;
					break;
					
					case 3:
						matematica++;
					break;
					
				}
				int promedio=0;
				int notas = 0;
				int sumNotas=0;
				for(int j=0;j<numRating;j++) {
					System.out.println("Nota "+(j+1));
					notas = scan.nextInt();
					if(notas >= 0 && notas <=20) {
						
						sumNotas+=notas;
					}else {
							
							while(notas<0 || notas >20 ) {
								System.out.println("Error, Marque una nota validad");
								notas = scan.nextInt();
							}
						sumNotas+=notas;
					}
					
						
				}
				promedio = sumNotas / numRating;
				if(numRating < menosNotas ) {
					menosNotas=numRating;
					menosCantidadNotas = nameStudent;
				}
				
				if(numRating > masNotas ) {
					masNotas=numRating;
					masCantidadNotas = nameStudent;
				}
				
				if(promedio > mayorPromedio ) {
					mayorPromedio=promedio;
					mejorPromedio = nameStudent;
				}
				
				if(promedio < menorPromedio ) {
					menorPromedio=promedio;
					peorPromedio = nameStudent;
				}
				aux++;
			}
			System.out.println("Mejor promedio: "+ mejorPromedio +" con " + mayorPromedio);
			System.out.println("Peor promedio: "+ peorPromedio +" con " + menorPromedio);
			System.out.println("Mas notas procesadas: "+ masCantidadNotas +" con " +masNotas );
			System.out.println("Menos notas procesadas: "+ menosCantidadNotas +" con " + menosNotas);
			System.out.println("Cantidad de estudiantes mayores de edad: "+mayorEdad);
			System.out.println("Cantidad de estudiantes menores de edad: "+menorEdad);
			System.out.println("Cantidad de estudiantes masculinos: "+masculino);
			System.out.println("Cantidad de estudiantes femeninas: "+femenino);
			System.out.println("Cantidad de estudiantes cursando fisica: "+fisica);
			System.out.println("Cantidad de estudiantes cursando programacion: "+programacion);
			System.out.println("Cantidad de estudiantes cursando matematica: "+matematica);
			
			
			System.out.println("Desea continuar? 1/si  0/no");
			int opc= scan.nextInt();
			
			if(opc!=1) {
				program= true;
			}
			
		}while(program==false);
		
		scan.close();

	}

}
