package com.example.Project.user;

import com.example.Project.movie.Movie;
import com.example.Project.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/reg")
    public String create(@RequestParam(name = "username", required = true, defaultValue = "") String username,
                         @RequestParam(name = "password", required = true, defaultValue = "") String password){
        User user = new User(username, password);
        userRepository.save(user);
        return ("main");
    }

    @PostMapping("/log")
    public String login(@RequestParam(name = "usernamelog", required = true, defaultValue = "") String username,
                        @RequestParam(name = "passwordlog", required = true, defaultValue = "") String password,
                        HttpSession session, ModelMap map){
        if (userRepository.findByName(username) == null){
            return "error";
        }
            User user = userRepository.findByName(username);
        if (user.getPassword().equals(password)){
            session.setAttribute("username", user.getName());
            return "main";
        }
        return "main";
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "main";
    }

    @RequestMapping
    public User findByUsername(@RequestParam("username") String username) {
        return  userRepository.findByName(username);
    }

//    @GetMapping("/add/{id}")
//    public String addToFav(@RequestParam(name = "id", required = true, defaultValue = "") Long id){
//        User user = new User();
//        user.favorites.add(movieRepository.findById(id).get());
//        return "redirect:/main";
//    }



}
