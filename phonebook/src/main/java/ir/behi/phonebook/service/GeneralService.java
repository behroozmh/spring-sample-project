package ir.behi.phonebook.service;

import ir.behi.phonebook.exception.ServiceException;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/19/2022
 * TIME: 9:47 AM
 **/
public interface GeneralService<M> {
    M insert(M model);
    M update(M model);
    void delete(Object id) throws ServiceException;
    M findById(Object id) throws ServiceException;
    List<M> findAll(M model);
    List<M> findByPaging(Pageable pageable);
}
