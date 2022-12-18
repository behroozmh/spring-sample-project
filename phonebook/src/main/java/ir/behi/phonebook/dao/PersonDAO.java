package ir.behi.phonebook.dao;

import ir.behi.phonebook.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends CrudRepository<Person,Integer> {
}
