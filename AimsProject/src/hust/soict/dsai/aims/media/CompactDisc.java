package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;


public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public void addTrack(Track track) {
		boolean found = false;
		for (Track t: this.tracks) {
			if (t.equals(track)) {
				System.out.println("The track " + track.getTitle() + " is already in the tracklist.");
				found = true;
				break;
			}
		}
		if (found == false) {
			this.tracks.add(track);
		}
	}
	
	public void removeTrack(Track track) {
		if (this.tracks.remove(track) == false) {
			System.out.println("The track " + track.getTitle() + " is not in the tracklist.");
		}
	}
	
	public int getLength() {
		int totalLength = 0;
		for (Track track: this.tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
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
