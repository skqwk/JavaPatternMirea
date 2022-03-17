package com.example.task16;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phones")
@Getter
@Setter
@NoArgsConstructor
public class Phone {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_year")
    private String creationYear;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phone")
    private List<Manufacture> manufactures;
}
