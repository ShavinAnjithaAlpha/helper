package org.bitmonsters.helpdesk.ticket;

import org.springframework.data.repository.CrudRepository;
import org.bitmonsters.helpdesk.ticket.Note;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {

    public List<Note> findAllByTicketId(long ticketId);

}
