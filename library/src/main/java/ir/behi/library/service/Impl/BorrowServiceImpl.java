package ir.behi.library.service.Impl;

import ir.behi.library.dao.BookRepo;
import ir.behi.library.dao.BorrowRepo;
import ir.behi.library.dao.PersonRepo;
import ir.behi.library.dto.BorrowDTO;
import ir.behi.library.entity.Borrow;
import ir.behi.library.mapper.BorrowConverter;
import ir.behi.library.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/21/2022
 * TIME: 10:22 AM
 **/
@Service
public class BorrowServiceImpl implements BorrowService {
    private BorrowRepo borrowRepo;
    private BorrowConverter converter;
    private PersonRepo personRepo;
    private BookRepo bookRepo;

    public BorrowServiceImpl(BorrowRepo borrowRepo, BorrowConverter converter, PersonRepo personRepo, BookRepo bookRepo) {
        this.borrowRepo = borrowRepo;
        this.converter = converter;
        this.personRepo = personRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public Boolean findNameExists(String categoryName) throws Exception {
        return null;
    }

    @Transactional
    @Override
    public BorrowDTO create(BorrowDTO model) throws Exception {
        Borrow entity = converter.ToEntity(model);
        entity.setPerson(personRepo.get(model.getPerson().getId()));
        entity.setBook(bookRepo.getById(model.getBook().getId()));
        return converter.ToDTO(borrowRepo.create(entity));
    }

    @Override
    public BorrowDTO update(BorrowDTO model) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        borrowRepo.remove(id);
        return true;
    }

    @Override
    public List<BorrowDTO> getAllBorrowByPersonId(Integer personId) {
        List<Borrow> entities = borrowRepo.getAllBorrowByPersonId(personId);
        return converter.ToDTOs(entities);

    }

    @Override
    public List<BorrowDTO> getAllBorrow() {
        return converter.ToDTOs((List) borrowRepo.getAllBorrow());

    }
}
