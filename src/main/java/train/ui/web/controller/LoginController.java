package train.ui.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by apalagin on 4/4/2017.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @RequestMapping("logout.html")
    public String logout(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }
}
