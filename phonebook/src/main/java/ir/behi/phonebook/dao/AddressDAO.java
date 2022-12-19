package ir.behi.phonebook.dao;

import ir.behi.phonebook.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends JpaRepository<Address, Integer> {
}
