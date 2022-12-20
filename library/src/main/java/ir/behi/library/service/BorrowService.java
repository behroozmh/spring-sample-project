package ir.behi.library.service;

import ir.behi.library.dto.BorrowDTO;
import ir.behi.library.dto.PersonDTO;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 12:40 AM
 **/
public interface BorrowService {


    Boolean findNameExists(String categoryName) throws Exception;

    BorrowDTO create(BorrowDTO model) throws Exception;

    BorrowDTO update(BorrowDTO model);

    boolean delete(Integer id);

    BorrowDTO personGetBorrow(Integer id);

    List<BorrowDTO> getAllBorrowPerson(PersonDTO person);

    List<BorrowDTO> getAllBorrow();
}
