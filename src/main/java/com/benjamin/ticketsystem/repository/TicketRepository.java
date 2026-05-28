package com.benjamin.ticketsystem.repository;

import com.benjamin.ticketsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket, Long>{
    
}
