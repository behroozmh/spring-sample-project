package ir.behi.library.dao.Impl;

import ir.behi.library.dao.LibraryRepo;
import ir.behi.library.entity.Library;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LibraryRepoImpl implements LibraryRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Library create(Library entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Library get(Integer id) {
        return em.find(Library.class, id);
    }

    @Override
    public boolean remove(Integer id) {
        em.remove(this.get(id));
        return true;
    }

    @Override
    public Library updateReceive(Integer id) {
        Library entity = get(id);
        int exist = entity.getExistNum() - 1;
        int i = em.createQuery("update Library l " + " set l.existNum= : existNum " +
                " where l.book.id= :id")
                .setParameter("id", id)
                .setParameter("existNum", exist)
                .executeUpdate();
        entity.setExistNum(exist);
        return entity;
    }

    @Override
    public Library updateReturn(Integer id) {
        Library entity = get(id);
        if (entity.getExistNum() > 0) {
            int exist = entity.getExistNum() + 1;
            int i = em.createQuery("update LibraryEntity l " + " set l.existNum= : existNum " +
                    " where l.book.id= :id")
                    .setParameter("id", id)
                    .setParameter("existNum", exist)
                    .executeUpdate();
            entity.setExistNum(exist);
            return entity;
        } else
            return null;
    }

    @Override
    public List<Library> isBorrowAble() {
        List<Library> entities = (List<Library>) em.createQuery("from Library l" + " " +
                "where l.isBorrowAble= :isBorrowAble")
                .setParameter("isBorrowAble", true)
                .getResultList();
        return entities;
    }

    @Override
    public List<Library> getAllLibrary() {
        return em.createQuery("from Library l").getResultList();
    }

    @Override
    public Integer checkExistNum(Integer id) {
        int i = (int) em.createQuery("select l.existNum from Library l" + " " + "where l.id=: id")
                .setParameter("id", id)
                .getSingleResult();
        return i;
    }
}
