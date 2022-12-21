package ir.behi.library.dao;

import ir.behi.library.entity.Library;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:50 AM
 **/
@Repository
public interface LibraryRepo {

    Library create(Library entity);
    boolean remove(Integer id);

    List<Library> isBorrowAble();

    List<Library> getAllLibrary();
    Library get(Integer id);

    Integer checkExistNum(Integer id);

    Library updateReceive(Library entity);

    Library updateReturn(Library entity);
}
