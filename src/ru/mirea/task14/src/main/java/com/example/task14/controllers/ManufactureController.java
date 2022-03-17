package com.example.task14.controllers;

import com.example.task14.entities.Manufacture;
import com.example.task14.entities.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    public static Map<Long, Manufacture> idToManufacture = new HashMap<>();
    private static AtomicLong counter = new AtomicLong();

    @RequestMapping("/create")
    @ResponseBody
    public Manufacture createPhone(
            @RequestParam(name="name", required=false, defaultValue = "NoNameManufacture") String name,
            @RequestParam(name="address", required = false, defaultValue = "NoNameStreet") String address) {
        Long id = counter.incrementAndGet();
        Manufacture manufacture = new Manufacture(name, address, id);
        idToManufacture.put(id, manufacture);
        return manufacture;
    }

    @RequestMapping("/get-all")
    @ResponseBody
    public List<Manufacture> getAllPhones() {
        return new ArrayList<>(idToManufacture.values());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public List<Manufacture> deletePhone(
            @RequestParam(name="id", required=true) Long id) {
        System.out.println();
        idToManufacture.remove(id);
        return new ArrayList<>(idToManufacture.values());
    }

}
