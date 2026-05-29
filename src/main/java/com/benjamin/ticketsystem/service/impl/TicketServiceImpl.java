package com.benjamin.ticketsystem.service.impl;

import com.benjamin.ticketsystem.dto.ActualizarTicketDTO;
import com.benjamin.ticketsystem.dto.CrearTicketDTO;
import com.benjamin.ticketsystem.dto.TicketResponseDTO;
import com.benjamin.ticketsystem.exception.ResourceNotFoundException;
import com.benjamin.ticketsystem.mapper.TicketMapper;
import com.benjamin.ticketsystem.model.*;
import com.benjamin.ticketsystem.repository.*;
import com.benjamin.ticketsystem.service.TicketService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final CategoriaRepository categoriaRepository;
    private final PrioridadRepository prioridadRepository;
    private final EstadoTicketRepository estadoTicketRepository;
    private final TicketMapper ticketMapper;
    private final UsuarioRepository usuarioRepository;

    public TicketServiceImpl(
            TicketRepository ticketRepository,
            CategoriaRepository categoriaRepository,
            PrioridadRepository prioridadRepository,
            EstadoTicketRepository estadoTicketRepository,
            TicketMapper ticketMapper,
            UsuarioRepository usuarioRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.categoriaRepository = categoriaRepository;
        this.prioridadRepository = prioridadRepository;
        this.estadoTicketRepository = estadoTicketRepository;
        this.ticketMapper = ticketMapper;
        this.usuarioRepository = usuarioRepository;
    }

    // CREAR TICKET

    @Override
    public TicketResponseDTO crearTicket(CrearTicketDTO dto) {

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada"));

        Prioridad prioridad = prioridadRepository.findById(dto.getPrioridadId())
                .orElseThrow(() -> new ResourceNotFoundException("Prioridad no encontrada"));

        EstadoTicket estado = estadoTicketRepository.findByNombre("Abierto")
                .orElseThrow(() -> new ResourceNotFoundException("Estado inicial no configurado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Ticket ticket = new Ticket();
        ticket.setTitulo(dto.getTitulo());
        ticket.setDescripcion(dto.getDescripcion());
        ticket.setCategoria(categoria);
        ticket.setPrioridad(prioridad);
        ticket.setEstado(estado);
        ticket.setUsuario(usuario);
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());

        Ticket saved = ticketRepository.save(ticket);

        return ticketMapper.toResponse(saved);
    }

    // LISTAR TODOS

    @Override
    public List<TicketResponseDTO> listarTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(ticketMapper::toResponse)
                .toList();
    }

    // OBTENER POR ID
    @Override
    public TicketResponseDTO obtenerPorId(Long id) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado"));

        return ticketMapper.toResponse(ticket);
    }

    // ACTUALIZAR TICKET
  
    @Override
    public TicketResponseDTO actualizarTicket(Long id, ActualizarTicketDTO dto) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado"));

        if (dto.getTitulo() != null) {
            ticket.setTitulo(dto.getTitulo());
        }

        if (dto.getDescripcion() != null) {
            ticket.setDescripcion(dto.getDescripcion());
        }

        if (dto.getPrioridadId() != null) {
            Prioridad prioridad = prioridadRepository.findById(dto.getPrioridadId())
                    .orElseThrow(() -> new ResourceNotFoundException("Prioridad no encontrada"));
            ticket.setPrioridad(prioridad);
        }

        if (dto.getEstadoId() != null) {
            EstadoTicket estado = estadoTicketRepository.findById(dto.getEstadoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrado"));
            ticket.setEstado(estado);
        }

        ticket.setUpdatedAt(LocalDateTime.now());

        Ticket updated = ticketRepository.save(ticket);

        return ticketMapper.toResponse(updated);
    }

    @Override
        public void eliminarTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado"));

        ticketRepository.delete(ticket);
}
}