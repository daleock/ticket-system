package com.benjamin.ticketsystem.repository;

import com.benjamin.ticketsystem.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RolRepository extends JpaRepository<Rol, Long>{
    
}
