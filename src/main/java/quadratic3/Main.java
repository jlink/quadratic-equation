package quadratic3;

import java.io.*;

public class Main {
	public static void main(String... args) throws IOException {
		System.out.println();
		System.out.println("Solving quadratic equations for");
		System.out.println("a x^2 + b x + c = 0");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		double a = readDoubleValue(reader, "a: ");
		double b = readDoubleValue(reader, "b: ");
		double c = readDoubleValue(reader, "c: ");

		double[] solutions = QuadraticEquation.solve(a, b, c);

		System.out.println();
		System.out.println("Solutions: " + solutions[0] + " and " + solutions[1]);
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

}
