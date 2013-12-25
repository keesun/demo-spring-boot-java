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
public class PullRequestTest {

    @Autowired
    PullRequestRepository pullRequestRepository;

    @Autowired
    CommentThreadRepository commentThreadRepository;

    @Test
    public void setCommentThreadToPullRequest() {
        pullRequestRepository.deleteAll();
        commentThreadRepository.deleteAll();

        PullRequest savedPullRequest = savePullRequest();
        CommentThread savedThread = saveCommentThread();

        savedPullRequest.add(savedThread);
    }

    private CommentThread saveCommentThread() {
        CommentThread thread = new CommentThread();
        thread.setState(CommentThread.ThreadState.OPEN);
        return commentThreadRepository.save(thread);
    }

    private PullRequest savePullRequest() {
        PullRequest pullRequest = new PullRequest();
        pullRequest.setBody("test");
        pullRequest.setTitle("test title");
        pullRequest.setCreated(new Date());
        return pullRequestRepository.save(pullRequest);
    }
}
