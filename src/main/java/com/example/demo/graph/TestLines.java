package com.example.demo.graph;

import com.example.demo.graph.shared.Point;

public class TestLines {
	static Point lineLineIntersection(Point A, Point B, Point C, Point D) {
		// Line AB represented as a1x + b1y = c1
		double a1 = B.y - A.y;
		double b1 = A.x - B.x;
		double c1 = a1 * (A.x) + b1 * (A.y);

		// Line CD represented as a2x + b2y = c2
		double a2 = D.y - C.y;
		double b2 = C.x - D.x;
		double c2 = a2 * (C.x) + b2 * (C.y);

		double determinant = a1 * b2 - a2 * b1;

		if (determinant == 0) {
			// The lines are parallel.
			return null;
		} else {
			double x = (b2 * c1 - b1 * c2) / determinant;
			double y = (a1 * c2 - a2 * c1) / determinant;
			return new Point((int) x, (int) y);
		}
	}

	// Driver method
	public static void main(String args[]) {
		Point A = new Point(1, 1);
		Point B = new Point(4, 4);
		Point C = new Point(1, 8);
		Point D = new Point(2, 4);

		Point intersection = lineLineIntersection(A, B, C, D);

		if (intersection.x == Double.MAX_VALUE && intersection.y == Double.MAX_VALUE) {
			System.out.println("The given lines AB and CD are parallel.");
		}

		else {
			// NOTE: Further check can be applied in case
			// of line segments. Here, we have considered AB
			// and CD as lines
			System.out.print("The intersection of the given lines AB " + "and CD is: ");
			System.out.println("(" + intersection.x + ", " + intersection.y + ")");
		}
	}
}
