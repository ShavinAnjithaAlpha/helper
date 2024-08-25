package org.bitmonsters.helpdesk.ticket;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Note {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 1024)
    private String content;


    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date modifiedAt;

    @OneToOne
    @JoinColumn(name = "ticketId")
    Ticket ticket;


}
