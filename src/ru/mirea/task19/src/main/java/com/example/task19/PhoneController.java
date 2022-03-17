package com.example.task19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/phones")
public class PhoneController {
    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneDriver) {
        this.phoneService = phoneDriver;
    }

    @PostMapping(value="")
    public ResponseEntity<?> create(@RequestBody Phone phone){
        phoneService.create(phone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="")
    public ResponseEntity<List<Phone>> read() {
        final List<Phone> phones = phoneService.readAll();
        return phones != null && !phones.isEmpty()
                ? new ResponseEntity<>(phones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Phone> read(@PathVariable(name="id") long id) {
        final Phone phone = phoneService.read(id);
        return phone != null
                ? new ResponseEntity<>(phone, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Phone phone) {
        final boolean updated = phoneService.update(phone, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = phoneService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value="/year/{year}")
    public ResponseEntity<List<Phone>> getPhonesByYear(@PathVariable(name="year") String year) {
        final List<Phone> phones = phoneService.findPhonesByYear(year);
        return phones != null && !phones.isEmpty()
                ? new ResponseEntity<>(phones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/name/{name}")
    public ResponseEntity<List<Phone>> getPhonesByName(@PathVariable(name="name") String name) {
        final List<Phone> phones = phoneService.findPhonesByName(name);
        return phones != null && !phones.isEmpty()
                ? new ResponseEntity<>(phones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
