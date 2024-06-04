package ecuacion;
import java.util.Scanner;
public class Ecuacion2doGrado {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double terminoCuadratico = scan.nextInt();
		double terminoLineal = scan.nextInt();
		double terminoIndependiente = scan.nextInt();

		double x1 = Math.pow(terminoLineal, 2) - (4 * terminoCuadratico * terminoIndependiente);
		x1 = (-terminoLineal) + (Math.sqrt(x1));
		x1 /= (2 * terminoCuadratico);
		double x2 = Math.pow(terminoLineal, 2) - (4 * terminoCuadratico * terminoIndependiente);
		x2 = (-terminoLineal) - (Math.sqrt(x2));
		x2 /= (2 * terminoCuadratico);
		System.out.print(x1 + " " + x2);
		scan.close();

	}

}
