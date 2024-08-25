package org.bitmonsters.helpdesk.ticket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bitmonsters.helpdesk.customer.Customer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Builder
@AllArgsConstructor
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
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedAt;

    @OneToOne
    @JoinColumn(name = "feedback_id")
    Feedback feedback;
}
