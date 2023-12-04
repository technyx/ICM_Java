package org.technyx.icm.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
