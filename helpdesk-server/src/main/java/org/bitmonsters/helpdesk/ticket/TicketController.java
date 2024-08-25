package org.bitmonsters.helpdesk.ticket;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.bitmonsters.helpdesk.ticket.TicketService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ticket")
public class TicketController {

    private final TicketService service;


    @PostMapping
    public Ticket addTicket(
            @RequestBody Ticket ticket
    ){
        return service.addTicket(ticket);
    }

    @GetMapping
    public Iterable<Ticket> getAllTickets() {

        return service.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(
            @PathVariable Long id
    ){
        return service.getTicket(id);
    }

    @PostMapping("/{id}/note")
    public String createNote(
            @PathVariable Long ticketId,
            @RequestBody NoteRequest noteRequest
    ){
        return service.addNote(ticketId, noteRequest);
    }

    @PutMapping("/{id}/note/{noteId}")
    public String updateNote(
            @PathVariable Long ticketId,
            @PathVariable Long noteId,
            @RequestBody NoteRequest noteRequest
    ){
        return service.updateNote(ticketId, noteId, noteRequest);
    }

    @GetMapping("/{id}/note")
    public Iterable<Note> getNotes(
            @PathVariable Long ticketId
    ){
        return service.getAllNotes(ticketId);
    }

    @PostMapping("/{id}/feedback")
    public String createFeedback(
            @PathVariable Long ticketId,
            @RequestBody FeedbackRequest feedbackRequest
    ){
        return service.addFeedback(ticketId, feedbackRequest);
    }

    @GetMapping("/{id}/feedback")
    public Feedback getFeedback(
            @PathVariable Long ticketId
    ){
        return service.getFeedback(ticketId);
    }

}
