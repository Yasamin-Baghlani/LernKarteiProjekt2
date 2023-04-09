package de.yasamin.lernkarteiprojekt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Statistik implements Serializable {


    @Id
    @GeneratedValue
    private long id;

    //TODO



}
