 
public class SeamCarver {
	Picture pict;
	double[][] energyarr;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.pict = picture;
		energyarr = new double[pict.width()] [pict.height()];

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
			double gy = pict.get(x + 1, y).getGreen() - pict.get(x, y - 1).getGreen();
			double delxsq = (rx) * rx + bx * bx + gx * gx;
			System.out.println(delxsq);
			double delysq = (ry) * ry + by * by + gy * gy;
			System.out.println(delxsq);
			energ = Math.sqrt(delxsq + delysq);
		}
		return energ;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
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