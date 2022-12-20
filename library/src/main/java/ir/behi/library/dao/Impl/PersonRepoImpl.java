package ir.behi.library.dao.Impl;

import ir.behi.library.dao.PersonRepo;
import ir.behi.library.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonRepoImpl implements PersonRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> findByNationalCode(String nationalCode) {
        List<Person> resultList = (List<Person>)
                entityManager.createQuery("from Person p" + " where p.nationalCode = :code")
                        .setParameter("code", Integer.valueOf(nationalCode))
                        .getResultList();
        return resultList;
    }

    public Boolean existByNationalCode(String nationalCode) {
        long count = (Long) entityManager.createQuery("select count(*) from Person p" +
                " where p.nationalCode=:code")
                .setParameter("code", nationalCode)
                .getSingleResult();

        if (count > 0)
            return true;
        else
            return false;
    }


    @Override
    public Person create(Person entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Person update(Person entity) {

        int i = entityManager.createQuery("update Person p " + " set p.firstName= :f , p.lastName= :l , p.nationalCode= :n " +
                " where p.id= :code")
                .setParameter("code", entity.getId())
                .setParameter("f", entity.getFirstName())
                .setParameter("l", entity.getLastName())
                .setParameter("n", entity.getNationalCode())
                .executeUpdate();

        return entityManager.find(Person.class, entity.getId());
    }


    @Override
    public Boolean remove(Integer id) {
        Person entity = this.get(id);
        entityManager.remove(entity);
        return true;
    }

    @Override
    public Boolean remove(Person entity) {
        int i = entityManager.createQuery("delete from Person p " +
                " where p.id= :code")
                .setParameter("code", entity.getId())
                .executeUpdate();
        return true;
    }

    @Override
    public Person get(Integer id) {
        Person entity = (Person)
                entityManager.createQuery("from Person p" + " " + "where p.id=: id")
                        .setParameter("id", id)
                        .getSingleResult();
        return entity;
    }

    @Override
    public List<Person> getAll() {
        return entityManager.createQuery("from Person p").getResultList();
    }
}
