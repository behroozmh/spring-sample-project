package ir.behi.library.service;

import ir.behi.library.dto.BookDTO;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 12:45 AM
 **/
public interface BookService {

    Boolean findNameExists(String bookName) throws Exception;

    BookDTO create(BookDTO model) throws Exception;

    BookDTO update(BookDTO model);

    boolean delete(Integer id);

    BookDTO get(Integer id);

    List<BookDTO> getAll();
}
