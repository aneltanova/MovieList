package com.example.Project.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;


    @GetMapping("")
    public String disp(Model model){
        model.addAttribute("movies", movieRepository.findAll());
        return "main";
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable("id") long id){
        movieRepository.deleteById(id);
        return "redirect:/main";
    }

    /*
    @PostMapping
    public String create(@RequestParam(name = "name", required = true, defaultValue = "") String movie_name,
                         @RequestParam(name = "genre", required = true, defaultValue = "") String movie_genre,
                         @RequestParam(name = "rating", required = true, defaultValue = "") long movie_rate,
                         @RequestParam(name = "realise_date", required = true, defaultValue = "") long movie_date,
                         @RequestParam(name = "director", required = true, defaultValue = "") String movie_director,
                         @RequestParam(name = "poster", required = false, defaultValue = "default.png") String movie_poster)
        */

}
