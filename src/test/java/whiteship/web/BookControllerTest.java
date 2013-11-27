package whiteship.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import whiteship.service.BookRepository;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Keesun Baik
 */
public class BookControllerTest {

    BookController bookController;
    MockMvc mockMvc;
    BookRepository mockRepository;

    @Before
    public void setup() {
        bookController = new BookController();
        mockRepository = mock(BookRepository.class);
        bookController.bookRepository = mockRepository;
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void bookForm() throws Exception {
        mockMvc.perform(get("/book"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("book"));
    }

    @Test
    public void bookSubmit() throws Exception {
        mockMvc.perform(post("/book")
                .param("title", "new book")
                .param("price", "1500"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/"));
    }

}
