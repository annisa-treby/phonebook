package com.enigma.karyawan.service;

import com.enigma.karyawan.dao.PhoneBookDao;
import com.enigma.karyawan.entity.PhoneBook;
import com.enigma.karyawan.exceptions.FieldEmpty;
import com.enigma.karyawan.exceptions.FileNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PhoneBookServiceImpl implements PhoneBookService{

    @Autowired
    PhoneBookDao employeeDao;

    @Override
    public PhoneBook savePhoneBook(PhoneBook phoneBook){
        if (phoneBook.getId() == null) {
            if (phoneBook.getName() != null &&  phoneBook.getPhoneNumber() != null ) {
                phoneBook.setDelete(false);
                phoneBook.setCreatedDate(new Date());
                return employeeDao.save(phoneBook);
            } else throw new FieldEmpty();
        } else {
            if (phoneBook.getName() != null &&  phoneBook.getPhoneNumber() != null ) {
                PhoneBook oldPhoneBook = getPhoneBookById(phoneBook.getId());
                oldPhoneBook.setName(phoneBook.getName());
                oldPhoneBook.setPhoneNumber(phoneBook.getPhoneNumber());
                oldPhoneBook.setUpdatedDate(new Date());
                return employeeDao.save(oldPhoneBook);
            } else throw new FieldEmpty();
        }
    }

    @Override
    public PhoneBook getPhoneBookById(Integer id) {
        if (employeeDao.findById(id).isPresent()){
            PhoneBook employee = employeeDao.findById(id).get();
            return employee;
        } else throw new FileNotFound(id);

    }

    @Override
    public Page<PhoneBook> getAllPhoneBook(Pageable pageable, String name, String phoneNumber) {
        Page<PhoneBook> employees = employeeDao.findPhoneBookByIsDeleteFalse(pageable);
        if(name != null && phoneNumber != null)
            employees = employeeDao.findPhoneBookByIsDeleteFalseAndNameContainsAndPhoneNumberContains(pageable,name,phoneNumber);
        else if (name != null)
            employees = employeeDao.findPhoneBookByIsDeleteFalseAndNameContains(pageable, name);
        else if ( phoneNumber != null)
            employees = employeeDao.findPhoneBookByIsDeleteFalseAndPhoneNumberContains(pageable,phoneNumber);
        return employees;
    }

    @Override
    public void deletePhoneBook(Integer id) {
        PhoneBook employee = getPhoneBookById(id);
        employee.setDelete(true);
        employeeDao.save(employee);
    }
}
