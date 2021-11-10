package spboot.web.jpa.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.DocFlavor.BYTE_ARRAY;
@Entity
@Table(name = "book")
public class Books 
{
	@Id
	@Column(name="book_id")
	int bookId;
	
	@Column(name="book_title")
	String title;
	
	@Column(name="book_author")
	String author;
	
	@Column(name="book_publisher")
	String publisher;
	
	@Column(name="no_pages")
	int no_of_pages;
	
	@Column(name="edition")
	String edition;
	
	@Column(name="category")
	String category;
	
	@Column(name="access_type")
	char access_type;
	
	@Column(name="book_file")
	byte[] book_file;  
	
	public Books() {}

	public Books(int bookId, String title, String author, String publisher, int no_of_pages, String edition,
			String category, char access_type, byte[] book_file) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.no_of_pages = no_of_pages;
		this.edition = edition;
		this.category = category;
		this.access_type = access_type;
		this.book_file = book_file;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getNo_of_pages() {
		return no_of_pages;
	}

	public void setNo_of_pages(int no_of_pages) {
		this.no_of_pages = no_of_pages;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public char getAccess_type() {
		return access_type;
	}

	public void setAccess_type(char access_type) {
		this.access_type = access_type;
	}

	public byte[] getBook_file() {
		return book_file;
	}

	public void setBook_file(byte[] book_file) {
		this.book_file = book_file;
	}

	

	

	
	
}

