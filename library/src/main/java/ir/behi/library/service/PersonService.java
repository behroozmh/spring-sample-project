package ir.behi.library.service;

import ir.behi.library.dto.PersonDTO;
import ir.behi.library.dto.PersonModel;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 12:22 AM
 **/
public interface PersonService {
    Boolean existByCode(String code);

    List<PersonModel> findByNationalCode(String code);

    PersonModel create(PersonDTO person) throws Exception;

    PersonModel update(PersonDTO person);

    boolean delete(Integer id);

    boolean deleteById(Integer id);

    PersonModel get(Integer id);

    List<PersonModel> getAll();
}
