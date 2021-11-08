package com.bridgelabz.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbook.model.ContactData;

@Repository
public interface ContactRepository extends JpaRepository<ContactData, Integer>{
@Query(value="select * from contact where state = :state",nativeQuery = true)
List<ContactData> findContactByState(String state);

}
