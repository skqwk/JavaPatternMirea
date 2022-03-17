package com.example.task22.services;

import com.example.task22.Manufacture;
import com.example.task22.ManufactureRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ManufactureService {
    private ManufactureRepository manufactureRepository;
    private EmailService emailService;

    @Autowired
    ManufactureService(ManufactureRepository manufactureRepository, EmailService emailService) {
        this.manufactureRepository = manufactureRepository;
        this.emailService = emailService;
    }

    @Transactional
    public void create(Manufacture manufacture)  {
        log.info("Save manufacture");
        manufactureRepository.save(manufacture);
        emailService.sendNotification(manufacture);
    }

    @Transactional
    public List<Manufacture> readAll() {
        log.info("Read all manufactures");
        return manufactureRepository.findAll();
    }

    @Transactional
    public Manufacture read(long id) {
        log.info("Read manufacture by id = {}", id);
        return manufactureRepository.findById(id).get();
    }

    @Transactional
    public boolean update(Manufacture manufacture, long id) {
        log.info("Update manufacture with id = {}", id);
        manufacture.setId(id);
        manufactureRepository.save(manufacture);
        return true;
    }

    @Transactional
    public boolean delete(long id) {
        log.info("Delete manufacture by id = {}", id);
        manufactureRepository.deleteById(id);
        return true;
    }

    @Transactional
    public List<Manufacture> findManufacturesByAddress(String address) {
        log.info("Find manufactures by address = {}", address);
        return manufactureRepository.findAllByAddress(address);
    }

    @Transactional
    public List<Manufacture> findManufacturesByName(String name) {
        log.info("Find manufactures by name = {}", name);
        return manufactureRepository.findAllByName(name);
    }
}
