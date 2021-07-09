package com.jcrawley.netfluxexample.services;

import java.time.Duration;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.jcrawley.netfluxexample.domain.Movie;
import com.jcrawley.netfluxexample.domain.MovieEvent;
import com.jcrawley.netfluxexample.repositories.MovieRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;
	
	@Override
	public Mono<Movie> getMovieById(String id) {
		return movieRepository.findById(id);
	}

	@Override
	public Flux<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
	
	@Override
	public Flux<MovieEvent> streamMovieEvents(String id){
		return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
			movieEventSynchronousSink.next(new MovieEvent(id, new Date()));
		}).delayElements(Duration.ofSeconds(1));
	}

}
