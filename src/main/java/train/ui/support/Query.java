package train.ui.support;

import train.ui.domain.Tag;
import train.ui.domain.TagValue;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by apalagin on 4/9/2017.
 */
public class Query {

    private LinkedList<TagValue> requestedPath;

    public static Query parse(String s) {
        Query q = new Query();
        String[] parts = s.split("&");
        for (String p: parts) {
            if (p.isEmpty())
                continue;
            String[] terms = p.split("=");
            Tag tag = new Tag(terms[0], null);
            TagValue tagValue = new TagValue(tag, terms.length > 1 ? terms[1] : null, 0);
            q.add(tagValue);
        }
        return q;
    }

    public Query() {
        this.requestedPath = new LinkedList<>();
    }

    protected void add(TagValue tv) {
        requestedPath.add(tv);
    }

    public Tag getRootTag() {
        TagValue root = requestedPath.getFirst();
        return root.getTag();
    }

    public Tag getLeafTag() {
        TagValue leaf = requestedPath.getLast();
        return leaf.getTag();
    }

    public Collection<TagValue> getRequestPath() {
        return Collections.unmodifiableList(requestedPath);
    }

    public boolean containsTag(Tag tag) {
        return requestedPath.stream().anyMatch(v -> v.getTag().getId().equals(tag.getId()));
    }
}
