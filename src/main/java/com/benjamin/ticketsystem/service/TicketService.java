package com.benjamin.ticketsystem.service;

import com.benjamin.ticketsystem.dto.CrearTicketDTO;
import com.benjamin.ticketsystem.dto.TicketResponseDTO;

public interface TicketService {

    TicketResponseDTO crearTicket(CrearTicketDTO dto);
    
}
