package ir.behi.library.mapper;

import ir.behi.library.base.GeneralMapper;
import ir.behi.library.dto.PersonDTO;
import ir.behi.library.entity.Person;
import org.mapstruct.Mapper;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 11:45 AM
 **/
@Mapper(componentModel = "spring")
public interface PersonConverter extends GeneralMapper<Person, PersonDTO> {
}
