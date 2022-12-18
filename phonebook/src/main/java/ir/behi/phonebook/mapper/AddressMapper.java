package ir.behi.phonebook.mapper;

import ir.behi.phonebook.dto.AddressDTO;
import ir.behi.phonebook.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends GeneralMapper<Address, AddressDTO> {
}
