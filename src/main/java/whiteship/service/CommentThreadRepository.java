package whiteship.service;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.domain.CommentThread;

/**
 * @author Keesun Baik
 */
public interface CommentThreadRepository extends JpaRepository<CommentThread, Long> {
}
