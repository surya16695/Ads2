 import java.math.*;
public class SeamCarver {
	Picture pict;
	double[][] energyarr;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.pict = picture;
		energyarr = new double[pict.width()] [pict.height()];
		if (pict == null) {
			throw new IllegalArgumentException("picture is null");
		}

	}
	// current picture
	public Picture picture() {
		return pict;
	}
	// width of current picture
	public int width() {
		return pict.width();
	}

	// height of current picture
	public int height() {
		return pict.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		double energ = 0;
		if (x == 0 || y == 0 || x == width() - 1 || y == height() - 1) {
			double n = 1000;
			return n;
		} else {
			double rx = pict.get(x, y + 1).getRed() - pict.get(x, y - 1).getRed();
			double ry = pict.get(x + 1, y).getRed() - pict.get(x - 1, y).getRed();
			double bx = pict.get(x, y + 1).getBlue() - pict.get(x, y - 1).getBlue();
			double by = pict.get(x + 1, y).getBlue() - pict.get(x - 1, y).getBlue();
			double gx = pict.get(x, y + 1).getGreen() - pict.get(x, y - 1).getGreen();
			double gy = pict.get(x + 1, y).getGreen() - pict.get(x-1, y).getGreen();
			double delxsq = (rx * rx) + (bx * bx) + (gx * gx);
			double delysq = (ry * ry) + (by * by) + (gy * gy);
			energ = Math.sqrt(delxsq + delysq);
		}
		energyarr[x][y] = energ;
		return energ;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		int[] chain = new int [width()];
		for (int i = 0; i < width(); i++) {
			for (int j = 0; j < height(); j++) {
				chain[i] = minEnergy(i, j);
			}
		}
		return chain;
	}

	public int minEnergy(int x, int y) {
		double a = energy(x + 1, y - 1);
		int ay = y - 1;
		double b = energy(x + 1, y);
		int by = y; 
		double c = energy(x + 1, y + 1);
		int cy = y + 1;
		if (y - 1 == 0) {
			double z = Math.min(b, c);
			if (z == b) {
				return by;
			} else {
				return cy;
			}

		} else if (y + 1 == height() - 1) {
			double e = Math.min(a, b);
			if (b == e) {
				return by;
			} else {
				return ay;
			}

		} else if (x + 1 == width() - 1) {
			return y;

		}else {
			double d = Math.min(Math.min(a, b), Math.min(b, c));
			if (d == b) {
				return by;
			} else if (d == c) {
				return cy;
			} else {
				return ay;
			}
		}
	}
	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}