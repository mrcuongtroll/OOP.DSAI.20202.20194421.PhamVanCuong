package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public void addAuthor(String authorName) {
		if (this.authors.contains(authorName) == false) {
			this.authors.add(authorName);
		} else {
			System.out.println(authorName + " is already in the list of authors.");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			this.authors.remove(authorName);
		} else {
			System.out.println(authorName + " is not in the list of authors.");
		}
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

}
