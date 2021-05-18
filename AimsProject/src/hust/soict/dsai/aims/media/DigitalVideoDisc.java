package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.*;

public class DigitalVideoDisc extends Disc {
	
	public String getType() {
		return "DVD";
	}
	
	public String getDetails() {
		return ("Product ID: " + String.valueOf(this.getID())
				+ "\n" + "\t" + "Title: " + this.getTitle()
				+ "\n" + "\t" + "Category: " + this.getCategory()
				+ "\n" + "\t" + "Director: " + this.getDirector()
				+ "\n" + "\t" + "Length: " + String.valueOf(this.getLength()) + " minutes"
				+ "\n" + "\t" + "Price: $" + String.valueOf(this.getCost()));
	}
	
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		} else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
}
