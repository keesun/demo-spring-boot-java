package whiteship.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import whiteship.domain.Book;
import whiteship.service.BookRepository;
import whiteship.web.dtos.BookDTO;
import whiteship.web.dtos.BookStoreDTO;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Keesun Baik
 */
@Controller
public class BookController {

    @Autowired BookRepository bookRepository;
    @Autowired ModelMapper modelMapper;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String bookForm(Model model) {
        model.addAttribute(new Book());
        return "/form";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String bookSubmit(@ModelAttribute Book book, BindingResult error) {
        if(error.hasErrors()) {
            return "/form";
        }
        bookRepository.save(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public HttpEntity<BookDTO> book(@PathVariable int id) {
        Book book = bookRepository.findOne(id);
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
        bookDTO.add(linkTo(methodOn(BookController.class).books()).withRel("all"));
        bookDTO.add(linkTo(methodOn(BookController.class).book(id)).withSelfRel());
        return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<BookStoreDTO> books() {
        BookStoreDTO store = new BookStoreDTO();
        store.setTitle("Whiteship's Book");
        for(Book book : bookRepository.findAll()) {
            store.add(modelMapper.map(book, BookDTO.class));
        }
        store.add(linkTo(methodOn(BookController.class).books()).withSelfRel());
        return new ResponseEntity<BookStoreDTO>(store, HttpStatus.OK);
    }

}
