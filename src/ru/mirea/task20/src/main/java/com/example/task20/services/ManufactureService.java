package com.example.task20.services;

import com.example.task20.Manufacture;
import com.example.task20.ManufactureRepository;
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

    public void create(Manufacture manufacture) {
        log.info("Save manufacture");
        manufactureRepository.save(manufacture);
    }

    public List<Manufacture> readAll() {
        log.info("Read all manufactures");
        return manufactureRepository.findAll();
    }

    public Manufacture read(long id) {
        log.info("Read manufacture by id = {}", id);
        return manufactureRepository.getById(id);
    }

    public boolean update(Manufacture manufacture, long id) {
        log.info("Update manufacture with id = {}", id);
        manufacture.setId(id);
        manufactureRepository.save(manufacture);
        return true;
    }

    public boolean delete(long id) {
        log.info("Delete manufacture by id = {}", id);
        manufactureRepository.deleteById(id);
        return true;
    }

    public List<Manufacture> findManufacturesByAddress(String address) {
        log.info("Find manufactures by address = {}", address);
        return manufactureRepository.findAllByAddress(address);
    }

    public List<Manufacture> findManufacturesByName(String name) {
        log.info("Find manufactures by name = {}", name);
        return manufactureRepository.findAllByName(name);
    }
}
