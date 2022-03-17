package com.example.task14.controllers;

import com.example.task14.entities.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/phone")
public class PhoneController {
    public static Map<Long, Phone> idToPhone = new HashMap<>();
    private static AtomicLong counter = new AtomicLong();

//    @RequestMapping("/create")
//    @ResponseBody
//    public Phone createPhone(
//            @RequestParam(name="name", required=false, defaultValue = "NoNamePhone") String name,
//            @RequestParam(name="year", required = false, defaultValue = "1970") String year) {
//        Long id = counter.incrementAndGet();
//        Phone phone = new Phone(name, year, id);
//        idToPhone.put(id, phone);
//        return phone;
//    }

    @RequestMapping("/new")
    public String createPhone(@ModelAttribute("phone") Phone phone) {
        return "phone/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("phone") Phone phone) {
        Long id = counter.incrementAndGet();
        phone.setId(id);
        idToPhone.put(id, phone);
        System.out.println(idToPhone.toString());
        return "redirect:/phone";
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("phones", new ArrayList<>(idToPhone.values()));
        return "phone/index";
    }

    @RequestMapping("/delete")
    public String deletePhone(
            @RequestParam(name="id", required=true) Long id) {
        System.out.println();
        idToPhone.remove(id);
        return "redirect:/phone";
    }

}
