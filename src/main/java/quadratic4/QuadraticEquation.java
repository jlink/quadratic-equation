package quadratic4;

class QuadraticEquation {

	static double[] solve(double a, double b, double c) {
		if (a == 0)
			return solveLinearEquation(b, c);

		double discriminant = discriminant(a, b, c);

		if (discriminant < 0.0)
			return new double[] { };

		if (discriminant == 0.0)
			return new double[] { -b / (2 * a) };

		return solveForPositiveDiscriminant(a, b, discriminant);
	}

	private static double[] solveLinearEquation(double xFactor, double constant) {
		if (xFactor == 0)
			return new double[] {};
		return new double[] {-constant / xFactor};
	}

	private static double[] solveForPositiveDiscriminant(double a, double b, double discriminant) {
		double sqrt = Math.sqrt(discriminant);
		double solution1 = (-b + sqrt) / (2 * a);
		double solution2 = (-b - sqrt) / (2 * a);
		return new double[] { solution1, solution2 };
	}

	private static double discriminant(double a, double b, double c) {
		return b * b - 4 * a * c;
	}
}
