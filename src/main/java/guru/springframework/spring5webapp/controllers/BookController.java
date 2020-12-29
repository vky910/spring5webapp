package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //spring MVC stereotype, we want spring to know this is a controller
public class BookController {

    //ask spring to inject the book repository
    private final BookRepository bookRepository; //we are not going to expose this property via getters / setters
    //we do not need to expose getters and setters, but we will have the constructor in here to inject this repository object as a dependency
    //spring will instantiate and inject an instance of that book repository into our Controller
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") //the request path that triggers this Controller method, the method takes the Model to the View
    public String getBooks(Model model){

        //for this request path, spring will return a Model with attribute "books" which has all books from the book
        // repository as values.  this will be passed on to the View
        model.addAttribute("books",bookRepository.findAll());
        return "books/list"; //this is the View that this controller will return (resources/templates/books/list.html)
    }
}
