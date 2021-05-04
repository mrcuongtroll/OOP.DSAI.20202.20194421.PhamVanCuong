package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public void addAuthor(String authorName) {
		boolean found = false;
		for (String name: this.authors) {
			if (name.toLowerCase().equals(authorName.toLowerCase())) {
				System.out.println(authorName + " is already in the list of authors.");
				found = true;
				break;
			}
		}
		if (found == false) {
			this.authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		boolean found = false;
		for (String name: this.authors) {
			if (name.toLowerCase().equals(authorName.toLowerCase())) {
				this.authors.remove(name);
				found = true;
				break;
			}
		}
		if (found == false) {
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
