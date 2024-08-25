package org.bitmonsters.helpdesk.ticket;
import org.bitmonsters.helpdesk.ticket.Feedback;

public interface FeedbackRepository extends org.springframework.data.repository.CrudRepository<Feedback, Long> {

    public Feedback findByTicketId(Long ticketId);

}
