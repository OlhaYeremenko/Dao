package entities;

import java.io.Serializable;

public abstract class Entity implements Cloneable, Serializable {
	
	private int id;
	public Entity() {
		
	}
	public Entity(int id) {
	
		this.id = id;
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

