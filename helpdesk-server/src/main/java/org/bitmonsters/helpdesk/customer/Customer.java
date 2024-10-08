package org.bitmonsters.helpdesk.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bitmonsters.helpdesk.ticket.Ticket;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false , length = 50)
    private String FirstName;
    @Column(nullable = false , length = 50)
    private String LastName;

    private String Email;
    private String Password;

    @CreatedDate
    private Date CreatedAt;
    @LastModifiedDate
    private Date ModifiedAt;

}
