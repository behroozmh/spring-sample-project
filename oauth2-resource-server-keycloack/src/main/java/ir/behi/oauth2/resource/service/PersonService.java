package ir.behi.oauth2.resource.service;

import ir.behi.oauth2.resource.dto.PersonDTO;

public interface PersonService {
    PersonDTO get(Long id);

    Iterable<PersonDTO> getList();
    PersonDTO update( PersonDTO dto);
}
