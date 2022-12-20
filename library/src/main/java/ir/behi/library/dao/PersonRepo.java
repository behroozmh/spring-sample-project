package ir.behi.library.dao;

import ir.behi.library.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:55 AM
 **/
@Repository
public interface PersonRepo {

    Boolean existByNationalCode(String nationalCode);

    List<Person> findByNationalCode(String nationalCode);

    Person create(Person entity);

    Person update(Person entity);

    Boolean remove(Integer id);

    Boolean remove(Person entity);

    Person get(Integer id);

    List<Person> getAll();
}
