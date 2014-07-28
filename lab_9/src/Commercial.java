public class Commercial extends Property {
	private int mode;
	private boolean food;
	private boolean resAlso;
	private boolean parking;

	// getters and setters
	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public boolean getFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean getResAlso() {
		return resAlso;
	}

	public void setResAlso(boolean resAlso) {
		this.resAlso = resAlso;
	}

	public boolean getParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}
}
