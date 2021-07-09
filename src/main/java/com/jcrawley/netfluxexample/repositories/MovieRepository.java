package com.jcrawley.netfluxexample.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jcrawley.netfluxexample.domain.Movie;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
 
}
