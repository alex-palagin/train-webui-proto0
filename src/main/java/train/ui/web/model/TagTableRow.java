package train.ui.web.model;

import train.ui.domain.Tag;
import train.ui.domain.TagStats;

/**
 * Created by apalagin on 5/12/2017.
 */
public class TagTableRow {
    private Tag tag;
    private TagStats stats;

    // For serializer
    public TagTableRow() { }

    // For tests
    public TagTableRow(Tag tag, TagStats stats) {
        this.tag = tag;
        this.stats = stats;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public TagStats getStats() {
        return stats;
    }

    public void setStats(TagStats stats) {
        this.stats = stats;
    }
}
