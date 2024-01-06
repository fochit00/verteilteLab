package com.example.lab.data.services;

import com.example.lab.data.Concert;
import com.example.lab.data.ConcertRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrmService {
    private final ConcertRepo concertRepo;

    public CrmService(ConcertRepo concertRepo){
        this.concertRepo = concertRepo;
    }
    public List<Concert> findAllConcerts(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {


            return concertRepo.findAll();
        } else {
            return concertRepo.search(stringFilter);
        }
    }

    public Optional<Concert> findConcertById(Long id){
        return concertRepo.findById(id);
    }

}
