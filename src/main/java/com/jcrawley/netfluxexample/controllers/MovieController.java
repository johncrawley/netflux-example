package com.jcrawley.netfluxexample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcrawley.netfluxexample.domain.Movie;
import com.jcrawley.netfluxexample.domain.MovieEvent;
import com.jcrawley.netfluxexample.services.MovieService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

	
	private final MovieService movieService;
	
	
	@GetMapping("/{id}")
	Mono<Movie> getMovieById(@PathVariable String id){
		return movieService.getMovieById(id);
	}
	
	@GetMapping
	Flux<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	@GetMapping("/{id}/events")
	Flux<MovieEvent> streamMovieEvents(@PathVariable String id){
		return movieService.streamMovieEvents(id);
	}
	
}
