package org.bitmonsters.helpdesk.customer;

import org.springframework.data.repository.CrudRepository;
import org.bitmonsters.helpdesk.customer.Customer;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
