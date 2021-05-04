package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;

	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}

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
		super(title, category, cost);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	
//	public void setTitle(String title) {
//		this.title = title;
//		return;
//	}
}
