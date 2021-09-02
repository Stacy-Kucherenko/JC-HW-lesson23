package lviv.lgs.ua.task2;

public class Commodity {
	
	private String name;
	private int length;
	private int width;
	private int weight;
	
	public Commodity(String name, int length, int width, int weight) {
		this.name = name;
		this.length = length;
		this.width = width;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public int getWeight() {
		return weight;
	}
		
	public void setName(String name) {
		this.name = name;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return name + ", " + length + " x " + width + " см, " + weight + " г";
	}

}
