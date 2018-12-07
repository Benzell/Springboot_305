package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){

        Actor actor = new Actor();
        actor.setName("Sandra Bullowski");
        actor.setNickname("Sandy Cheeks");

        Movie movie = new Movie();
        movie.setCoursename("How to Act 101");
        movie.setProfessor("Denzel Washington");
        movie.setRoom("B220");
        // add the movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);
        //add the list of ovies to the actors movie list
        actor.setMovies(movies);
        //save the actor to the database
        actorRepository.save(actor);
        //grad all the actors from the database and send them to the template
        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
