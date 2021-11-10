package spboot.web.jpa.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spboot.web.jpa.demo.entity.*;

public interface BookRepository extends JpaRepository<Books, Integer> {

	//Books findByTitle(String title);
	
	//@Query("select b.bookId,b.title,b.publisher,b.edition,b.no_of_pages,b.access_type,b.category from Books b where b.title= :title")
	Optional<Books> findBookDetailsByTitle(@Param("title")String title);
	
	//@Query("select b.bookId,b.title,b.publisher,b.edition,b.no_of_pages,b.access_type,b.category from Books b where b.bookId= :bookId")
	Books findBookDetailsByBookId(@Param("bookId")int bookId);
	
	//@Query("select b.bookId,b.title,b.publisher,b.edition,b.no_of_pages,b.access_type,b.category from Books b where b.category =:category")
	List<Books> findByCategory(String category);
       
	/*@Query("select b.book_file from Books where b.bookId=:bookId")
	Optional<Books> findBookContentById(@Param("bookId")int bookId);*/
		
}