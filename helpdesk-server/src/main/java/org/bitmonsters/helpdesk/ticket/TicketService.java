package org.bitmonsters.helpdesk.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.bitmonsters.helpdesk.ticket.TicketRepository;
import org.bitmonsters.helpdesk.ticket.NoteRepository;


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

    public String addNote(Long ticketId, NoteRequest noteRequest) {
        Ticket ticket = getTicket(ticketId);
        if (ticket == null) {
            return "Ticket not found";
        }
        noteRepository.save(
                Note.builder().content(noteRequest.content()).ticket(
                        Ticket.builder().id(ticketId).build()
                ).build());
        return "Note added";
    }

    public String updateNote(Long ticketId, Long noteId, NoteRequest noteRequest) {
        Ticket ticket = getTicket(ticketId);
        if (ticket == null) {
            return "Ticket not found";
        }
        Note note = noteRepository.findById(noteId).orElse(null);
        if (note == null) {
            return "Note not found";
        }
        note.setContent(noteRequest.content());
        noteRepository.save(note);
        return "Note updated";
    }

    public Iterable<Note> getAllNotes(Long ticketId) {
        return noteRepository.findAllByTicketId(ticketId);
    }

    public String addFeedback(Long ticketId, FeedbackRequest feedbackRequest){
        Ticket ticket = getTicket(ticketId);
        if (ticket == null) {
            return "Ticket not found";
        }
        feedbackRepository.save(
                Feedback.builder().content(feedbackRequest.content()).ticket(
                        Ticket.builder().id(ticketId).build()
                ).build());
        return "Feedback added";

    }

    public Feedback getFeedback(Long ticketId){
        return feedbackRepository.findByTicketId(ticketId);
    }






}


