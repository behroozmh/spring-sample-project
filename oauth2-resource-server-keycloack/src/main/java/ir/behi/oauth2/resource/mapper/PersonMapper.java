package ir.behi.oauth2.resource.mapper;

import ir.behi.oauth2.resource.dto.PersonDTO;
import ir.behi.oauth2.resource.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDTO(PersonEntity person);

    PersonEntity toEntity(PersonDTO dto);

    Iterable<PersonDTO> toDTOs(Iterable<PersonEntity> person);
}
