package com.example.task17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/manufactures")
public class ManufactureController {
    private final ManufactureDAO dao;

    @Autowired
    public ManufactureController(ManufactureDAO dao) {
        this.dao = dao;
    }


    @GetMapping(value="")
    public ResponseEntity<List<Manufacture>> read() {
        final List<Manufacture> manufactures = dao.readAll();
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Manufacture> read(@PathVariable(name="id") long id) {
        final Manufacture manufacture = dao.read(id);
        return manufacture != null
                ? new ResponseEntity<>(manufacture, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/address/{address}")
    public ResponseEntity<List<Manufacture>> findManufacturesByAddress(@PathVariable(name="address") String address) {
        final List<Manufacture> manufactures = dao.findManufacturesByAddress(address);
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
