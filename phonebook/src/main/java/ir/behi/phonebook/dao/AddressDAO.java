package ir.behi.phonebook.dao;

import ir.behi.phonebook.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends CrudRepository<Address, Integer> {
}
