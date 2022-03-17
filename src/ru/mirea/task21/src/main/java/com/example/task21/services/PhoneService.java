package com.example.task21.services;

import com.example.task21.Phone;
import com.example.task21.PhoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class PhoneService {
    private PhoneRepository phoneRepository;
    private EmailService emailService;

    @Autowired
    PhoneService(PhoneRepository phoneRepository, EmailService emailService) {
        this.phoneRepository = phoneRepository;
        this.emailService = emailService;
    }

    @Transactional
    public void create(Phone phone) {
        log.info("Create phone {}", phone);
        phoneRepository.save(phone);
        emailService.sendNotification(phone);
    }

    @Transactional
    public List<Phone> readAll() {
        log.info("Read all phones");
        return phoneRepository.findAll();
    }

    @Transactional
    public Phone read(long id) {
        log.info("Read by id = {}", id);
        return phoneRepository.getById(id);
    }

    @Transactional
    public boolean update(Phone phone, long id) {
        log.info("Update phone by id = {}", id);
        phone.setId(id);
        phoneRepository.save(phone);
        return true;
    }

    @Transactional
    public boolean delete(long id) {
        log.info("Delete phone by id = {}", id);
        phoneRepository.deleteById(id);
        return true;
    }

    @Transactional
    public List<Phone> findPhonesByName(String name) {
        log.info("Find phones by name = {}", name);
        return phoneRepository.findAllByName(name);
    }

    @Transactional
    public List<Phone> findPhonesByYear(String year) {
        log.info("Find phones by year = {}", year);
        return phoneRepository.findAllByCreationYear(year);
    }
}
