package ir.behi.library.service.Impl;

import ir.behi.library.dao.BookRepo;
import ir.behi.library.dao.LibraryRepo;
import ir.behi.library.dto.LibraryDTO;
import ir.behi.library.entity.Book;
import ir.behi.library.entity.Library;
import ir.behi.library.mapper.LibraryConverter;
import ir.behi.library.service.LibraryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/21/2022
 * TIME: 10:22 AM
 **/
@Service
public class LibraryServiceImpl implements LibraryService {

    private LibraryRepo libraryRepo;
    private LibraryConverter converter;
    private BookRepo bookRepo;

    public LibraryServiceImpl(LibraryRepo libraryRepo, LibraryConverter converter, BookRepo bookRepo) {
        this.libraryRepo = libraryRepo;
        this.converter = converter;
        this.bookRepo = bookRepo;
    }

    @Override
    public List<LibraryDTO> checkIsBorrowAble() {
        return converter.ToDTOs(libraryRepo.isBorrowAble());
    }

    @Transactional
    @Override
    public LibraryDTO create(LibraryDTO model) throws Exception {
        Library entity = converter.ToEntity(model);
        Book book = bookRepo.findById(model.getBook().getId()).get();
        entity.setBook(book);
        return converter.ToDTO(libraryRepo.create(entity));
    }

    @Transactional
    @Override
    public LibraryDTO updateWithReceive(LibraryDTO model) {
        Library entity = libraryRepo.updateReceive(converter.ToEntity(model));
        return converter.ToDTO(entity);
    }

    @Transactional
    @Override
    public LibraryDTO updateWithReturn(LibraryDTO model) {
        Library entity = libraryRepo.updateReturn(converter.ToEntity(model));
        return converter.ToDTO(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return libraryRepo.remove(id);
    }

    @Override
    public LibraryDTO get(Integer id) {
        return converter.ToDTO(libraryRepo.get(id));
    }

    @Override
    public List<LibraryDTO> getAll() {
        return converter.ToDTOs((List) libraryRepo.getAllLibrary());

    }

    @Override
    public Integer checkExistNum(Integer id) {
        return libraryRepo.checkExistNum(id);
    }
}
