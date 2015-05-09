package entities;

public class HabitType extends Entity {

	public HabitType(int id, String type, String languauge) {
		super(id);
		this.type = type;
		this.languauge = languauge;
	}

	private String type;
	private String languauge;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLanguauge() {
		return languauge;
	}

	public void setLanguauge(String languauge) {
		this.languauge = languauge;
	}

	@Override
	public String toString() {

		return "\nHabitType [ id=" + getId() + ", type: " + getType()
				+ ", languauge:" + getLanguauge() + " ]";
	}
}
