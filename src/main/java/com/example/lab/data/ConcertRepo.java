package com.example.lab.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertRepo extends JpaRepository<Concert, Long> {

    @Query("select c from Concert c " +
            "where lower(c.name) like lower(concat('%', :searchTerm, '%')) ")
    List<Concert> search(@Param("searchTerm") String searchTerm);

    String findByName(String name);

   // List<Concert> findById(Long id);
}
