package com.example.task16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/manufactures")
public class ManufactureController {
    private final Driver<Manufacture> manufactureDriver;



    @Autowired
    public ManufactureController(Driver<Manufacture> manufactureDriver) {
        this.manufactureDriver = manufactureDriver;
    }
    @PostMapping(value="")
    public ResponseEntity<?> create(@RequestBody Manufacture manufacture){
        manufactureDriver.create(manufacture);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="")
    public ResponseEntity<List<Manufacture>> read() {
        final List<Manufacture> manufactures = manufactureDriver.readAll();
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Manufacture> read(@PathVariable(name="id") long id) {
        final Manufacture manufacture = manufactureDriver.read(id);
        return manufacture != null
                ? new ResponseEntity<>(manufacture, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Manufacture manufacture) {
        final boolean updated = manufactureDriver.update(manufacture, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = manufactureDriver.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
