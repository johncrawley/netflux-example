package com.jcrawley.netfluxexample.services;

import com.jcrawley.netfluxexample.domain.Movie;
import com.jcrawley.netfluxexample.domain.MovieEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
	
	Mono<Movie> getMovieById(String id);
	Flux<Movie> getAllMovies();
	Flux<MovieEvent> streamMovieEvents(String id);
}
