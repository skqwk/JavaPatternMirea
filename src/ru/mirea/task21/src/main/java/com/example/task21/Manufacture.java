package com.example.task21;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manufactures")
@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @JoinColumn(name="phone_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Phone.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private Phone phone;

    @Column(name="phone_id")
    private Long phoneId;

}
