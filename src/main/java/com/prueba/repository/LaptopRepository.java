package com.prueba.repository;

import com.prueba.entities.Gadgets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Gadgets, Long> {

}
