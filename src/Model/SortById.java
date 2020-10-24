package Model;

import java.util.Comparator;

public class SortById implements Comparator<Dog>{

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		return o1.getId() - o2.getId();
	}

}
