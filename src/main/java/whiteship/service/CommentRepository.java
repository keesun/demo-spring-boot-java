package whiteship.service;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.domain.Comment;

/**
 * @author Keesun Baik
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
