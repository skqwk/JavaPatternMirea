package com.example.task18;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ManufactureService {
    private ManufactureRepository manufactureRepository;

    @Autowired
    ManufactureService(ManufactureRepository manufactureRepository) {
        this.manufactureRepository = manufactureRepository;
    }

    void create(Manufacture manufacture) {
        log.info("Save manufacture");
        manufactureRepository.save(manufacture);
    }

    List<Manufacture> readAll() {
        log.info("Read all manufactures");
        return manufactureRepository.findAll();
    }

    Manufacture read(long id) {
        log.info("Read manufacture by id = {}", id);
        return manufactureRepository.getById(id);
    }

    boolean update(Manufacture manufacture, long id) {
        log.info("Update manufacture with id = {}", id);
        manufacture.setId(id);
        manufactureRepository.save(manufacture);
        return true;
    }

    boolean delete(long id) {
        log.info("Delete manufacture by id = {}", id);
        manufactureRepository.deleteById(id);
        return true;
    }

    List<Manufacture> findManufacturesByAddress(String address) {
        log.info("Find manufactures by address = {}", address);
        return manufactureRepository.findAllByAddress(address);
    }

    List<Manufacture> findManufacturesByName(String name) {
        log.info("Find manufactures by name = {}", name);
        return manufactureRepository.findAllByName(name);
    }
}
