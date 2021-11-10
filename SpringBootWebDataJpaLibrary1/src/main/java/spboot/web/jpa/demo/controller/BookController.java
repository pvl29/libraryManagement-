package spboot.web.jpa.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spboot.web.jpa.demo.entity.Books;
import spboot.web.jpa.demo.service.BookService;
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    BookService bookService;
	 
    @GetMapping(value="bookid/{bookId}",produces="application/json")
    public ResponseEntity<Books> getBookById(@PathVariable int bookId)
    {
 		Books bk = bookService.getBook(bookId);   
 	    return new ResponseEntity<Books>(bk,HttpStatus.OK);
    }
    
    @GetMapping(value="/tit/{title}",produces="application/json")
    public ResponseEntity<Books> getByTitle(@PathVariable String title)
    {
 		Books bk = bookService.getBookDetailsByTitle(title);   
 	    return new ResponseEntity<Books>(bk,HttpStatus.OK);
    }
    
    @GetMapping(value="cat/{category}",produces="application/json")
    public ResponseEntity<List<Books>> getByCategory(@PathVariable String category)
    {
 		List<Books> bk = bookService.getBookDetailsByCategory(category);   
 	    return new ResponseEntity<List<Books>>(bk,HttpStatus.OK);
    }
    
  /*  @GetMapping(value="/content/{bookId}",produces="application/json")
    public ResponseEntity<Books> getContentById(@PathVariable int bookId)
    {
 		Books bk = bookService.getBookContentById(bookId);   
 	    return new ResponseEntity<Books>(bk,HttpStatus.OK);
    }*/
    
    @ExceptionHandler(RuntimeException.class)
    public HttpStatus noDataFound()
    {
 	   return HttpStatus.NO_CONTENT;
    }
}

