
package com.mali.movies.controllers;

import com.mali.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jose Maria
 */

@RestController
@RequestMapping("/api/movies")

public class MovieController {
    
    @Autowired
    private MovieRepository movieRepository;
    
}
