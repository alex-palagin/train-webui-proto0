package train.ui.support;

import train.ui.domain.Tag;
import train.ui.domain.TagValue;

import java.util.Collection;

/**
 * Created by apalagin on 4/9/2017.
 */
public interface TagService {
    Collection<Tag> fetchTags();
    Collection<Tag> fetchTags(Query q);

    Collection<TagValue> fetchValues(String tagId);
    Collection<TagValue> fetchValues(Query q);
}
