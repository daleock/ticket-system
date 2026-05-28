package com.benjamin.ticketsystem.service.impl;

import com.benjamin.ticketsystem.dto.CrearTicketDTO;
import com.benjamin.ticketsystem.dto.TicketResponseDTO;
import com.benjamin.ticketsystem.mapper.TicketMapper;
import com.benjamin.ticketsystem.model.*;
import com.benjamin.ticketsystem.repository.*;
import com.benjamin.ticketsystem.service.TicketService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TicketServiceImpl implements TicketService{
    
    private final TicketRepository ticketRepository;
    private final CategoriaRepository categoriaRepository;
    private final PrioridadRepository prioridadRepository;
    private final EstadoTicketRepository estadoTicketRepository;
    private final TicketMapper ticketMapper;
     

    public TicketServiceImpl(
        TicketRepository ticketRepository,
        CategoriaRepository categoriaRepository,
        PrioridadRepository prioridadRepository,
        EstadoTicketRepository estadoTicketRepository,
        TicketMapper ticketMapper
    ) {
        this.ticketRepository = ticketRepository;
        this.categoriaRepository = categoriaRepository;
        this.prioridadRepository = prioridadRepository;
        this.estadoTicketRepository = estadoTicketRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public TicketResponseDTO crearTicket(CrearTicketDTO dto) {

        // buscara las relaciones con la BD
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
            .orElseThrow(() -> new RuntimeException("Categoria no encotnrada"));

        Prioridad prioridad = prioridadRepository.findById(dto.getPrioridadId())
            .orElseThrow(() -> new RuntimeException("Prioridad no encontrada"));

        EstadoTicket estado = estadoTicketRepository.findByNombre("Abierto")
            .orElseThrow(() -> new RuntimeException("Estado inicial no configurado"));

            //creamos entidad ticket
        Ticket ticket = new Ticket();
        ticket.setTitulo(dto.getTitulo());
        ticket.setDescripcion(dto.getDescripcion());
        ticket.setCategoria(categoria);
        ticket.setPrioridad(prioridad);
        ticket.setEstado(estado);
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());

            //guarrdanmos en BD
        Ticket saved = ticketRepository.save(ticket);

        //convertimos a DTO respuesta
        return ticketMapper.toResponse(saved); 


    }
}
