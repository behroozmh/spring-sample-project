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
    public Library updateReceive(Library entity) {
        int i = em.createQuery("update Library l " + " set l.existNum= : existNum " +
                " where l.id= :code")
                .setParameter("code", entity.getId())
                .setParameter("existNum", entity.getExistNum() + 1)
                .executeUpdate();

        return em.find(Library.class, entity.getId());
    }

    @Override
    public Library updateReturn(Library entity) {
        int i = em.createQuery("update Library l " + " set l.existNum= : existNum " +
                " where l.id= :code")
                .setParameter("code", entity.getId())
                .setParameter("existNum", entity.getExistNum() - 1)
                .executeUpdate();

        return em.find(Library.class, entity.getId());
    }

    @Override
    public List<Library> isBorrowAble() {
        List<Library> entities = (List<Library>) em.createQuery("from Library l" + " " +
                "where l.isBorrowAble= :true")
                .setParameter("true", true)
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
