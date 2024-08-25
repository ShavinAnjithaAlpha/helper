package org.bitmonsters.helpdesk.ticket;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Feedback {
    @Id
    private long id;

    @Column(length = 1024)
    private String content;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date modifiedAt;

    @OneToOne
    Ticket ticket;

}
