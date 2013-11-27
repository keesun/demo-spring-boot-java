package whiteship.web.dtos;

import org.springframework.hateoas.ResourceSupport;
import whiteship.domain.Book;

/**
 * @author Keesun Baik
 */
public class BookDTO extends ResourceSupport {

    private String title;

    private String price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
