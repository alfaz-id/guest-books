package com.alfazid.guestbooks.repository;

import com.alfazid.guestbooks.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Integer> {
    List<Guest> findByName(String name);
}
