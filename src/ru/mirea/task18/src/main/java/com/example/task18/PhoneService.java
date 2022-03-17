package com.example.task18;

import lombok.RequiredArgsConstructor;
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

    void create(Phone phone) {
        log.info("Create phone {}", phone);
        phoneRepository.save(phone);
    }

    List<Phone> readAll() {
        log.info("Read all phones");
        return phoneRepository.findAll();
    }

    Phone read(long id) {
        log.info("Read by id = {}", id);
        return phoneRepository.getById(id);
    }

    boolean update(Phone phone, long id) {
        log.info("Update phone by id = {}", id);
        phone.setId(id);
        phoneRepository.save(phone);
        return true;
    }

    boolean delete(long id) {
        log.info("Delete phone by id = {}", id);
        phoneRepository.deleteById(id);
        return true;
    }

    List<Phone> findPhonesByName(String name) {
        log.info("Find phones by name = {}", name);
        return phoneRepository.findAllByName(name);
    }

    List<Phone> findPhonesByYear(String year) {
        log.info("Find phones by year = {}", year);
        return phoneRepository.findAllByCreationYear(year);
    }
}
