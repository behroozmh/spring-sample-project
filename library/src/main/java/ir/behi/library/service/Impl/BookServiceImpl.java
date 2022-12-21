package ir.behi.library.service.Impl;

import ir.behi.library.dao.BookRepo;
import ir.behi.library.dto.BookDTO;
import ir.behi.library.mapper.BookConverter;
import ir.behi.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/21/2022
 * TIME: 10:22 AM
 **/
@Service
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;
    private BookConverter converter;

    public BookServiceImpl(BookRepo bookRepo, BookConverter converter) {
        this.bookRepo = bookRepo;
        this.converter = converter;
    }

    public Boolean findNameExists(String bookName) {
        if (bookRepo.existsByNameEquals(bookName)) {
            return true;
        }
        return false;
    }

    @Override
    public BookDTO create(BookDTO model)  {
        if (!this.findNameExists(model.getName())) {
            return converter.ToDTO(bookRepo.save(converter.ToEntity(model)));
        } else
            throw new SecurityException("entity.not.found");
    }

    @Override
    public BookDTO update(BookDTO model) {
        return converter.ToDTO(bookRepo.save(converter.ToEntity(model)));
    }

    @Override
    public boolean delete(Integer id) {
        bookRepo.deleteById(id);
        return true;
    }

    @Override
    public BookDTO get(Integer id) {
        return converter.ToDTO(bookRepo.findById(id).get());
    }

    @Override
    public List<BookDTO> getAll() {
        return converter.ToDTOs(bookRepo.findAll());
    }
}
