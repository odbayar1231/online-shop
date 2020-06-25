package odko.nanjid.onlineshop2.controller;

import odko.nanjid.onlineshop2.domain.User;
import odko.nanjid.onlineshop2.service.CategoryService;
import odko.nanjid.onlineshop2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes({ "userName","userObj" })
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    @GetMapping(value = {"/","/home"})
    public String homePage(Model model, HttpServletRequest request){
        model.addAttribute("categories", categoryService.getCategories());
        if(!model.containsAttribute("userName")){
            User user = userService.getAuthenticatedUser();
            if(user != null){
                model.addAttribute("userName",user.getFirstName() + " " + user.getLastName());
                model.addAttribute("userObj",user);
            }
        }

        return "index";
    }
}
