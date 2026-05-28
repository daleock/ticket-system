package com.benjamin.ticketsystem.service;

import java.util.List;

import com.benjamin.ticketsystem.dto.ActualizarTicketDTO;
import com.benjamin.ticketsystem.dto.CrearTicketDTO;
import com.benjamin.ticketsystem.dto.TicketResponseDTO;

public interface TicketService {

    TicketResponseDTO crearTicket(CrearTicketDTO dto);
    List<TicketResponseDTO> listarTickets();
    TicketResponseDTO obtenerPorId(Long id);
    TicketResponseDTO actualizarTicket(Long id, ActualizarTicketDTO dto);
    void eliminarTicket(Long id);
}
