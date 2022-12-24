package ir.behi.library.service;

import ir.behi.library.dto.BorrowDTO;
import ir.behi.library.dto.LibraryDTO;
import ir.behi.library.exception.ServiceException;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 12:30 AM
 **/
public interface LibraryService {
    boolean loanable(Integer id);

    LibraryDTO create(LibraryDTO model) throws ServiceException;

    LibraryDTO updateWithReceive(Integer id);

    LibraryDTO updateWithReturn(Integer id) throws ServiceException;

    boolean lendingBooks(BorrowDTO borrowDTO) throws ServiceException;

    boolean delete(Integer id);

    LibraryDTO get(Integer id);

    List<LibraryDTO> getAll();

    Integer checkExistNum(Integer id);
}
