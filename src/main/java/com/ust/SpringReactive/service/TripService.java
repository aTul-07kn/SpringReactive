package com.ust.SpringReactive.service;

import com.ust.SpringReactive.dto.Tripdto;
import com.ust.SpringReactive.repository.Triprepo;
import com.ust.SpringReactive.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TripService {
    @Autowired
    private Triprepo repo;

    public Mono<Tripdto> addTrip(Mono<Tripdto> tripDtoMono){
        return tripDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(repo::insert)
                .map(AppUtils::entityToDto);
    }

    public Flux<Tripdto> getAllTrips() {
        return repo.findAll().map(AppUtils::entityToDto);
    }

    public Mono<Tripdto> getTripById(String id) {
        return repo.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<Tripdto> updateTrip(String id, Mono<Tripdto> tripdtomono) {
        return repo.findById(id)
                .flatMap(p-> tripdtomono.map(AppUtils::dtoToEntity))
                .doOnNext(e->e.setId(id))
                .flatMap(repo::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteTrip(String id) {
        return repo.deleteById(id);
    }

    public Flux<Tripdto> getTripsByRating(int rating) {
        return repo.findByRating(rating).map(AppUtils::entityToDto);
    }

    public Flux<Tripdto> getTripsByPriceRange(double minPrice, double maxPrice) {
        return repo.findByPriceBetween(minPrice, maxPrice).map(AppUtils::entityToDto);
    }
}
