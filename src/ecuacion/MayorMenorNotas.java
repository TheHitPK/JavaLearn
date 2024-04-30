package ecuacion;
import java.util.Scanner;
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
		do {	
			System.out.println("Cuantos estudiantes desea ingresar?");
			int numStudent = scan.nextInt();
			for(int i=0; i<numStudent;i++) {
				System.out.println("Nombre del estudiante numero "+ (aux+1));
				scan.nextLine();
				String nameStudent = scan.nextLine();
				//numero de notas
				System.out.println("Cantidad de notas del estudiante ");
				int numRating = scan.nextInt();
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
			
			System.out.println("Desea continuar? 1/si  0/no");
			int opc= scan.nextInt();
			
			if(opc!=1) {
				program= true;
			}
			
		}while(program==false);
		
		scan.close();

	}

}
