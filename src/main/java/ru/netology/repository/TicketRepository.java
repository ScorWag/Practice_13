package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {

    Ticket[] tickets = new Ticket[0];

    public void saveTicket(Ticket ticket) {
        int id = ticket.getId();
        Ticket result = findById(id);

        if (result != null) {
            throw new AlreadyExistsException("Element with id: " + id + " already exists");
        }

        Ticket[] tmp = new Ticket[tickets.length + 1];

        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeTicketById(int removeTicketId) {
        Ticket result = findById(removeTicketId);

        if (result == null) {
            throw new NotFoundException("Element with id: " + removeTicketId + " not found");
        }

        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;

        for (Ticket ticket : tickets) {
            if (ticket.getId() != removeTicketId) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }
}
