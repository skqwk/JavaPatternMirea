package com.example.task20;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {

    List<Manufacture> findAllByName(String name);
    List<Manufacture> findAllByAddress(String address);
}
