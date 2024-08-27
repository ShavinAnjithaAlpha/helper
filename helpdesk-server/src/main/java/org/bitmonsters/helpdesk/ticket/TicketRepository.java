package org.bitmonsters.helpdesk.ticket;

import org.springframework.data.repository.CrudRepository;
import org.bitmonsters.helpdesk.ticket.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

//    Date setDeadline (long ticketId);

    List<Ticket> findAllByStaffs_Id(long staffId);

    Ticket findByIdAndStaffs_Id(long ticketId, long staffId);


}
