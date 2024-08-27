package org.bitmonsters.helpdesk.staff;

import lombok.RequiredArgsConstructor;
import org.bitmonsters.helpdesk.ticket.*;
import org.springframework.web.bind.annotation.*;
import org.bitmonsters.helpdesk.ticket.FeedbackRequest;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController("api/v1/staff")
public class StaffController {
    private final StaffServices staffServices;


    @GetMapping("/{id}/ticket")
    public List<Ticket> getTickets(
            @PathVariable(name = "id") Long staffId
    ) {
        return staffServices.getTickets(staffId);
    }

    @GetMapping("/{id}/ticket/{ticketId}")
    public Ticket getTicket(
            @PathVariable(name = "id") Long staffId,
            @PathVariable(name = "ticketId") Long ticketId
    ) {
        return staffServices.getTicket(staffId, ticketId);
    }


    @PostMapping("/{id}/ticket/{ticketId}/deadline")
    public Ticket setDeadline(
            @PathVariable(name = "id") Long staffId,
            @PathVariable(name = "ticketId") Long ticketId,
            @RequestBody Date deadlineRequest
    ) {
        return staffServices.setDeadline(staffId, ticketId, deadlineRequest);
    }

    @PostMapping("/{id}/ticket/{ticketId}/note")
    public Note createNote(
            @PathVariable(name = "id") Long staffId,
            @PathVariable(name = "ticketId") Long ticketId,
            @RequestBody NoteRequest noteRequest
    ){
        return staffServices.addNoteByStaff(staffId, ticketId, noteRequest);
    }

    @PostMapping("/{id}/ticket/{ticket_id}/feedback")
    public Feedback feedBackHandler(
            @PathVariable(name = "id") Long staffId,
            @PathVariable(name = "ticket_id") Long ticketId,
            @RequestBody FeedbackRequest feedbackRequest
    ){
        return staffServices.addFeedback(staffId, ticketId, feedbackRequest);

    }

}


