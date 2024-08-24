package org.bitmonsters.helpdesk.ticket;

import org.springframework.data.repository.CrudRepository;
import org.bitmonsters.helpdesk.ticket.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
