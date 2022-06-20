import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 4700, "AAQ", "EGO", 51);
    Ticket ticket2 = new Ticket(2, 5250, "VKO", "VOG", 70);
    Ticket ticket3 = new Ticket(3, 5400, "NNM", "DME", 130);
    Ticket ticket4 = new Ticket(4, 3400, "AAQ", "EGO", 50);
    Ticket ticket5 = new Ticket(5, 6250, "NNM", "DME", 120);
    Ticket ticket6 = new Ticket(6, 1400, "NNM", "DME", 135);
    Ticket ticket7 = new Ticket(7, 1400, "NNM", "DME", 135);
    Ticket ticket8 = new Ticket(8, 1400, "NNM", "DME", 135);
    Ticket ticket9 = new Ticket(9, 1401, "CEK", "PEE", 135);
    Ticket ticket10 = new Ticket(10, 1399, "CEK", "PEE", 135);
    Ticket ticket11 = new Ticket(11, 1400, "CEK", "PEE", 135);

    @Test
    void shouldFindTicketsWithDifferentPrice() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] actual = manager.findTickets("NNM", "DME");
        Ticket[] expected = {ticket6, ticket3, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnAllArrayOfTicketsWithDifferentPrice() {

        manager.addTicket(ticket3);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] actual = manager.findTickets("NNM", "DME");
        Ticket[] expected = {ticket6, ticket3, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnAllArrayOfTicketsWithTheSamePrice() {

        manager.addTicket(ticket8);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);

        Ticket[] actual = manager.findTickets("NNM", "DME");
        Ticket[] expected = {ticket8, ticket6, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneTicket() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);

        Ticket[] actual = manager.findTickets("VKO", "VOG");
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicketsWithTheSamePrice() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket7);
        manager.addTicket(ticket4);
        manager.addTicket(ticket8);
        manager.addTicket(ticket6);

        Ticket[] actual = manager.findTickets("NNM", "DME");
        Ticket[] expected = {ticket7, ticket8, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicketsWithTheDifferentPriceOnBorderConditions() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);
        manager.addTicket(ticket11);

        Ticket[] actual = manager.findTickets("CEK", "PEE");
        Ticket[] expected = {ticket10, ticket11, ticket9};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnAllArrayWithTheDifferentPriceOnBorderConditions() {

        manager.addTicket(ticket9);
        manager.addTicket(ticket10);
        manager.addTicket(ticket11);

        Ticket[] actual = manager.findTickets("CEK", "PEE");
        Ticket[] expected = {ticket10, ticket11, ticket9};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyArrayWithAllInvalidValues() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] actual = manager.findTickets("GOK", "BRO");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyArrayWithFirstInvalidValue() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] actual = manager.findTickets("GOK", "DME");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyArrayWithSecondInvalidValue() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] actual = manager.findTickets("NNM", "TOR");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
