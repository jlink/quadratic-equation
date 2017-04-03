package quadratic4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class QuadraticEquationTests {

	@Nested
	@DisplayName("Two solutions")
	class TwoSolutions {

		@Test
		@DisplayName("no linear x")
		void solutionsWithNoLinearX() {
			double[] solutions = QuadraticEquation.solve(1, 0, -4);
			assertArrayEquals(new double[] { 2.0, -2.0 }, solutions);
		}

		@Test
		@DisplayName("flipped curve and no linear x")
		void solutionsWithFlippedCurveAndNoLinearX() {
			double[] solutions = QuadraticEquation.solve(-1, 0, 4);
			assertArrayEquals(new double[] { -2.0, 2.0 }, solutions);
		}

		@Test
		@DisplayName("exactly one x\u00B2")
		void solutionsWithExactlyOneSquaredX() {
			double[] solutions = QuadraticEquation.solve(1, 5, 4);
			assertArrayEquals(new double[] { -1.0, -4.0 }, solutions);
		}

		@Test
		@DisplayName("no linear x but high x\u00B2")
		void solutionsWithNoLinearXButHighSquaredX() {
			double[] solutions = QuadraticEquation.solve(10, 0, -40);
			assertArrayEquals(new double[] { 2.0, -2.0 }, solutions);
		}

		@Test
		@DisplayName("high x\u00B2")
		void solutionsWithHighSquaredX() {
			double[] solutions = QuadraticEquation.solve(10, 50, 40);
			assertArrayEquals(new double[] { -1.0, -4.0 }, solutions);
		}

		@Test
		@DisplayName("odd values")
		void solutionsWithOddValues() {
			double[] solutions = QuadraticEquation.solve(7.568, 37.544, 22.14);
			assertEquals(-0.684, solutions[0], 0.0005);
			assertEquals(-4.277, solutions[1], 0.0005);
		}

	}

	@Nested
	@DisplayName("Only one solution")
	class OneSolution {

		@Test
		@DisplayName("upwards curve")
		void curveUpwards() {
			double[] solutions = QuadraticEquation.solve(1, 0, 0);
			assertEquals(1, solutions.length);
			assertEquals(0.0, solutions[0], 10e-10);
		}

		@Test
		@DisplayName("downwards curve")
		void curveDownwards() {
			double[] solutions = QuadraticEquation.solve(1, 0, 0);
			assertEquals(1, solutions.length);
			assertEquals(0.0, solutions[0], 10e-10);
		}

		@Test
		@DisplayName("shifted curve")
		void curveShifted() {
			double[] solutions = QuadraticEquation.solve(1, 4, 4);
			assertEquals(1, solutions.length);
			assertEquals(-2.0, solutions[0], 10e-10);
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
}
