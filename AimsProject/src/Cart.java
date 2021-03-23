
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < 20) {
			for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
				if (itemsOrdered[i] == null) {
					itemsOrdered[qtyOrdered] = disc;
					qtyOrdered++;
					System.out.println("The disc " + disc.getTitle() + " has been added to the cart.");
					break;
				}		
			}
		}
		if (qtyOrdered == 20) {
			System.out.println("The cart is full.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equals(disc)) {
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
