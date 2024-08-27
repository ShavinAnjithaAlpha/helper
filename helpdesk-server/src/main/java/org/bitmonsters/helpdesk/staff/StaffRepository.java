package org.bitmonsters.helpdesk.staff;

import org.bitmonsters.helpdesk.ticket.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.bitmonsters.helpdesk.staff.Staff;

import java.util.List;

public interface StaffRepository extends CrudRepository<Staff, Long> {


}
