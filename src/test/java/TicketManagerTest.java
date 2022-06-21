import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketByTimeAscComparator;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketByTimeAscComparator time = new TicketByTimeAscComparator();

    Ticket ticket1 = new Ticket(1, 4700, "AAQ", "EGO", 70);
    Ticket ticket2 = new Ticket(2, 4750, "NNM", "DME", 70);
    Ticket ticket3 = new Ticket(3, 1400, "NNM", "DME", 70);
    Ticket ticket4 = new Ticket(4, 3400, "AAQ", "EGO", 70);
    Ticket ticket5 = new Ticket(5, 3210, "NNM", "DME", 70);
    Ticket ticket6 = new Ticket(6, 4400, "CEK", "PEE", 70);
    Ticket ticket7 = new Ticket(7, 7436, "NNM", "DME", 70);
    Ticket ticket8 = new Ticket(8, 5360, "AAQ", "EGO", 70);
    Ticket ticket9 = new Ticket(9, 7435, "NNM", "DME", 70);
    Ticket ticket10 = new Ticket(10, 7434, "NNM", "DME", 70);


    Ticket ticket11 = new Ticket(11, 1400, "AAQ", "EGO", 120);
    Ticket ticket12 = new Ticket(12, 1400, "CEK", "PEE", 120);
    Ticket ticket13 = new Ticket(13, 1400, "NNM", "DME", 240);
    Ticket ticket14 = new Ticket(14, 1400, "NNM", "DME", 360);
    Ticket ticket15 = new Ticket(15, 1400, "AAQ", "EGO", 120);
    Ticket ticket16 = new Ticket(16, 1400, "NNM", "DME", 120);
    Ticket ticket17 = new Ticket(17, 1400, "CEK", "PEE", 120);
    Ticket ticket18 = new Ticket(18, 1400, "NNM", "DME", 119);
    Ticket ticket19 = new Ticket(19, 1400, "AAQ", "EGO", 120);
    Ticket ticket20 = new Ticket(20, 1400, "NNM", "DME", 121);


    @Test
    void shouldFindTicketsSortByPriceWithSameFlightTime() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);


        Ticket[] actual = manager.findTickets("NNM", "DME", time);
        Ticket[] expected = {ticket3, ticket5, ticket2, ticket10, ticket9, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicketsSortByFlightTimeWithSamePrice() {

        manager.addTicket(ticket11);
        manager.addTicket(ticket12);
        manager.addTicket(ticket13);
        manager.addTicket(ticket14);
        manager.addTicket(ticket15);
        manager.addTicket(ticket16);
        manager.addTicket(ticket17);
        manager.addTicket(ticket18);
        manager.addTicket(ticket19);
        manager.addTicket(ticket20);

        Ticket[] actual = manager.findTickets("NNM", "DME", time);
        Ticket[] expected = {ticket18, ticket16, ticket20, ticket13, ticket14};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicketsSortByAddWithSamePriceAndTime() {

        manager.addTicket(ticket15);
        manager.addTicket(ticket12);
        manager.addTicket(ticket11);
        manager.addTicket(ticket13);
        manager.addTicket(ticket19);

        Ticket[] actual = manager.findTickets("AAQ", "EGO", time);
        Ticket[] expected = {ticket15, ticket11, ticket19};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicketsWithPartSamePriceAndTimeSortFirstByFlightTimeAfterByPrice() {

        manager.addTicket(ticket7);
        manager.addTicket(ticket5);
        manager.addTicket(ticket3);
        manager.addTicket(ticket10);
        manager.addTicket(ticket9);
        manager.addTicket(ticket13);
        manager.addTicket(ticket14);
        manager.addTicket(ticket16);
        manager.addTicket(ticket18);
        manager.addTicket(ticket20);

        Ticket[] actual = manager.findTickets("NNM", "DME", time);
        Ticket[] expected = {ticket3, ticket5, ticket10, ticket9, ticket7, ticket18, ticket16, ticket20, ticket13, ticket14};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicketsSortFirstByFlightTimeAfterByPriceThenByAdd() {

        Ticket ticket1 = new Ticket(1, 4750, "NNM", "DME", 70);
        Ticket ticket2 = new Ticket(2, 4750, "NNM", "DME", 70);
        Ticket ticket3 = new Ticket(3, 4750, "NNM", "DME", 70);

        Ticket ticket4 = new Ticket(4, 7435, "NNM", "DME", 70);
        Ticket ticket5 = new Ticket(5, 7436, "NNM", "DME", 70);
        Ticket ticket6 = new Ticket(6, 7434, "NNM", "DME", 70);

        Ticket ticket7 = new Ticket(7, 900, "NNM", "DME", 240);
        Ticket ticket8 = new Ticket(8, 850, "NNM", "DME", 360);
        Ticket ticket9 = new Ticket(9, 870, "NNM", "DME", 120);

        Ticket ticket10 = new Ticket(10, 3400, "CEK", "PEE", 87);
        Ticket ticket11 = new Ticket(11, 4550, "AAQ", "EGO", 60);
        Ticket ticket12 = new Ticket(12, 2485, "PEE", "AAQ", 74);

        manager.addTicket(ticket2);
        manager.addTicket(ticket1);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);
        manager.addTicket(ticket11);
        manager.addTicket(ticket12);

        Ticket[] actual = manager.findTickets("NNM", "DME", time);
        Ticket[] expected = {ticket2, ticket1, ticket3, ticket6, ticket4, ticket5, ticket9, ticket7, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }


}
