package ir.behi.library.mapper;

import ir.behi.library.base.GeneralMapper;
import ir.behi.library.dto.BookDTO;
import ir.behi.library.entity.Book;
import org.mapstruct.Mapper;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 11:22 AM
 **/
@Mapper(componentModel = "spring")
public interface BookConverter extends GeneralMapper<Book, BookDTO> {
}
