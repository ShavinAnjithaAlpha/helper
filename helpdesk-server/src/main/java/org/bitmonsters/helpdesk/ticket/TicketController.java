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
            @RequestBody TicketRequest ticketRequest
    ){
        return service.addTicket(ticketRequest);
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
    public Note createNote(
            @PathVariable(name = "id") Long ticketId,
            @RequestBody NoteRequest noteRequest
    ){
        return service.addNote(ticketId, noteRequest);
    }

    @PutMapping("/{id}/note/{noteId}")
    public Note updateNote(
            @PathVariable(name = "id") Long ticketId,
            @PathVariable(name = "noteId") Long noteId,
            @RequestBody NoteRequest noteRequest
    ){
        return service.updateNote(ticketId, noteId, noteRequest);
    }

    @GetMapping("/{id}/note")
    public Iterable<Note> getNotes(
            @PathVariable(name = "id") Long ticketId
    ){
        return service.getAllNotes(ticketId);
    }

    @PostMapping("/{id}/feedback")
    public Feedback createFeedback(
            @PathVariable(name = "id") Long ticketId,
            @RequestBody FeedbackRequest feedbackRequest
    ){
        return service.addFeedback(ticketId, feedbackRequest);
    }

    @GetMapping("/{id}/feedback")
    public Feedback getFeedback(
            @PathVariable(name = "id") Long ticketId
    ){
        return service.getFeedback(ticketId);
    }

}
