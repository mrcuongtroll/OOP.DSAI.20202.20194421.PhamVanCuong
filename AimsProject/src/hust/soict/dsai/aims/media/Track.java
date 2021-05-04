package hust.soict.dsai.aims.media;

public class Track {
	private String title;
	private int length;
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public Track(String title) {
		super();
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
}
