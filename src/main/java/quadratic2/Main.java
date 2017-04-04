package quadratic2;

import java.io.*;

public class Main {
	public static void main(String... args) throws IOException {
		printHeader();
		double[] solutions = calculateEquation();
		printSolutions(solutions);
	}

	private static void printHeader() {
		System.out.println();
		System.out.println("Solving quadratic equations for");
		System.out.println("a x\u00b2 + b x + c = 0");
	}

	private static double[] calculateEquation() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double a = readDoubleValue(reader, "a: ");
		double b = readDoubleValue(reader, "b: ");
		double c = readDoubleValue(reader, "c: ");

		return QuadraticEquation.solve(a, b, c);
	}

	private static double readDoubleValue(BufferedReader reader, String prompt) throws IOException {
		System.out.print(prompt);
		String input = reader.readLine();
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.println(input + " ist keine Zahl.");
			return readDoubleValue(reader, prompt);
		}
	}

	private static void printSolutions(double[] solutions) {
		System.out.println();
		System.out.println("Solutions: " + solutions[0] + " and " + solutions[1]);
	}

}
