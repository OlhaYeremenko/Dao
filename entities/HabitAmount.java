package entities;

public class HabitAmount extends Entity  {


	private int idCity;
	private int idHabit;
	private int amount;
	public int getIdCity() {
		return idCity;
	}


	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}


	public int getIdHabit() {
		return idHabit;
	}


	public void setIdHabit(int idHabit) {
		this.idHabit = idHabit;
	}

	public HabitAmount(int id,int idCity, int idHabit, int amount) {
		super(id);
		this.idCity = idCity;
		this.idHabit = idHabit;
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "\nHabitAmount [id="+getId()+", idCity=" + idCity + ", idHabit=" + idHabit
				+ ", amount=" + amount + "]";
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


}
