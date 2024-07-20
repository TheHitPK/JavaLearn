package ecuacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExamenArchivos {
	//principal
	private static Scanner scanner = new Scanner(System.in);

	private static Map<String, Integer> censoredWords = new HashMap<>();

	private static List<String> registeredWords = new ArrayList<>();

	public static void main(String[] args) {

		int opcion;

		do {

			System.out.println("Menú:");

			System.out.println("1. Registrar palabras");

			System.out.println("2. Crear archivo estadístico");

			System.out.println("3. Crear archivo censurado");

			System.out.println("4. Estadísticas");

			System.out.println("5. Escanear archivo");

			System.out.println("6. Salir");

			System.out.print("Seleccione una opción: ");

			opcion = scanner.nextInt();

			scanner.nextLine(); // Limpiar el buffer

			switch (opcion) {

			case 1:

				registrarPalabras();

				break;

			case 2:

				crearArchivoEstadistico();

				break;

			case 3:

				crearArchivoCensurado();

				break;

			case 4:

				mostrarEstadisticas();

				break;

			case 5:

				escanearArchivo();

				break;

			case 6:

				System.out.println("Saliendo del programa...");

				break;

			default:

				System.out.println("Opción no válida. Intente de nuevo.");

			}

		} while (opcion != 6);

	}

	private static void registrarPalabras() {

		System.out.print("Ingrese las palabras a censurar: ");

		String input = scanner.nextLine();

		String[] words = input.toLowerCase().split(",");

		for (String word : words) {

			word = word.trim();

			if (!word.isEmpty() && !registeredWords.contains(word)) {

				registeredWords.add(word);

				censoredWords.put(word, 0);

			}

		}

		System.out.println("Palabras registradas exitosamente.");

	}

	private static void crearArchivoEstadistico() {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("estadisticas.txt"))) {

			for (Map.Entry<String, Integer> entry : censoredWords.entrySet()) {

				writer.write(entry.getKey() + " " + entry.getValue());

				writer.newLine();

			}

			System.out.println("Archivo estadístico creado correctamente.");

		} catch (IOException e) {

			System.out.println("Error al crear el archivo estadístico: " + e.getMessage());

		}

	}

	private static void crearArchivoCensurado() {

		System.out.print("Ingrese la ruta del archivo a censurar: ");

		String inputPath = scanner.nextLine();

		// Usa el directorio temporal del sistema

		String outputPath = System.getProperty("java.io.tmpdir") + "censurado.txt";

		File inputFile = new File(inputPath);

		File outputFile = new File(outputPath);

		if (!inputFile.exists()) {

			System.out.println("El archivo de entrada no existe: " + inputPath);

			return;

		}

		if (!inputFile.canRead()) {

			System.out.println("No se puede leer el archivo de entrada: " + inputPath);

			return;

		}

		try {

			if (!outputFile.exists()) {

				outputFile.createNewFile();

			}

		} catch (IOException e) {

			System.out.println("No se puede crear el archivo de salida: " + outputPath);

			System.out.println("Error: " + e.getMessage());

			return;

		}

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));

				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

			String line;

			while ((line = reader.readLine()) != null) {

				for (String word : registeredWords) {

					int count = line.split("\\b" + word + "\\b", -1).length - 1;

					censoredWords.put(word, censoredWords.get(word) + count);

					line = line.replaceAll("\\b" + word + "\\b", "*".repeat(word.length()));

				}

				writer.write(line);

				writer.newLine();

			}

			System.out.println("Archivo censurado creado correctamente.");

			System.out.println("Archivo creado en: " + outputPath);

		} catch (IOException e) {

			System.out.println("Error al crear el archivo censurado: " + e.getMessage());

		}

	}

	private static void mostrarEstadisticas() {

		for (Map.Entry<String, Integer> entry : censoredWords.entrySet()) {

			System.out.println(entry.getKey() + ": " + entry.getValue());

		}

	}

	private static void escanearArchivo() {

		System.out.print("Ingrese la ruta del archivo a escanear: ");

		String path = scanner.nextLine();

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

			String line;

			while ((line = reader.readLine()) != null) {

				for (String word : registeredWords) {

					int count = line.split("\\b" + word + "\\b", -1).length - 1;

					censoredWords.put(word, censoredWords.get(word) + count);

				}

			}

			System.out.println("Archivo escaneado correctamente.");

		} catch (IOException e) {

			System.out.println("Error al escanear el archivo: " + e.getMessage());

		}

	}

}

