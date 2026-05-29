package com.benjamin.ticketsystem.service;

import com.benjamin.ticketsystem.model.Ticket;
import com.benjamin.ticketsystem.model.Usuario;

public interface HistorialTicketService {
    
    void registrarCambio(Ticket ticket, Usuario usuario, String campo, String valorAnterior, String valorNuevo);
    
}
