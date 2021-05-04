package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;


public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public void addTrack(Track track) {
		if (this.tracks.contains(track) == false) {
			this.tracks.add(track);
		} else {
			System.out.println("The track " + track.getTitle() + " is already in the tracklist.");
		}
	}
	
	public void removeTrack(Track track) {
		if (this.tracks.contains(track)) {
			this.tracks.remove(track);
		} else {
			System.out.println("The track " + track.getTitle() + " is not in the tracklist.");
		}
	}

	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
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
