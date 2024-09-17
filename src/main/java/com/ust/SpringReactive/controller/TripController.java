package com.ust.SpringReactive.controller;

import com.ust.SpringReactive.dto.Tripdto;
import com.ust.SpringReactive.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping("/addtrip")
    public Mono<Tripdto> addTrip(@RequestBody Mono<Tripdto> tripdto){
        return tripService.addTrip(tripdto);
    }

    @GetMapping("/gettrips")
    public Flux<Tripdto> getAllTrips(){
        return tripService.getAllTrips();
    }
    @GetMapping("/gettrips/{id}")
    public Mono<Tripdto> getTripById(@PathVariable String id){
        return tripService.getTripById(id);
    }

    @GetMapping("/gettrips/getbyrating/{rating}")
    public Flux<Tripdto> getTripsByRating(@PathVariable int rating){
        return tripService.getTripsByRating(rating);
    }

    @GetMapping("/gettrips/getbypricerange")
    public Flux<Tripdto> getTripsByPriceRange(@RequestParam("minPrice") Double minPrice, @RequestParam("maxPrice") Double maxPrice){
        return tripService.getTripsByPriceRange(minPrice, maxPrice);
    }

    @PutMapping("/updatetrip/{id}")
    public Mono<Tripdto> updateTrip(@PathVariable String id, @RequestBody Mono<Tripdto> tripdtomono){
        return tripService.updateTrip(id, tripdtomono);
    }

    @DeleteMapping("deletetrip/{id}")
    public Mono<Void> deleteTrip(@PathVariable String id){
        return tripService.deleteTrip(id);
    }
}
