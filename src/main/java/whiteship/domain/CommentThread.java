package whiteship.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author Keesun Baik
 */
@Entity
public class CommentThread {

    enum ThreadState {
        OPEN, CLOSED;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "thread")
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    private ThreadState state;

    @ManyToOne
    private PullRequest pullRequest;

    public void add(PullRequest pullRequest) {
        this.pullRequest = pullRequest;
        pullRequest.getThreadList().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public ThreadState getState() {
        return state;
    }

    public void setState(ThreadState state) {
        this.state = state;
    }

    public PullRequest getPullRequest() {
        return pullRequest;
    }

    public void setPullRequest(PullRequest pullRequest) {
        this.pullRequest = pullRequest;
    }
}
