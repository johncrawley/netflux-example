package com.jcrawley.netfluxexample.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jcrawley.netfluxexample.domain.Movie;
import com.jcrawley.netfluxexample.repositories.MovieRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {
	
	private final MovieRepository movieRepository;
	
	@Override
	public void run(String... args) throws Exception {
		movieRepository.deleteAll()
			.thenMany(
				Flux.just("Silence of the Lambs", "The Matrix", "Jurassic Park"
					).map(title -> Movie.builder().title(title).build())
					.flatMap(movieRepository::save)
					).subscribe(null, null, () ->{
						movieRepository.findAll().subscribe(System.out::println);
					});
					
			
	}

}
