package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.*;

public class Store {
	//each element of itemsInStore will be in the form of {DigitalVideoDisc disc, int quantity}
	private List<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media... media) {
		for (Media medium: media) {
			this.itemsInStore.add(medium);
			System.out.println(medium.getTitle() + " has been added to the store.");
		}
	}
	
	public boolean removeMedia(Media medium) {
		if (this.itemsInStore.remove(medium)) {
			System.out.println(medium.getTitle() + " has been removed from the store.");
			return true;
		} else {
			System.out.println(medium.getTitle() + " is not available at the store.");
			return false;
		}
	}

	public void print() {
		System.out.println("\n");
		System.out.println("*************AVAILABLE MEDIA IN STORE**************");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsInStore.get(i).getDetails() + "\n");
		}
		System.out.println("***************************************************");
		System.out.println("\n");
	}

}