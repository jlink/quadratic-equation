package quadratic4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.opentest4j.*;

import java.util.*;
import java.util.stream.*;

public class QuadraticEquationTests {

	@Nested
	@DisplayName("Two solutions")
	class TwoSolutions {

		@Test
		@DisplayName("no linear x")
		void solutionsWithNoLinearX() {
			double[] solutions = QuadraticEquation.solve(1, 0, -4);
			assertSolutions(solutions, 2.0, -2.0);
		}

		@Test
		@DisplayName("flipped curve and no linear x")
		void solutionsWithFlippedCurveAndNoLinearX() {
			double[] solutions = QuadraticEquation.solve(-1, 0, 4);
			assertSolutions(solutions, -2.0, 2.0);
		}

		@Test
		@DisplayName("exactly one x\u00B2")
		void solutionsWithExactlyOneSquaredX() {
			double[] solutions = QuadraticEquation.solve(1, 5, 4);
			assertSolutions(solutions, -1.0, -4.0);
		}

		@Test
		@DisplayName("no linear x but high x\u00B2")
		void solutionsWithNoLinearXButHighSquaredX() {
			double[] solutions = QuadraticEquation.solve(10, 0, -40);
			assertSolutions(solutions, 2.0, -2.0);
		}

		@Test
		@DisplayName("high x\u00B2")
		void solutionsWithHighSquaredX() {
			double[] solutions = QuadraticEquation.solve(10, 50, 40);
			assertSolutions(solutions, -1.0, -4.0);
		}

		@Test
		@DisplayName("odd values")
		void solutionsWithOddValues() {
			double[] solutions = QuadraticEquation.solve(7.568, 37.544, 22.14);
			assertSolutions(solutions, -0.68402, -4.27686);
		}

	}

	@Nested
	@DisplayName("Only one solution")
	class OneSolution {

		@Test
		@DisplayName("upwards curve")
		void curveUpwards() {
			double[] solutions = QuadraticEquation.solve(1, 0, 0);
			assertSolutions(solutions, 0.0);
		}

		@Test
		@DisplayName("downwards curve")
		void curveDownwards() {
			double[] solutions = QuadraticEquation.solve(1, 0, 0);
			assertSolutions(solutions, 0.0);
		}

		@Test
		@DisplayName("shifted curve")
		void curveShifted() {
			double[] solutions = QuadraticEquation.solve(1, 4, 4);
			assertSolutions(solutions, -2.0);
		}

	}

	@Nested
	@DisplayName("No solutions")
	class NoSolutions {
		@Test
		@DisplayName("upwards curve")
		void curveUpwards() {
			double[] solutions = QuadraticEquation.solve(1, 0, 1);
			assertEquals(0, solutions.length);
		}

		@Test
		@DisplayName("downwards curve")
		void curveDownwards() {
			double[] solutions = QuadraticEquation.solve(-1, 0, -1);
			assertEquals(0, solutions.length);
		}
	}

	@Nested
	@DisplayName("Linear equation with a = 0")
	class LinearEquation {
		@Test
		@DisplayName("single solution with b != 0")
		void bIsNotZero() {
			double[] solutions = QuadraticEquation.solve(0, 2, -4);
			assertSolutions(solutions, 2.0);
		}

		@Test
		@DisplayName("no solution with b = 0")
		void bIsZero() {
			double[] solutions = QuadraticEquation.solve(0, 0, -4);
			assertSolutions(solutions, new double[0]);
		}
	}

	private void assertSolutions(double[] solutions, double... expected) {
		if (solutions.length != expected.length)
			fail(solutions, expected);
		for (int i = 0; i < solutions.length; i++) {
			assertSolutionValue(solutions, expected, i);
		}
	}

	private void assertSolutionValue(double[] solutions, double[] expected, int index) {
		if (Math.abs(solutions[index] - expected[index]) > 10e-5)
			fail(solutions, expected);
	}

	private void fail(double[] solutions, double[] expected) {
		String message = String.format("Solving the equation failed.");
		throw new AssertionFailedError(message, show(expected), show(solutions));
	}

	private String show(double[] array) {
		String arrayString = Arrays.stream(array).mapToObj(Double::toString).collect(Collectors.joining(", "));
		return "[" + arrayString + "]";
	}
}
