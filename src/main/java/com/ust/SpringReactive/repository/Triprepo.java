package com.ust.SpringReactive.repository;

import com.ust.SpringReactive.dto.Tripdto;
import com.ust.SpringReactive.entity.Trip;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface Triprepo extends ReactiveMongoRepository<Trip, String> {

    Flux<Trip> findByRating(int rating);

    Flux<Trip> findByPriceBetween(double minPrice, double maxPrice);
}