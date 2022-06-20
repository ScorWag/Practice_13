import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 4700, "AAQ", "EGO", 51 );
        Ticket ticket2 = new Ticket(2, 5250, "VKO", "VOG", 70);
        Ticket ticket3 = new Ticket(3, 5400, "NNM", "DME", 130);
        Ticket ticket4 = new Ticket(4, 3400, "AAQ", "EGO", 50);
        Ticket ticket5 = new Ticket(5, 6250, "NNM", "DME", 120);
        Ticket ticket6 = new Ticket(6, 1400, "NNM", "DME", 135);

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] result = manager.findTickets("NNM", "DME");

        System.out.println(Arrays.toString(result));
        }


    }



