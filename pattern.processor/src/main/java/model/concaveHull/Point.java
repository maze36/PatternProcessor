package model.concaveHull;

public class Point {

	private final Double x;
	private final Double y;

	public Point(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public String toString() {
		return "(" + x + " " + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			if (x.equals(((Point) obj).getX()) && y.equals(((Point) obj).getY())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		// http://stackoverflow.com/questions/22826326/good-hashcode-function-for-2d-coordinates
		// http://www.cs.upc.edu/~alvarez/calculabilitat/enumerabilitat.pdf
		int tmp = (int) (y + ((x + 1) / 2));
		return Math.abs((int) (x + (tmp * tmp)));
	}
}
