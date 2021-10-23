import java.io.FileWriter;
import java.io.IOException;

public class Airplane {
	private String name;
	private String type;
	private int capacity;
	private float priceFactor;
	
	Airplane(){
		this.name = "";	
		this.type = "";
		this.capacity = -1;
		this.priceFactor = 1;
	}
	
	Airplane(String name, String type, int capacity, float priceFactor){
		this.name = name;
		this.type = type;
		this.capacity = capacity;
		this.priceFactor = priceFactor;
		//this.writeToFile();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getPriceFactor() {
		return priceFactor;
	}

	public void setPriceFactor(float priceFactor) {
		this.priceFactor = priceFactor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	void writeToFile() {
		try {
			FileWriter f1 = new FileWriter("Airplanes.txt", true);
			String line="";
			line += this.name;
			line += "\t";
			line += this.type;
			line += "\t";
			line += this.priceFactor;
			line += "\t";
			line += "\t";
			line += this.capacity;
			line += "\n";
			//f1.write(line);
			f1.append(line);
			System.out.println("Airplanes.txt file was updated");
			f1.close();
		}
		catch(IOException e) {
			System.out.println("An error occured\n");
			e.printStackTrace();	
		}
		
	}

}
