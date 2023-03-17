package com.enigma.karyawan.controller;

import com.enigma.karyawan.entity.PhoneBook;
import com.enigma.karyawan.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phoneBook")
public class PhoneBookController {

    @Autowired
    PhoneBookService phoneBookService;

    @PostMapping
    public PhoneBook savePhoneBook(@RequestBody PhoneBook PhoneBook){
        return phoneBookService.savePhoneBook(PhoneBook);
    }

    @GetMapping
    public Page<PhoneBook> PhoneBooks(@RequestParam(defaultValue = "0", value = "page") Integer page,
                                      @RequestParam(defaultValue = "100", value = "size") Integer size,
                                      @RequestParam(required = false) String phoneNumber,
                                      @RequestParam(required = false) String searchValue){
        Pageable pageable = PageRequest.of(page, size);
        return phoneBookService.getAllPhoneBook(pageable,searchValue, phoneNumber);
    }

    @RequestMapping("/{id}")
    public PhoneBook getPhoneBookById(@PathVariable Integer id){
        return phoneBookService.getPhoneBookById(id);
    }

    @PutMapping
    public PhoneBook updatePhoneBook(@RequestBody PhoneBook PhoneBook){
        return phoneBookService.savePhoneBook(PhoneBook);
    }

    @DeleteMapping("/{id}")
    public void deletePhoneBook(@PathVariable Integer id){
        phoneBookService.deletePhoneBook(id);
    }
}
