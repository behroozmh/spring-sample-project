package ir.behi.phonebook.service.impl;

import ir.behi.phonebook.dao.PersonDAO;
import ir.behi.phonebook.dto.PersonDTO;
import ir.behi.phonebook.entity.Person;
import ir.behi.phonebook.exception.ServiceException;
import ir.behi.phonebook.mapper.PersonMapper;
import ir.behi.phonebook.service.PersonService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * create User: behrooz.mh
 * Date: 12/19/2022
 * TIME: 9:49 AM
 **/
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private PersonDAO dao;
    private PersonMapper mapper;

    public PersonServiceImpl(PersonDAO dao, PersonMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public PersonDTO insert(PersonDTO model) {
        return this.mapper.ToDTO(this.dao.save(mapper.ToEntity(model)));
    }

    @Override
    public PersonDTO update(PersonDTO model) {
        return this.mapper.ToDTO(this.dao.save(mapper.ToEntity(model)));
    }

    @Override
    public boolean delete(Object id) throws ServiceException {
        if (id != null) {
            Optional<Person> entity = this.dao.findById((Integer) id);
            if (entity.isPresent())
                this.dao.delete(entity.get());
            else throw new ServiceException("person.not.found", "1500");
        } else throw new ServiceException("id.not.found", "1500");
        return true;
    }

    @Override
    public PersonDTO findById(Object id) throws ServiceException {
        Optional<Person> entity = this.dao.findById((Integer) id);
        if (entity.isPresent())
            return this.mapper.ToDTO(entity.get());
        else throw new ServiceException("person.not.found", "1500");
    }

    @Override
    public List<PersonDTO> findAll() {
        return mapper.ToDTOs((List) this.dao.findAll());
    }

    @Override
    public List<PersonDTO> findByPaging(Pageable pageable) {
        return mapper.ToDTOs((List) this.dao.findAll(pageable));
    }
}
