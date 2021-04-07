
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < 20) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc " + disc.getTitle() + " has been added to the cart.");
		}
		if (qtyOrdered == 20) {
			System.out.println("The cart is full.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isEquals(disc)) {
				qtyOrdered--;
				System.out.println("The disc " + disc.getTitle() + " has been removed from the cart.");
				for (int j = i; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrdered] = null;
				break;
			}
		}
	}
	
	public float totalCost() {
		float cost = 0.0f;
		for (int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			Object[] detail = itemsOrdered[i].getDetail();
			System.out.println(Integer.toString(i+1) + "." + "\t" + detail[0]
					+ "\t" + "-" + "\t" + detail[1]
					+ "\t" + "-" + "\t" + detail[2]
					+ "\t" + "-" + "\t" + detail[3]
					+ "\t" + "-" + "\t" + detail[4] + " minutes"
					+ ":" + "\t" + "$" + detail[5]);
		}
		System.out.println("Total cost: " + "$" + this.totalCost());
		System.out.println("***************************************************");
		System.out.println("\n");
	}
	
	public boolean search(int id) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("******************SEARCH RESULT********************");
		System.out.println("Product ID: " + id);
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getID() == id) {
				Object[] detail = itemsOrdered[i].getDetail();
				System.out.println(Integer.toString(i+1) + "." + "\t" + detail[0]
						+ "\t" + "-" + "\t" + detail[1]
						+ "\t" + "-" + "\t" + detail[2]
						+ "\t" + "-" + "\t" + detail[3]
						+ "\t" + "-" + "\t" + detail[4] + " minutes"
						+ ":" + "\t" + "$" + detail[5]);
				qty += 1;
				cost = itemsOrdered[i].getCost();
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
		System.out.println("******************SEARCH RESULT********************");
		System.out.println("Product title: " + title);
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].search(title)) {
				Object[] detail = itemsOrdered[i].getDetail();
				System.out.println(Integer.toString(i+1) + "." + "\t" + detail[0]
						+ "\t" + "-" + "\t" + detail[1]
						+ "\t" + "-" + "\t" + detail[2]
						+ "\t" + "-" + "\t" + detail[3]
						+ "\t" + "-" + "\t" + detail[4] + " minutes"
						+ ":" + "\t" + "$" + detail[5]);
				qty += 1;
				cost = itemsOrdered[i].getCost();
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
}
