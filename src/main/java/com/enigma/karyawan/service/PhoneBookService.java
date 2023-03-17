package com.enigma.karyawan.service;

import com.enigma.karyawan.entity.PhoneBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PhoneBookService {
    public PhoneBook savePhoneBook(PhoneBook PhoneBook);
    public PhoneBook getPhoneBookById(Integer id);
    public Page<PhoneBook> getAllPhoneBook(Pageable pageable, String searchValue, String phoneNumber);
    public void deletePhoneBook(Integer id);
}
