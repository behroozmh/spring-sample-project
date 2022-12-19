package ir.behi.phonebook.dao;

import ir.behi.phonebook.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer> {
}
