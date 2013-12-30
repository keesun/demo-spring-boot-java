package whiteship.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import whiteship.Application;
import whiteship.service.CommentThreadRepository;
import whiteship.service.PullRequestRepository;

import java.util.Date;

/**
 * @author Keesun Baik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@ActiveProfiles("test")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class CommentThreadTest {

    @Autowired
    PullRequestRepository pullRequestRepository;

    @Autowired
    CommentThreadRepository commentThreadRepository;

    @Test
    public void setPullRequestToCommentThread() {
        commentThreadRepository.deleteAll();
        pullRequestRepository.deleteAll();

        PullRequest pullRequest = new PullRequest();
        pullRequest.setBody("test pullrequest");
        pullRequest.setCreated(new Date());
        pullRequest.setTitle("hihi");
        PullRequest savedPullRequest = pullRequestRepository.save(pullRequest);

        CommentThread thread = new CommentThread();
        thread.setState(CommentThread.ThreadState.OPEN);
        CommentThread savedThread = commentThreadRepository.save(thread);

        savedThread.setPullRequest(savedPullRequest);
        commentThreadRepository.save(savedThread);
    }

}
