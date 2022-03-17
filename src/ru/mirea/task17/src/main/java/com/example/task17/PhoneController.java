package com.example.task17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/phones")
public class PhoneController {
    private final PhoneDAO dao;

    @Autowired
    public PhoneController(PhoneDAO dao) {
        this.dao = dao;
    }


    @GetMapping(value="")
    public ResponseEntity<List<Phone>> read() {
        final List<Phone> phones = dao.readAll();
        return phones != null && !phones.isEmpty()
                ? new ResponseEntity<>(phones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Phone> read(@PathVariable(name="id") long id) {
        final Phone phone = dao.read(id);
        return phone != null
                ? new ResponseEntity<>(phone, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/year/{year}")
    public ResponseEntity<List<Phone>> getPhonesByYear(@PathVariable(name="year") String year) {
        final List<Phone> phones = dao.findPhonesByYear(year);
        return phones != null && !phones.isEmpty()
                ? new ResponseEntity<>(phones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
