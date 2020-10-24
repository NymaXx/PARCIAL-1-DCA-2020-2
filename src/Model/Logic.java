package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import processing.core.PApplet;

public class Logic {

	PApplet p;
	String[] dataTwo;
	String[] dataOne;
	ArrayList<Dog> dogs;
	int order;
	String currentSort;

	public Logic(PApplet p) {
		dataTwo = p.loadStrings("datosDos.txt");
		dataOne = p.loadStrings("datosUno.txt");
		dogs = new ArrayList<Dog>();
		this.p = p;
		order = 0;
		currentSort = "";

	}

	public void script() { // METODO DE PRUEBA PARA SABER SI LOS ARCHIVOS SE CARGARON CORRECTAMENTE
		for (int i = 0; i < dataOne.length; i++) {
			System.out.println(dataOne[i]);
		}
	}

	public void combineData() {
		for (int i = 0; i < dataOne.length; i++) {
			String[] arrayOneSplited = dataOne[i].split(",");
			Dog newDog = new Dog(Integer.parseInt(arrayOneSplited[0]), arrayOneSplited[1],
					Integer.parseInt(arrayOneSplited[2]), null, null);

			for (int j = 0; j < dataTwo.length; j++) {
				String[] arrayTwoSplited = dataTwo[j].split(",");

				if (newDog.getId() == Integer.parseInt(arrayTwoSplited[0])) {
					newDog.setRace(arrayTwoSplited[1]);

					try {
						Date date = new SimpleDateFormat("dd-MM-yyyy").parse(arrayTwoSplited[2]);
						newDog.setBirth(date);
						dogs.add(newDog);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
		
		sortById();
	}

	public void paintScreen() {

		// Collections.sort(dogs, new SortById());

		for (int i = 0; i < this.dogs.size(); i++) {

			String id = "Id: " + this.dogs.get(i).getId();
			String name = "Nombre: " + this.dogs.get(i).getName();
			String age = "Edad: " + this.dogs.get(i).getAge();
			String race = "Raza: " + this.dogs.get(i).getRace();
			String birth = "Nacimiento: " + this.dogs.get(i).getBirth();

			p.fill(50, 50, 100);
			p.stroke(255);
			p.rect(0, 70 + (50 * i), 800, 50);

			p.textAlign(PApplet.BASELINE);
			p.fill(255);
			p.textSize(15);
			p.text(id, 10, 90 + (50 * i));
			p.text(name, 80, 90 + (50 * i));
			p.text(age, 300, 90 + (50 * i));
			p.text(race, 10, 110 + (50 * i));
			p.text(birth, 300, 110 + (50 * i));
		}

		p.fill(100);

		p.textAlign(PApplet.CENTER, PApplet.CENTER);
		p.textSize(20);
		p.text("Lista de perros: Peludos Sin Hogar", 400, 10);
		p.textSize(15);
		p.text("Ordenado por: " + currentSort, 400, 40);

		switch (this.order) {
		case 0:
			currentSort = "Id";
			break;

		case 1:
			currentSort = "Nombre";
			break;

		case 2:
			currentSort = "Edad";
			break;

		case 3:
			currentSort = "Raza";
			break;

		case 4:
			currentSort = "Fecha de nacimiento";
			break;
		}

		p.fill(255, 0, 0);
		p.rect(0, 600, 160, 60);

		p.fill(0, 155, 0);
		p.rect(160, 600, 160, 60);

		p.fill(0, 0, 255);
		p.rect(320, 600, 160, 60);

		p.fill(255, 0, 155);
		p.rect(480, 600, 160, 60);

		p.fill(0);
		p.rect(640, 600, 160, 60);

		p.fill(255);
		p.textAlign(PApplet.CENTER, PApplet.CENTER);
		p.text("Ordenar por Id", 80, 620);

		p.textAlign(PApplet.CENTER, PApplet.CENTER);
		p.text("Ordenar por Nombre", 240, 620);

		p.textAlign(PApplet.CENTER, PApplet.CENTER);
		p.text("Ordenar por Edad", 400, 620);

		p.textAlign(PApplet.CENTER, PApplet.CENTER);
		p.text("Ordenar por Raza", 560, 620);

		p.textAlign(PApplet.CENTER, PApplet.CENTER);
		p.text("Ordenar por Fecha", 720, 620);
	}

	public void clickHandle() {
		if (p.mouseX > 0 && p.mouseX < 160 && p.mouseY > 601 && p.mouseY < 658) {
			this.order = 0;
			sortById();
			createFile(dogs, "Id");
		}

		if (p.mouseX > 160 && p.mouseX < 160 + 160 && p.mouseY > 601 && p.mouseY < 658) {
			this.order = 1;
			sortByName();
			createFile(dogs, "Nombre");
		}

		if (p.mouseX > 320 && p.mouseX < 320 + 160 && p.mouseY > 601 && p.mouseY < 658) {
			this.order = 2;
			sortByAge();
			createFile(dogs, "Edad");
		}

		if (p.mouseX > 480 && p.mouseX < 480 + 160 && p.mouseY > 601 && p.mouseY < 658) {
			this.order = 3;
			sortByRace();
			createFile(dogs, "Raza");
		}

		if (p.mouseX > 640 && p.mouseX < 640 + 160 && p.mouseY > 601 && p.mouseY < 658) {
			this.order = 4;
			sortByBirth();
			createFile(dogs, "Nacimiento");
		}
	}

	public void createFile(ArrayList<Dog> list, String sortType) {
		
		String[] data = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			String id = String.valueOf(list.get(i).getId());
			String name = list.get(i).getName();
			String age = String.valueOf(list.get(i).getAge());
			String race = list.get(i).getRace();

			String pattern = "dd-MM-yyyy";
			DateFormat format = new SimpleDateFormat(pattern);

			String birth = format.format(list.get(i).getBirth());
			
			String line = id + "," + name + "," + age + "," + race + "," + birth;
			
			data[i] = line.toLowerCase();
			
			System.out.println(data[i]);
		}
		
		p.saveStrings("ordenPor"+ sortType + ".txt", data);
	}

	public void sortById() {
		Collections.sort(dogs, new SortById());
	}

	public void sortByName() {
		Collections.sort(dogs, new SortByName());
	}

	public void sortByAge() {
		Collections.sort(dogs, new SortByAge());
	}

	public void sortByRace() {
		Collections.sort(dogs, new SortByRace());
	}

	public void sortByBirth() {
		Collections.sort(dogs, new SortByDate());
	}

	public ArrayList<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(ArrayList<Dog> dogs) {
		this.dogs = dogs;
	}

}
