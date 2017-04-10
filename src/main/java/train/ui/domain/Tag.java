package train.ui.domain;

/**
 * Created by apalagin on 4/9/2017.
 */
public class Tag {
    private String id;
    private String name;
    private long documentsTagged;

    protected Tag() { }

    public Tag(String id, String name, long documentsTagged) {
        this.id = id;
        this.name = name;
        this.documentsTagged = documentsTagged;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDocumentsTagged() {
        return documentsTagged;
    }

    public void setDocumentsTagged(long documentsTagged) {
        this.documentsTagged = documentsTagged;
    }
}
