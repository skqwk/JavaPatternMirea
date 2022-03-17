package com.example.task23;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "phones")
@Getter
@Setter
@NoArgsConstructor
public class Phone implements Jsonable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_year")
    private String creationYear;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "phone")
    private List<Manufacture> manufactures = new ArrayList<>();

    @Override
    public String toString() {
        return "Phone{" +
                "\n\tid=" + id +
                ", \n\tname='" + name + '\'' +
                ", \n\tcreationYear='" + creationYear + '\'' +
                "\n}";
    }
}
