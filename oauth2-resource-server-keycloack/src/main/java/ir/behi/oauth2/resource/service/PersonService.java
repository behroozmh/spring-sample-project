package ir.behi.oauth2.resource.service;

import ir.behi.oauth2.resource.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO get(Long id);
    Iterable<PersonDTO> getList();
}
