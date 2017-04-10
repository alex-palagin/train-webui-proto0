package train.ui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import train.ui.domain.Tag;
import train.ui.domain.TagValue;
import train.ui.support.Query;
import train.ui.support.TagService;

import java.util.Collection;

/**
 * Created by apalagin on 4/4/2017.
 */
@Controller
public class NavigationController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/sources")
    public String sources(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "blank";
    }

    @RequestMapping("/navigation.html")
    public String navigation(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "navigation";
    }

    @RequestMapping("/navigation/tags.html")
    public String tags(@RequestParam(value="q", required=false) String q, Model model) {
        model.addAttribute("query", q);

        Collection<Tag> tags;
        if (q == null) {
            tags = tagService.fetchTags();
        } else {
            Query query = Query.parse(q);
            tags = tagService.fetchTags(query);
        }

        model.addAttribute("tags", tags);
        return "widgets/navigation/tags";
    }

    @RequestMapping("/navigation/values.html")
    public String values(@RequestParam(value="tagId", required=false) String tagId,
                         @RequestParam(value="q", required=false) String q,
                         Model model) {
        model.addAttribute("tagId", tagId);
        model.addAttribute("q", tagId);

        Collection<TagValue> values;
        if (q == null) {
            values = tagService.fetchValues(tagId);
        } else {
            values = tagService.fetchValues(q);
        }

        model.addAttribute("values", values);
        return "widgets/navigation/values";
    }
}
