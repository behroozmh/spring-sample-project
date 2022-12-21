package ir.behi.library.service;

import ir.behi.library.dto.LibraryDTO;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 12:30 AM
 **/
public interface LibraryService {

    List<LibraryDTO> checkIsBorrowAble() throws Exception;

    LibraryDTO create(LibraryDTO model) throws Exception;

    LibraryDTO updateWithReceive(LibraryDTO model);

    LibraryDTO updateWithReturn(LibraryDTO model);

    boolean delete(Integer id);

    LibraryDTO get(Integer id);

    List<LibraryDTO> getAll();

    Integer checkExistNum(Integer id);
}
