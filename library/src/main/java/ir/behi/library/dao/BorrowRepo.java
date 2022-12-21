package ir.behi.library.dao;

import ir.behi.library.entity.Borrow;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:22 AM
 **/
public interface BorrowRepo {
    Borrow create(Borrow entity);

    Boolean remove(Integer id);

    Borrow get(Integer id);

    List<Borrow> getAllBorrowByPersonId(Integer personId);

    List<Borrow> getAllBorrow();
}
