package Model;

import java.util.Comparator;

public class SortByDate implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		if (o1.getBirth().before(o2.getBirth())) {
			return -1;
		} else if (o1.getBirth().after(o2.getBirth())) {
			return 1;
		} else {
			return 0;
		}
	}

}
