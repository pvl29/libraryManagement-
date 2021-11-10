package spboot.web.jpa.demo.entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.time.LocalDate;    

@Entity
@Table(name = "member_history")
public class MemberHistory 
{
	@Id
	@Column(name="history_id")
	int historyId;
	
	@Column(name="member_id")
	int memberId;
	
	//@Column(name="book_id")
	//int bookId;
	
	@Column(name="read_date")
	LocalDate readDate;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	Books book;
	
	public MemberHistory() {}
	public MemberHistory(int historyId,int memberId,LocalDate readDate,Books book)
	{
		this.historyId = historyId;
		this.memberId = memberId;
		this.book = book;
		this.readDate = readDate;
	}
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	/*public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}*/
	public LocalDate getReadDate() {
		return readDate;
	}
	public void setReadDate(LocalDate readDate) {
		this.readDate = readDate;
	}
	public void setBook(Books book)
	{
		this.book=book;
	}
	public Books getBook()
	{
		return book;
	
}
	
}
