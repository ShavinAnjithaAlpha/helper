package org.bitmonsters.helpdesk.staff;

import lombok.RequiredArgsConstructor;
import org.bitmonsters.helpdesk.Exceptions.TicketNotFoundException;
import org.bitmonsters.helpdesk.ticket.*;
import org.springframework.stereotype.Service;
import org.bitmonsters.helpdesk.staff.StaffRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffServices {


    private final StaffRepository staffRepository;
    private final TicketRepository ticketRepository;

    private final NoteRepository noteRepository;

    private final FeedbackRepository feedbackRepository;

    public List<Ticket> getTickets(long staffId){
        return ticketRepository.findAllByStaffs_Id(staffId);
    }

    public Ticket getTicket(long staffId, long ticketId){
        return ticketRepository.findByIdAndStaffs_Id(staffId, ticketId);
    }

    public Ticket setDeadline(long staffId, long ticketId, Date deadlineRequest) {

        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);


        if (ticket == null){
            throw new TicketNotFoundException("Ticket not found");
        }
        ticket.setDeadline(deadlineRequest);
        return ticketRepository.save(ticket);

    }

    public Note addNoteByStaff(long staffId, long ticketId, NoteRequest noteRequest) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket == null) {
            throw new TicketNotFoundException("Ticket not found");
        }
        return noteRepository.save(
                Note.builder().content(noteRequest.content()).ticket(
                        Ticket.builder().id(ticketId).build()
                ).build());
    }

    public Feedback addFeedback(long staffId, long ticketId, FeedbackRequest feedbackRequest) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket == null) {
            throw new TicketNotFoundException("Ticket not found");
        }
        return feedbackRepository.save(
                Feedback.builder().content(feedbackRequest.content()).ticket(
                        Ticket.builder().id(ticketId).build()
                ).build());
    }


}
