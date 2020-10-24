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

	public void setup() {
		this.controller = new ControllerMain(this);
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
		this.controller.clickEvents();
	}
}
