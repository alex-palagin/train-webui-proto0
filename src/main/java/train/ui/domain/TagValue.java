package train.ui.domain;

/**
 * Created by apalagin on 4/9/2017.
 */
public class TagValue {
    private Tag tag;
    private String value;
    private long documentsTagged;

    public TagValue(Tag tag, String value, long tagged) {
        this.tag = tag;
        this.value = value;
        this.documentsTagged = tagged;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getDocumentsTagged() {
        return documentsTagged;
    }

    public void setDocumentsTagged(long documentsTagged) {
        this.documentsTagged = documentsTagged;
    }
}
