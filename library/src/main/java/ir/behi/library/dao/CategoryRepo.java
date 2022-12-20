package ir.behi.library.dao;

import ir.behi.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:46 AM
 **/
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Boolean existsByName(String name);

    Boolean existsByNameEquals(String name);

    List<Category> findByName(String name);
}
