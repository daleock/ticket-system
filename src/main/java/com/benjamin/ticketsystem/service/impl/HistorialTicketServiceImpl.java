package com.benjamin.ticketsystem.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.benjamin.ticketsystem.model.HistorialTicket;
import com.benjamin.ticketsystem.model.Ticket;
import com.benjamin.ticketsystem.model.Usuario;
import com.benjamin.ticketsystem.repository.HistorialTicketRepository;
import com.benjamin.ticketsystem.service.HistorialTicketService;


@Service
public class HistorialTicketServiceImpl implements HistorialTicketService {
    
    private final HistorialTicketRepository historialTicketRepository;

    public HistorialTicketServiceImpl(HistorialTicketRepository historialTicketRepository){
        this.historialTicketRepository = historialTicketRepository;
    }
    
    @Override
    public void registrarCambio(Ticket ticket, Usuario usuario, String campo, String valorAnterior, String valorNuevo){
        
        HistorialTicket historial = new HistorialTicket();
        historial.setTicket(ticket);
        historial.setUsuario(usuario);
        historial.setCampo(campo);
        historial.setEstadoAnterior(valorAnterior);
        historial.setEstadoNuevo(valorNuevo);
        historial.setCreatedAt(LocalDateTime.now());

        historialTicketRepository.save(historial);
    }
    

    
}
