package com.enigma.karyawan.dao;

import com.enigma.karyawan.entity.PhoneBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookDao extends JpaRepository<PhoneBook, Integer> {
    public Page<PhoneBook> findPhoneBookByIsDeleteFalse(Pageable pageable);
    public Page<PhoneBook> findPhoneBookByIsDeleteFalseAndNameContainsAndPhoneNumberContains(Pageable pageable, String name, String phoneNumber);
    public Page<PhoneBook> findPhoneBookByIsDeleteFalseAndPhoneNumberContains(Pageable pageable, String phoneNumber);
    public Page<PhoneBook> findPhoneBookByIsDeleteFalseAndNameContains(Pageable pageable, String name);
}
