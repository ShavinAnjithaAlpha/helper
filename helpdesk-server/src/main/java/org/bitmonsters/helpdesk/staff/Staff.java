package org.bitmonsters.helpdesk.staff;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bitmonsters.helpdesk.ticket.Ticket;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Staff {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    private String email;
    private String password;
    @CreatedDate
    private Date createdAt;

    @ManyToMany
    @JoinTable(name = "staff_ticket",
            joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    List<Ticket> tickets;



}
