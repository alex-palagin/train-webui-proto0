package train.ui.support;

import org.springframework.stereotype.Service;
import train.ui.domain.Tag;
import train.ui.domain.TagValue;

import java.util.*;

/**
 * Created by apalagin on 4/9/2017.
 */
@Service
public class TagServiceImpl implements TagService {

    private final List<Tag> TAGS = Arrays.asList(
            new Tag("City", "City", 10),
            new Tag("Position", "Position", 5),
            new Tag("Salary", "Salary", 3));

    @Override
    public Collection<Tag> fetchTags() {
        return Collections.unmodifiableCollection(TAGS);
    }

    @Override
    public Collection<Tag> fetchTags(Query q) {
        return Collections.unmodifiableCollection(TAGS);
    }

    private final Map<String, List<TagValue>> VALUES = new HashMap<>();
    {
        VALUES.put("City", Arrays.asList(
                new TagValue(TAGS.get(0), "San Francisco", 1),
                new TagValue(TAGS.get(0), "Santa Clara", 2),
                new TagValue(TAGS.get(0), "Chicago", 3)
        ));
        VALUES.put("Position", Arrays.asList(
                new TagValue(TAGS.get(1), "C++ Developer", 10),
                new TagValue(TAGS.get(1), "Java Developer", 20),
                new TagValue(TAGS.get(1), "PHP Developer",30)
        ));
        VALUES.put("Salary", Arrays.asList(
                new TagValue(TAGS.get(2), "500000", 100),
                new TagValue(TAGS.get(2), "100000", 200),
                new TagValue(TAGS.get(2), "1000000", 300)
        ));
    }

    @Override
    public Collection<TagValue> fetchValues(String tagId) {
        return Collections.unmodifiableCollection(VALUES.get(tagId));
    }

    @Override
    public Collection<TagValue> fetchValues(Query q) {
        return Collections.emptyList();
    }
}
