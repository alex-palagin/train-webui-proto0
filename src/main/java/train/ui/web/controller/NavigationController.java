package train.ui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/navigation/tags.json")
    @ResponseBody
    public Collection<Tag> tags(@RequestParam(value="q", required=false) String q) {
        Collection<Tag> tags;
        if (q == null) {
            tags = tagService.fetchTags();
        } else {
            Query query = Query.parse(q);
            tags = tagService.fetchTags(query);
        }

        return tags;
    }

    @RequestMapping("/navigation/values.json")
    @ResponseBody
    public Collection<TagValue> values(@RequestParam(value="q", required=false) String q) {
        Query query = Query.parse(q);
        Collection<TagValue> values = tagService.fetchValues(query);
        return values;
    }
}
