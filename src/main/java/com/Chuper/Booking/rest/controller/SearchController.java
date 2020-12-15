package com.Chuper.Booking.rest.controller;


import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.rest.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 10000)
@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;


    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/getPopularCity")
    public Set<String> getCity(){
        return searchService.getCityList();
    }

    @GetMapping("/searchByString")
    public List<Accommodation> searchAccommodation(@RequestParam(name = "value") String value){
        return searchService.filterAccommodationByAccommodationInfo(value);
    }

    @GetMapping("/searchDetails")
    public List<Accommodation> searchAccommodationDetails(@RequestParam(name = "value") String value,
                                                          @RequestParam(name = "minPrice")Integer minPrice,
                                                          @RequestParam(name = "maxPrice")Integer maxPrice,
                                                          @RequestParam(name = "countStar")Integer countStar){

        return searchService.findByDetailsFilter(minPrice,maxPrice,countStar,value);
    }
}
