package View;

import Controller.ControllerMain;
import Model.Logic;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}//NOTA: LOS ARCHIVOS DE ANALISIS COMO REQUERIMIENTOS Y DIAGRAMA DE CLASES
	//SE ENCUENTRAN EN LA CARPETA DE DATA JJUNTO A LOS ARCHIVOS TXT

	ControllerMain controller;

	public void setup() {
		this.controller = new ControllerMain(this);
		this.controller.sendData();
	}

	public void settings() {
		size(800, 690);
	}

	public void draw() {
		background(255);
		this.controller.paint();
		
		//Para saber ubicacion del Mouse
		fill(0);
		textSize(30);
		text("X"+ mouseX + "Y"+mouseY, mouseX, mouseY);
	}

	public void mousePressed() {
		this.controller.clickEvents();
	}
}
