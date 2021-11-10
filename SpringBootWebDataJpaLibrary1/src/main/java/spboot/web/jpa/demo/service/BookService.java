package spboot.web.jpa.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spboot.web.jpa.demo.entity.Books;

import spboot.web.jpa.demo.repository.BookRepository;

@Service
public class BookService {
    @Autowired
	BookRepository bookRepository;
	
    @Transactional(readOnly=true)
	public Books getBook(int bookId)
	{
		Books optbk = bookRepository.findBookDetailsByBookId(bookId);
		return optbk;
		
	}
    
    @Transactional(readOnly=true)
  	public Books getBookDetailsByTitle(String title)
  	{
  		Optional<Books> optbk = bookRepository.findBookDetailsByTitle(title);
  		if(optbk.isPresent()) return optbk.get();
  		throw new RuntimeException("Book Does Not EXIST");
  	}
    
    @Transactional(readOnly=true)
  	public List<Books> getBookDetailsByCategory(String category)
  	{
    	List<Books> elist = bookRepository.findByCategory(category);
		if(elist.size() > 0) return elist;
		throw new RuntimeException("No data Found");
  	}
    
   /* @Transactional(readOnly=true)
  	public Books getBookContentById(int bookId)
  	{
    	Optional<Books> elist = bookRepository.findBookContentById(bookId);
    	if(elist.isPresent()) return elist.get();
		throw new RuntimeException("No data Found");
  	}*/
    
}