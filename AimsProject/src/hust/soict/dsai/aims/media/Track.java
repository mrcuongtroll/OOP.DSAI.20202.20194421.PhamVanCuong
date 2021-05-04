package hust.soict.dsai.aims.media;

public class Track {
	private String title;
	private int length;
	
	public boolean equals(Object track) {
		Track that = (Track) track;
		if ((that instanceof Track) && (this.length == that.length) && (this.title.toLowerCase().equals(that.getTitle().toLowerCase()))) {
			return true;
		} else {
			return false;
		}
	}
	
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
