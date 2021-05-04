package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {

	public Object[] getDetail() {
		Object[] detail = {this.getID(), this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost()};
		return detail;
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
