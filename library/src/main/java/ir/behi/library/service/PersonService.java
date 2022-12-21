package ir.behi.library.service;

import ir.behi.library.dto.PersonDTO;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 12:22 AM
 **/
public interface PersonService {
    Boolean existByCode(String code);

    List<PersonDTO> findByNationalCode(String code);

    PersonDTO create(PersonDTO person) throws Exception;

    PersonDTO update(PersonDTO person);

    boolean delete(Integer id);

    boolean deleteById(Integer id);

    PersonDTO get(Integer id);

    List<PersonDTO> getAll();
}
