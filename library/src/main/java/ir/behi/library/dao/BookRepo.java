package ir.behi.library.dao;

import ir.behi.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:45 AM
 **/
@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Boolean existsByNameEquals(String name);
}
