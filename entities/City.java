package entities;

public class City extends Entity {

	private String ncity;
	private int square;
	private int age;
	public City(int id,String ncity, int square, int age) {
		super(id);
		setNcity(ncity);
		setSquare(square);
		setAge(age);
	}

	public String getNcity() {
		return ncity;
	}
	public void setNcity(String ncity) {
		this.ncity = ncity;
	}

	public int getSquare() {
		return square;
	}
	public void setSquare(int square) {
		this.square = square;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		
		return "City [ name: "+getNcity()+", square:"+getSquare()+", foundation "+getAge()+" ]";
	}
}
