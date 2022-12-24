package ir.behi.library.service.Impl;

import ir.behi.library.dao.BookRepo;
import ir.behi.library.dao.LibraryRepo;
import ir.behi.library.dto.BorrowDTO;
import ir.behi.library.dto.LibraryDTO;
import ir.behi.library.dto.PersonDTO;
import ir.behi.library.entity.Book;
import ir.behi.library.entity.Library;
import ir.behi.library.exception.ServiceException;
import ir.behi.library.mapper.LibraryConverter;
import ir.behi.library.mapper.PersonConverter;
import ir.behi.library.service.LibraryService;
import ir.behi.library.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    private PersonService personService;
    private PersonConverter personConverter;

    public LibraryServiceImpl(PersonService personService, LibraryRepo libraryRepo, BookRepo bookRepo,
                              LibraryConverter converter, PersonConverter personConverter) {
        this.personService = personService;
        this.libraryRepo = libraryRepo;
        this.bookRepo = bookRepo;
        this.converter = converter;
        this.personConverter = personConverter;
        this.bookRepo = bookRepo;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean loanable(Integer id) {
        Library libraryEntity = libraryRepo.get(id);
        if (libraryEntity.getIsBorrowAble() == true & libraryEntity.getExistNum() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public LibraryDTO create(LibraryDTO model) {
        Library entity = converter.ToEntity(model);
        Book book = bookRepo.findById(model.getBook().getId()).get();
        entity.setBook(book);
        return converter.ToDTO(libraryRepo.create(entity));
    }

    @Transactional
    @Override
    public LibraryDTO updateWithReceive(Integer id) {
        return converter.ToDTO(libraryRepo.updateReceive(id));
    }

    @Transactional
    @Override
    public LibraryDTO updateWithReturn(Integer id) throws ServiceException {
        Library library = libraryRepo.updateReturn(id);
        if (library == null)
            throw new ServiceException("book.is.not.available");
        else
            return converter.ToDTO(library);
    }

    /**
     * @param borrowDTO
     * @return
     * @throws ServiceException
     */
    @Transactional
    @Override
    public boolean lendingBooks(BorrowDTO borrowDTO) throws ServiceException {
        if (!this.loanable(borrowDTO.getBook().getId()))
            //بررسی قابل قرض دادن بودن کتاب
            throw new ServiceException("book.cannot.be.borrowed");
        else {
            //قرض دادن کتاب
            LibraryDTO libraryDTO = updateWithReceive(borrowDTO.getBook().getId());
            PersonDTO personDTO = personService.get(borrowDTO.getPerson().getId());
            borrowDTO.setBook(libraryDTO.getBook());
            borrowDTO.setPerson(personDTO);
            borrowDTO.setReceiveDate(new Date());
            borrowDTO.setRejectDate(new Date());
        }

        return true;
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
