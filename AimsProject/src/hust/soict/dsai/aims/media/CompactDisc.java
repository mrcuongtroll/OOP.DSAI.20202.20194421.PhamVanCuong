package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;


public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public void addTrack(Track... tracklist) {
		for (Track track: tracklist) {
			if (this.tracks.contains(track)) {
				System.out.println("The track " + track.getTitle() + " is already in the tracklist of " + this.getTitle());
			} else {
				this.tracks.add(track);
				System.out.println("The track " + track.getTitle() + " has been added to the tracklist of " + this.getTitle());
			}
		}
	}
	
	public void removeTrack(Track track) {
		if (this.tracks.remove(track) == false) {
			System.out.println("The track " + track.getTitle() + " is not in the tracklist of " + this.getTitle());
		} else {
			System.out.println("The track " + track.getTitle() + " has been removed from the tracklist of " + this.getTitle());
		}
	}
	
	public int getLength() {
		int totalLength = 0;
		for (Track track: this.tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		for (Track track: this.tracks) {
			track.play();
		}
	}
	
	public String getDetails() {
		StringBuffer tracklist = new StringBuffer(this.tracks.get(0).getTitle());
		for (int i = 1; i < this.tracks.size(); i++) {
			tracklist.append(", " + this.tracks.get(i).getTitle());
		}
		return ("Product ID: " + String.valueOf(this.getID())
		+ "\n" + "\t" + "Title: " + this.getTitle()
		+ "\n" + "\t" + "Category: " + this.getCategory()
		+ "\n" + "\t" + "Artist: " + this.getArtist()
		+ "\n" + "\t" + "Director: " + this.getDirector()
		+ "\n" + "\t" + "Tracklist: " + tracklist
		+ "\n" + "\t" + "Length: " + String.valueOf(this.getLength()) + " minutes"
		+ "\n" + "\t" + "Price: $" + String.valueOf(this.getCost()));
	}

	public CompactDisc(String title, String category, String artist, String director, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public String getArtist() {
		return artist;
	}

}
