package whiteship.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Keesun Baik
 */
@Entity
public class PullRequest {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Lob
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @OneToMany
    @JoinTable(
        name = "comment_thread_pull_request",
        joinColumns = @JoinColumn(name = "pull_request_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "comment_thread_id", referencedColumnName = "id", unique = true)
    )
    private List<CommentThread> threadList = new ArrayList<>();

    public void add(CommentThread newThread) {
        this.getThreadList().add(newThread);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<CommentThread> getThreadList() {
        return threadList;
    }

    public void setThreadList(List<CommentThread> threadList) {
        this.threadList = threadList;
    }


}
