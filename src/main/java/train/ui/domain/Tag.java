package train.ui.domain;

/**
 * Created by apalagin on 4/9/2017.
 */
public class Tag {
    private String id;
    private String name;

    protected Tag() { }

    public Tag(String id, String name) {
        this.id = id;
        this.name = name;
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
}
