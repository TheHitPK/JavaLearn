package ecuacion;
import java.util.Scanner;
public class Ecuacion2doGrado {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double a= scan.nextInt();
		double b= scan.nextInt();
		double c= scan.nextInt();
		
		double x1=Math.pow(b,2)-(4*a*c);
		x1= (-b)+ (Math.sqrt(x1));
		x1 /=(2*a);
		double x2=Math.pow(b,2)-(4*a*c);
		x2= (-b)-(Math.sqrt(x2));
		x2 /=(2*a);
		System.out.print(x1 + " " + x2);
		scan.close();
		
	}

}
