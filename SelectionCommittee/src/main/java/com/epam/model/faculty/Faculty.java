package main.java.com.epam.model.faculty;

import java.util.List;

import main.java.com.epam.model.user.User;

public class Faculty {
	private int id;
	private String name;
	private int seatsCount;
	private List<User> entrants;
	private String reception;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeatsCount() {
		return seatsCount;
	}
	public void setSeatsCount(int seatsCount) {
		this.seatsCount = seatsCount;
	}
	public List<User> getEntrants() {
		return entrants;
	}
	public void setEntrants(List<User> entrants) {
		this.entrants = entrants;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReception() {
		return reception;
	}
	public void setReception(String reception) {
		this.reception = reception;
	}

}
