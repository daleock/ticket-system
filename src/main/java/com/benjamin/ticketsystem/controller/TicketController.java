package com.benjamin.ticketsystem.controller;

import org.springframework.web.bind.annotation.*;

import com.benjamin.ticketsystem.dto.ActualizarTicketDTO;
import com.benjamin.ticketsystem.dto.CrearTicketDTO;
import com.benjamin.ticketsystem.dto.TicketResponseDTO;
import com.benjamin.ticketsystem.service.TicketService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;      
    }

    @PostMapping
    public TicketResponseDTO crearTicket(@Valid @RequestBody CrearTicketDTO dto){
        return ticketService.crearTicket(dto);
    }
    @GetMapping
    public List<TicketResponseDTO> listarTickets() {
        return ticketService.listarTickets();
    }
    @GetMapping("/{id}")
    public TicketResponseDTO obtenerPorId(@PathVariable Long id) {
    return ticketService.obtenerPorId(id);
    }
    @PutMapping("/{id}")
    public TicketResponseDTO actualizarTicket(
        @PathVariable Long id,
        @RequestBody ActualizarTicketDTO dto){
    return ticketService.actualizarTicket(id, dto);
    }
    @DeleteMapping("/{id}")
    public String eliminarTicket(@PathVariable Long id) {
        ticketService.eliminarTicket(id);
    return "Ticket eliminado correctamente";
    }

}