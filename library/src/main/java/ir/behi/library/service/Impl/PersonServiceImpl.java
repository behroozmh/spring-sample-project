package ir.behi.library.service.Impl;

import ir.behi.library.dao.PersonRepo;
import ir.behi.library.dto.PersonDTO;
import ir.behi.library.entity.Person;
import ir.behi.library.mapper.PersonConverter;
import ir.behi.library.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/21/2022
 * TIME: 10:22 AM
 **/
@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepo personRepo;
    private PersonConverter converter;

    public PersonServiceImpl(PersonRepo personRepo, PersonConverter converter) {
        this.personRepo = personRepo;
        this.converter = converter;
    }

    @Override
    public List<PersonDTO> findByNationalCode(String code) {
        return converter.ToDTOs(personRepo.findByNationalCode(code));
    }

    @Override
    public Boolean existByCode(String code) {
        return personRepo.existByNationalCode(code);
    }

    @Transactional
    @Override
    public PersonDTO create(PersonDTO person) throws Exception {
        Person entity = personRepo.create(converter.ToEntity(person));
        return converter.ToDTO(entity);
    }

    @Transactional
    @Override
    public PersonDTO update(PersonDTO person) {
        Person entity = personRepo.update(converter.ToEntity(person));
        return converter.ToDTO(entity);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        return personRepo.remove(id);
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        return personRepo.remove(personRepo.get(id));
    }

    @Override
    public PersonDTO get(Integer id) {
        Person entity = personRepo.get(id);
        return converter.ToDTO(entity);
    }

    @Override
    public List<PersonDTO> getAll() {
        return converter.ToDTOs(personRepo.getAll());
    }
}
