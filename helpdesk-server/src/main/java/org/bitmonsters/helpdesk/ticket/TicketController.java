package org.bitmonsters.helpdesk.ticket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @PostMapping
    public String addTicket(
            @RequestBody Ticket ticket
    ){
        ticketRepository.save(ticket);
        return "Ticket added";
    }

    @GetMapping
    public Iterable<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(
            @PathVariable Long id
    ){
        return ticketRepository.findById(id).orElse(null);
    }



}
