package hkmu.comps380f.dao;

import hkmu.comps380f.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findTicketsByCustomerName(String customerName);
}
