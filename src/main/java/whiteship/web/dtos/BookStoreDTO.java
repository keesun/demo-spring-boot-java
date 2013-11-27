package whiteship.web.dtos;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Keesun Baik
 */
public class BookStoreDTO extends ResourceSupport{

    String title;

    List<BookDTO> books = new ArrayList<BookDTO>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public void add(BookDTO bookDTO) {
        books.add(bookDTO);
    }
}
