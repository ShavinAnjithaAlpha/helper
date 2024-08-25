package org.bitmonsters.helpdesk.ticket;

import lombok.RequiredArgsConstructor;
import org.bitmonsters.helpdesk.Exceptions.NoteNotFoundException;
import org.bitmonsters.helpdesk.Exceptions.TicketNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final NoteRepository noteRepository;

    private final FeedbackRepository feedbackRepository;

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Iterable<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Note addNote(Long ticketId, NoteRequest noteRequest) {
        Ticket ticket = getTicket(ticketId);
        if (ticket == null) {
            throw new TicketNotFoundException("Ticket not found");
        }
        return noteRepository.save(
                Note.builder().content(noteRequest.content()).ticket(
                        Ticket.builder().id(ticketId).build()
                ).build());

    }

    public Note updateNote(Long ticketId, Long noteId, NoteRequest noteRequest) {
        Ticket ticket = getTicket(ticketId);
        if (ticket == null) {

            throw new TicketNotFoundException("Ticket not found");
        }
        Note note = noteRepository.findById(noteId).orElse(null);
        if (note == null) {
            throw new NoteNotFoundException("Note not found");
        }
        note.setContent(noteRequest.content());
        return noteRepository.save(note);

    }

    public Iterable<Note> getAllNotes(Long ticketId) {
        return noteRepository.findAllByTicketId(ticketId);
    }

    public Feedback addFeedback(Long ticketId, FeedbackRequest feedbackRequest){
        Ticket ticket = getTicket(ticketId);
        if (ticket == null) {
            throw new TicketNotFoundException("Ticket not found");
        }
        return feedbackRepository.save(
                Feedback.builder().content(feedbackRequest.content()).ticket(
                        Ticket.builder().id(ticketId).build()
                ).build());

    }

    public Feedback getFeedback(Long ticketId){
        return feedbackRepository.findByTicketId(ticketId);
    }






}


