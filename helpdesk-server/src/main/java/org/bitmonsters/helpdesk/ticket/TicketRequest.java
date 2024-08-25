package org.bitmonsters.helpdesk.ticket;

public record TicketRequest (
        String title,
        String content,
        long customerId
) {
}
