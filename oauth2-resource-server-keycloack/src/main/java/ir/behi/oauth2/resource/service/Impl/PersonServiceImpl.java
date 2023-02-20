package ir.behi.oauth2.resource.service.Impl;

import ir.behi.oauth2.resource.dto.PersonDTO;
import ir.behi.oauth2.resource.mapper.PersonMapper;
import ir.behi.oauth2.resource.repo.PersonRepo;
import ir.behi.oauth2.resource.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonMapper mapper;
    private PersonRepo repo;

    public PersonServiceImpl(PersonMapper mapper, PersonRepo repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    @Override
    public PersonDTO get(Long id) {
        return mapper.toDTO(repo.findPersonEntityById(id));
    }

    @Override
    public Iterable<PersonDTO> getList() {
        return mapper.toDTOs(repo.findAll());
    }
}
