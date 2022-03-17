package com.example.task17;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "manufactures")
@NoArgsConstructor
@Getter
@Setter
public class Manufacture {

    @Id
//    @SequenceGenerator(name = "manufactures_seq", sequenceName = "manufactures_sequence", allocationSize = 1)
//    @GeneratedValue(generator = "manufactures_seq", strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="phone_id")
    @JsonIgnore
    private Phone phone;

}
