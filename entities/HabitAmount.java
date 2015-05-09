package entities;

public class HabitAmount extends Entity  {

	//private int idAmount;
	private int amount;
	
	public HabitAmount(int id, int amount) {
		super(id);
		this.amount = amount;
	}

	//private int idCity;
	//private int idHabit;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "HabitAmount [amount=" + amount + "]";
	}
}
