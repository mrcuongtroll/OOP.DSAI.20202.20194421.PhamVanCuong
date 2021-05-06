package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media... media) {
		for (Media medium: media) {
			if (this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is full.");
				break;
			} else if (!this.itemsOrdered.contains(medium)) {
				this.itemsOrdered.add(medium);
				System.out.println(medium.getTitle() + " has beed added to the cart.");
			} else {
				System.out.println(medium.getTitle() + " is already in the cart.");
			}
		}
	}
	
	public boolean removeMedia(Media medium) {
		if (this.itemsOrdered.remove(medium)) {
			System.out.println(medium.getTitle() + " has been removed from the cart.");
			return true;
		} else {
			System.out.println(medium.getTitle() + " is not in the cart.");
			return false;
		}
	}
	
	public float totalCost() {
		float cost = 0.0f;
		for (Media medium: itemsOrdered) {
			cost += medium.getCost();
		}
		return cost;
	}
	
	public void print() {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).getDetails() + "\n");
		}
		System.out.println("Total cost: " + "$" + this.totalCost());
		System.out.println("***************************************************");
		System.out.println("\n");
	}
	
	public boolean search(int id) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("\n******************SEARCH RESULT********************");
		System.out.println("Product ID: " + id);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getID() == id) {
				System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).getDetails() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total number of product " + id + " found: " + qty);
			System.out.println("Total cost for these product: " + "$" + (cost*qty));
			System.out.println("***************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("Such product is not in the cart");
			System.out.println("***************************************************");
			System.out.println("\n");
			return false;
		}
	}
	
	public boolean search(String title) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("\n******************SEARCH RESULT********************");
		System.out.println("Product title: " + title);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).search(title)) {
				System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).getDetails() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total number of product " + title + " found: " + qty);
			System.out.println("Total cost for these product: " + "$" + (cost*qty));
			System.out.println("***************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("Such product is not in the cart");
			System.out.println("***************************************************");
			System.out.println("\n");
			return false;
		}
	}
	
	public void sortByTitle() {
		Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCost() {
		Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
}
