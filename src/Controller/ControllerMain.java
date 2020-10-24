package Controller;

import processing.core.PApplet;

import Model.Logic;

public class ControllerMain {

	Logic logic;
	PApplet p;

	public ControllerMain(PApplet p) {
		this.logic = new Logic(p);
		this.p = p;
	}
	
	public void sendData() {
		logic.combineData();
	}
	
	public void paint() {
		this.logic.paintScreen();
	}

	public void sortByName() {
		this.logic.sortByName();
	}

	public void sortByAge() {
		this.logic.sortByAge();
	}

	public void sortById() {
		this.logic.sortById();
	}

	public void sortByRace() {
		this.logic.sortByRace();
	}

	public void sortByBirth() {
		this.logic.sortByBirth();
	}

}
