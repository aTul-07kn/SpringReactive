package com.ust.SpringReactive.utils;

import com.ust.SpringReactive.dto.Tripdto;
import com.ust.SpringReactive.entity.Trip;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static Tripdto entityToDto(Trip trip){
        Tripdto tripDto = new Tripdto();
        BeanUtils.copyProperties(trip, tripDto);
        return tripDto;
    }

    public static Trip dtoToEntity(Tripdto tripDto){
        Trip trip=new Trip();
        BeanUtils.copyProperties(tripDto, trip);
        return trip;
    }
}
