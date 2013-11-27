package whiteship.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import whiteship.domain.Book;
import whiteship.service.BookRepository;

import java.util.List;

/**
 * @author Keesun Baik
 */
@Controller
public class BookController {

    @Autowired BookRepository bookRepository;

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

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Book> books() {
        return bookRepository.findAll();
    }

}
