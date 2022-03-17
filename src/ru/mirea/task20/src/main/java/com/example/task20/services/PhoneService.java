package com.example.task20.services;

import com.example.task20.Phone;
import com.example.task20.PhoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PhoneService {
    private PhoneRepository phoneRepository;

    @Autowired
    PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public void create(Phone phone) {
        log.info("Create phone {}", phone);
        phoneRepository.save(phone);
    }

    public List<Phone> readAll() {
        log.info("Read all phones");
        return phoneRepository.findAll();
    }

    public Phone read(long id) {
        log.info("Read by id = {}", id);
        return phoneRepository.getById(id);
    }

    public boolean update(Phone phone, long id) {
        log.info("Update phone by id = {}", id);
        phone.setId(id);
        phoneRepository.save(phone);
        return true;
    }

    public boolean delete(long id) {
        log.info("Delete phone by id = {}", id);
        phoneRepository.deleteById(id);
        return true;
    }

    public List<Phone> findPhonesByName(String name) {
        log.info("Find phones by name = {}", name);
        return phoneRepository.findAllByName(name);
    }

    public List<Phone> findPhonesByYear(String year) {
        log.info("Find phones by year = {}", year);
        return phoneRepository.findAllByCreationYear(year);
    }
}
