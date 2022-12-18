package ir.behi.phonebook.mapper;

import ir.behi.phonebook.dto.PersonDTO;
import ir.behi.phonebook.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends GeneralMapper<Person, PersonDTO> {
}
