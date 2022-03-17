package com.example.lab15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneController {
    private final Driver<Phone> phoneDriver;

    @Autowired
    public PhoneController(Driver<Phone> phoneDriver) {
        this.phoneDriver = phoneDriver;
    }
    @PostMapping(value="/phones")
    public ResponseEntity<?> create(@RequestBody Phone phone){
        phoneDriver.create(phone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/phones")
    public ResponseEntity<List<Phone>> read() {
        final List<Phone> phones = phoneDriver.readAll();
        return phones != null && !phones.isEmpty()
                ? new ResponseEntity<>(phones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/phones/{id}")
    public ResponseEntity<Phone> read(@PathVariable(name="id") long id) {
        final Phone phone = phoneDriver.read(id);
        return phone != null
                ? new ResponseEntity<>(phone, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/phones/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Phone phone) {
        final boolean updated = phoneDriver.update(phone, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/phones/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = phoneDriver.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
