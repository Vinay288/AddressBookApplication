package com.bridgelabz.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbook.model.ContactData;

@Repository
public interface ContactRepository extends JpaRepository<ContactData, Integer>{

}
