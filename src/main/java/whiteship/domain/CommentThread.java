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
    @JoinTable(
        name = "pull_request_comment_thread",
        joinColumns = @JoinColumn(name = "comment_thread_id", referencedColumnName = "id", insertable = false, updatable = false),
        inverseJoinColumns = @JoinColumn(name = "pull_request_id", referencedColumnName = "id", insertable = false, updatable = false)
    )
    private PullRequest pullRequest;

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
