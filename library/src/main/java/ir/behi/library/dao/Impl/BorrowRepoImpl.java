package ir.behi.library.dao.Impl;

import ir.behi.library.dao.BorrowRepo;
import ir.behi.library.entity.Borrow;
import ir.behi.library.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/21/2022
 * TIME: 8:34 AM
 **/
@Repository
public class BorrowRepoImpl implements BorrowRepo {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Borrow create(Borrow entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Boolean remove(Integer id) {
        Borrow entity = this.get(id);
        em.remove(entity);
        return true;
    }

    @Override
    public Borrow get(Integer id) {
        return em.find(Borrow.class, id);
    }

    @Override
    public List<Borrow> getAllBorrowByPersonId(Integer personId) {
        Person person = em.find(Person.class, personId);
        return (List<Borrow>) em.find(Borrow.class, person);
    }

    @Override
    public List<Borrow> getAllBorrow() {
        return (List<Borrow>) em.find(Borrow.class, null);
    }
}
