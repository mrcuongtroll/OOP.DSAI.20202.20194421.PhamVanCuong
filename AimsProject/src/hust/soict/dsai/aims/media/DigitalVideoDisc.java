package hust.soict.dsai.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {


	public Object[] getDetail() {
		Object[] detail = {this.getID(), this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost()};
		return detail;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
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
	
//	public void setTitle(String title) {
//		this.title = title;
//		return;
//	}
}
