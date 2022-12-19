package ir.behi.phonebook.dao;

import ir.behi.phonebook.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
