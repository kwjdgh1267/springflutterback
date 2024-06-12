package com.example.flutterconnenttest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Exercise {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String type;

    @OneToMany(mappedBy = "exercise")
    private List<Record> records;

    public Exercise(String title,String type) {
        this.title = title;
        this.type= type;
    }
}
