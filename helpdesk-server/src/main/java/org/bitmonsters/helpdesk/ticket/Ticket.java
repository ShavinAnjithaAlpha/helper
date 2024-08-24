package org.bitmonsters.helpdesk.ticket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bitmonsters.helpdesk.customer.Customer;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Ticket {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;

    @OneToOne
    @JoinColumn(name = "id")
    private Customer customer;

    private Date createdAt;

    private Date modifiedAt;
}
