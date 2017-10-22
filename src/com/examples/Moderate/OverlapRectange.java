package com.examples.Moderate;

public class OverlapRectange {

	public static void main(String[] args) {
		OverlapRectange or = new OverlapRectange();

		// Rectangle (l = Top Left corner, r= Bottom Right corner)

		// Rectangle 1
		Corner l1 = new Corner(0, 3);
		Corner r1 = new Corner(5, 0);

		// Rectangle 2 (Overlap with 1)
		Corner l2 = new Corner(4, 5);
		Corner r2 = new Corner(7, 1);

		// Rectangle 3 (Not overlap with 1)
		Corner l3 = new Corner(6, 6);
		Corner r3 = new Corner(8, 4);

		boolean overlapped1 = or.findOverlap(l1, r1, l2, r2);
		System.out.println("1 & 2 Overlapped: " + overlapped1);

		boolean overlapped2 = or.findOverlap(l1, r1, l3, r3);
		System.out.println("1 & 3 Overlapped: " + overlapped2);
	}

	private boolean findOverlap(Corner l1, Corner r1, Corner l2, Corner r2) {
		if ((l2.y <= r1.y) || (l1.y <= r2.y)) {
			return false;
		}

		if ((r1.x < l2.x) || (r2.x < l2.x)) {
			return false;
		}

		return true;
	}

}

class Corner {
	int x;
	int y;

	public Corner(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
