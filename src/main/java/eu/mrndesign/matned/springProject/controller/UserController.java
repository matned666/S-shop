package eu.mrndesign.matned.springProject.controller;

import eu.mrndesign.matned.springProject.model.UserModel;
import eu.mrndesign.matned.springProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/add")
    public ModelAndView addUser(Model model){

        return new ModelAndView("userform", "userToInsert", new UserModel());
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute UserModel user){
        user.setAddDate(new Date());
        userRepository.save(user);
        return "index";
    }

    @RequestMapping("/search")
    public String userList(Model model){
        List<UserModel> users = userRepository.getUsers();
        model.addAttribute("users", users);
        return "usersinhell";
    }



}
