package quadratic;

import java.io.*;

public class Main {
	public static void main(String... args) throws IOException {
		System.out.println();
		System.out.println("Solving quadratic equations for");
		System.out.println("a x^2 + b x + c = 0");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("a: ");
		double a = Double.parseDouble(reader.readLine());

		System.out.print("b: ");
		double b = Double.parseDouble(reader.readLine());

		System.out.print("c: ");
		double c = Double.parseDouble(reader.readLine());

		double solution1 = calculateSolution1(a, b, c);
		double solution2 = calculateSolution2(a, b, c);

		System.out.println();
		System.out.println("Solutions: " + solution1 + " and " + solution2);
	}

	private static double calculateSolution1(double a, double b, double c) {
		return (-b + Math.sqrt(b * b - 4 * a * c)) / 4 * a * c;
	}

	private static double calculateSolution2(double a, double b, double c) {
		return (-b - Math.sqrt(b * b - 4 * a * c)) / 4 * a * c;
	}
}
