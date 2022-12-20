package ir.behi.library.mapper;

import ir.behi.library.base.GeneralMapper;
import ir.behi.library.dto.LibraryDTO;
import ir.behi.library.entity.Library;
import org.mapstruct.Mapper;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 11:40 AM
 **/
@Mapper(componentModel = "spring")
public interface LibraryConverter extends GeneralMapper<Library, LibraryDTO> {
}
