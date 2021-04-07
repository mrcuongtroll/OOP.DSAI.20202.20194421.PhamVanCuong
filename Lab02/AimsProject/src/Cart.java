
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc " + disc.getTitle() + " has been added to the cart.");
		}
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full.");
		}
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//		if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
//			for (int i = 0; i < dvdList.length; i++) {
//				itemsOrdered[qtyOrdered] = dvdList[i];
//				qtyOrdered++;
//				System.out.println("The disc " + dvdList[i].getTitle() + " has been added to the cart.");
//			}
//		}
//		if (qtyOrdered == 20) {
//			System.out.println("The cart is full.");
//		}
//	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < dvdList.length; i++) {
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
				System.out.println("The disc " + dvdList[i].getTitle() + " has been added to the cart.");
			}
		}
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("The disc " + dvd1.getTitle() + " has been added to the cart.");
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("The disc " + dvd2.getTitle() + " has been added to the cart.");
		}
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isEquals(disc)) {
				itemsOrdered[i] = null;
				qtyOrdered--;
				System.out.println("The disc " + disc.getTitle() + " has been removed from the cart.");
			}
		}
	}
	
	public float totalCost() {
		float cost = 0.0f;
		int discsRemaining = qtyOrdered;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (discsRemaining == 0) {
				break;
			}
			
			if (itemsOrdered[i] != null) {
				cost += itemsOrdered[i].getCost();
				discsRemaining--;
			}
		}
		return cost;
	}
}
