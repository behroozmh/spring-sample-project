package ir.behi.phonebook.dao;

import ir.behi.phonebook.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Integer> {
}
