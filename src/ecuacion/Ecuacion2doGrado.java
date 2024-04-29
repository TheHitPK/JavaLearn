package ecuacion;
import java.util.Scanner;
public class Ecuacion2doGrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		double a= scan.nextInt();
		double b= scan.nextInt();
		double c= scan.nextInt();
		double x1= ( (-b)+ (Math.sqrt(Math.pow(b,2)-(4*a*c))) )/(2*a);
		double x2 = ( (-b)- (Math.sqrt(Math.pow(b,2)-(4*a*c))) )/(2*a);
		System.out.print(x1 + " " + x2);
		
		
	}

}
