package whiteship.service;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.domain.PullRequest;

/**
 * @author Keesun Baik
 */
public interface PullRequestRepository extends JpaRepository<PullRequest, Long> {
}
