package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public abstract class Media {
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	private int id;
	private static int nbMedia = 0;
	
	public boolean equals(Object medium) {
		if (medium instanceof Media) {
			Media that = (Media) medium;
			return this.title.toLowerCase().equals(that.getTitle().toLowerCase());
		} else {
			return false;
		}
	}
	
	public boolean search(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}


	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbMedia;
		nbMedia += 1;
	}


	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
		this.id = nbMedia;
		nbMedia += 1;
	}


	public Media(String title) {
		super();
		this.title = title;
		this.id = nbMedia;
		nbMedia += 1;
	}


	public int getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}


	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}


	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	public void setDateAdded() {
		this.dateAdded = LocalDate.now();
	}
	
	public abstract String getDetails();
	
	public String toString() {
		return this.getDetails();
	}

}
