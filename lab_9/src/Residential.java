public class Residential extends Property {
	private boolean mul;
	private boolean extWat;
	private int porchSize;
	private int yardSize;

	public Residential() {

	}

	// getters and setters
	public boolean getMul() {
		return mul;
	}

	public void setMul(boolean mul) {
		this.mul = mul;
	}

	public boolean getExtWat() {
		return extWat;
	}

	public void setExtWat(boolean extWat) {
		this.extWat = extWat;
	}

	public int getPorchSize() {
		return porchSize;
	}

	public void setPorchSize(int porchSize) {
		this.porchSize = porchSize;
	}

	public int getYardSize() {
		return yardSize;
	}

	public void setYardSize(int yardSize) {
		this.yardSize = yardSize;
	}

}
