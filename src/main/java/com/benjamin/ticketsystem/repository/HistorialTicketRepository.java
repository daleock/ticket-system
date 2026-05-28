package com.benjamin.ticketsystem.repository;

import com.benjamin.ticketsystem.model.HistorialTicket;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface HistorialTicketRepository extends JpaRepository<HistorialTicket, Long> {
    
    
}
