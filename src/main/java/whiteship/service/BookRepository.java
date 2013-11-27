package whiteship.service;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.domain.Book;

/**
 * @author Keesun Baik
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
