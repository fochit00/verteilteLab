package com.example.lab.data;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "CONCERT")
public class Concert extends AbstractEntity{

    private String name;

    private String city;

    private String location;

    private String date;

    private int tickets;

    private String time;
}
