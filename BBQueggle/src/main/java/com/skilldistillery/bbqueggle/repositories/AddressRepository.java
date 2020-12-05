package com.skilldistillery.bbqueggle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bbqueggle.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
