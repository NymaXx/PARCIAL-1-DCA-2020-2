package View;

import Controller.ControllerMain;
import Model.Logic;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}

	ControllerMain controller;

	int test;
	int order;
	Logic logic;

	public void setup() {
		order = 0;
		this.controller = new ControllerMain(this);
		this.logic = new Logic(this);
		this.controller.sendData();
	}

	public void settings() {
		size(800, 900);
	}

	public void draw() {
		background(255);
		this.controller.paint();
	}

	public void mousePressed() {
		switch (order) {
		case 0:
			
			break;

		case 1:

			break;

		case 2:

			break;

		case 3:
			break;

		case 4:
			break;

		}
	}
}
