package hkmu.comps380f.exception;

public class TicketNotFound extends RuntimeException {
    public TicketNotFound(long id) {
        super("Ticket " + id + " does not exist.");
    }
}
