package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        User user =userService.login(username, password);
        if(user != null){
            session.setAttribute("user", user);

            //TODO change the parameter after discuss
            return "redirect:/mainPage";
        }
        return "redirect:/index";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/index";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String name,
                           String description
                           ) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setDescription(description);
        user.setReputation(100);
        userRepository.save(user);
        return "Register success";
    }

    @DeleteMapping("/delete")
    public String deleteUserById(@RequestParam long id) {
        userRepository.deleteById(id);
        return "Deleted";
    }

    @GetMapping("/find")
    public Optional<User> getOneUserById(@RequestParam long id) {
        return userRepository.findById(id);
    }

    //TODO search for similar case
//    @PostMapping("/update")
//    public void updateUserById(User user){
//
//        }
//    }
}
