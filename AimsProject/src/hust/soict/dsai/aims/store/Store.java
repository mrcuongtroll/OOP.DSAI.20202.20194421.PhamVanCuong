package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.AddToStoreException;
import hust.soict.dsai.aims.media.*;
import java.time.LocalDate;

public class Store {
	private List<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media medium) throws AddToStoreException {
		if (this.itemsInStore.contains(medium) || medium.getTitle() == null) {
			throw new AddToStoreException();
		} else {
			medium.setDateAdded(LocalDate.now());
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
	
	public Media searchMedia(String title) {
		for (Media medium: this.itemsInStore) {
			if (medium.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return medium;
			}
		}
		return null;
	}
	
	public void print() {
		System.out.println("\n");
		System.out.println("*************AVAILABLE MEDIA IN STORE**************");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsInStore.get(i).getTitle() + "\t-\t" + this.itemsInStore.get(i).getType());
		}
		System.out.println("***************************************************");
		System.out.println("\n");
	}
	
	public ArrayList<Media> getItemsInStore() {
		return (ArrayList<Media>) this.itemsInStore;
	}
}