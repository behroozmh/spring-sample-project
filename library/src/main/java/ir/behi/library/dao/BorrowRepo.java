package ir.behi.library.dao;

import ir.behi.library.entity.Borrow;
import ir.behi.library.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:22 AM
 **/
@Repository
public interface BorrowRepo {

    Borrow create(Borrow entity);

    List<Borrow> getAllBorrowPerson(Person person);

    List<Borrow> getAllBorrow();
}
