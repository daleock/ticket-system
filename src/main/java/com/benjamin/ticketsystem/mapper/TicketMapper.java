package com.benjamin.ticketsystem.mapper;

import com.benjamin.ticketsystem.dto.TicketResponseDTO;
import com.benjamin.ticketsystem.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketResponseDTO toResponse(Ticket ticket) {

        TicketResponseDTO dto = new TicketResponseDTO();

        dto.setId(ticket.getId());

        dto.setTitulo(ticket.getTitulo());

        dto.setDescripcion(ticket.getDescripcion());

        dto.setEstado(ticket.getEstado().getNombre());

        dto.setPrioridad(ticket.getPrioridad().getNombre());

        dto.setCategoria(ticket.getCategoria().getNombre());

        return dto;

    }

}