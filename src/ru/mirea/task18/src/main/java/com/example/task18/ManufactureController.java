package com.example.task18;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/manufactures")
@RequiredArgsConstructor
public class ManufactureController {
    private final ManufactureService manufactureService;


    @PostMapping(value="")
    public ResponseEntity<?> create(@RequestBody Manufacture manufacture){
        manufactureService.create(manufacture);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="")
    public ResponseEntity<List<Manufacture>> read() {
        final List<Manufacture> manufactures = manufactureService.readAll();
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Manufacture> read(@PathVariable(name="id") long id) {
        final Manufacture manufacture = manufactureService.read(id);
        return manufacture != null
                ? new ResponseEntity<>(manufacture, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Manufacture manufacture) {
        final boolean updated = manufactureService.update(manufacture, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = manufactureService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value="/address/{address}")
    public ResponseEntity<List<Manufacture>> findManufacturesByAddress(@PathVariable(name="address") String address) {
        final List<Manufacture> manufactures = manufactureService.findManufacturesByAddress(address);
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/name/{name}")
    public ResponseEntity<List<Manufacture>> findManufacturesByName(@PathVariable(name="name") String name) {
        final List<Manufacture> manufactures = manufactureService.findManufacturesByName(name);
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
