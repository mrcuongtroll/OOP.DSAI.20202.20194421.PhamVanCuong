
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
	}
}
