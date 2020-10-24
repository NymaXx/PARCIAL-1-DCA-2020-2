package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import processing.core.PApplet;

public class Logic {

	PApplet p;
	String[] dataTwo;
	String[] dataOne;
	ArrayList<Dog> dogs;

	public Logic(PApplet p) {
		dataTwo = p.loadStrings("datosDos.txt");
		dataOne = p.loadStrings("datosUno.txt");
		dogs = new ArrayList<Dog>();
		this.p = p;
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

		// Verificar si los datos se unieron correctamente
		/*
		 * for (int i = 0; i < this.dogs.size(); i++) {
		 * 
		 * int id = this.dogs.get(i).getId(); String name = this.dogs.get(i).getName();
		 * int age = this.dogs.get(i).getAge(); String race =
		 * this.dogs.get(i).getRace(); String birth = this.dogs.get(i).getBirth();
		 * 
		 * System.out.println( id + "," + name + "," + age + "," + race + "," + birth);
		 * }
		 */

	}

	public void paintList() {

		//Collections.sort(dogs, new SortById());

		for (int i = 0; i < this.dogs.size(); i++) {

			String id = "Id: " + this.dogs.get(i).getId();
			String name = "Nombre: " + this.dogs.get(i).getName();
			String age = "Edad: " + this.dogs.get(i).getAge();
			String race = "Raza: " + this.dogs.get(i).getRace();
			String birth = "Nacimiento: " + this.dogs.get(i).getBirth();

			p.fill(50, 50, 100);
			p.stroke(255);
			p.rect(0, 70 + (70 * i), 800, 70);

			p.fill(255);
			p.textSize(15);
			p.text(id, 10, 90 + (70 * i));
			p.text(name, 80, 90 + (70 * i));
			p.text(age, 300, 90 + (70 * i));
			p.text(race, 10, 110 + (70 * i));
			p.text(birth, 300, 110 + (70 * i));
		}
	}
	
	public void sortById() {
		Collections.sort(dogs, new SortById());
	}
	
		
	public void sortByName() {
		Collections.sort(dogs, new SortById());
	}
	
	public void sortByAge() {
		Collections.sort(dogs, new SortById());
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
