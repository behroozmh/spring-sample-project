package ir.behi.phonebook.service.impl;

import ir.behi.phonebook.dao.AddressDAO;
import ir.behi.phonebook.dto.AddressDTO;
import ir.behi.phonebook.entity.Address;
import ir.behi.phonebook.exception.ServiceException;
import ir.behi.phonebook.mapper.AddressMapper;
import ir.behi.phonebook.service.AddressService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * create User: behrooz.mh
 * Date: 12/19/2022
 * TIME: 9:55 AM
 **/
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    private AddressDAO dao;
    private AddressMapper mapper;

    public AddressServiceImpl(AddressDAO dao, AddressMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public AddressDTO insert(AddressDTO model) {
        return this.mapper.ToDTO(this.dao.save(mapper.ToEntity(model)));
    }

    @Override
    public AddressDTO update(AddressDTO model) {
        return this.mapper.ToDTO(this.dao.save(mapper.ToEntity(model)));
    }

    @Override
    public boolean delete(Object id) throws ServiceException {
        if (id != null) {
            Optional<Address> entity = this.dao.findById((Integer) id);
            if (entity.isPresent())
                this.dao.delete(entity.get());
            else throw new ServiceException("address.not.found", "1500");
        } else throw new ServiceException("id.not.found", "1500");
        return true;
    }

    @Override
    public AddressDTO findById(Object id) throws ServiceException {
        Optional<Address> entity = this.dao.findById((Integer) id);
        if (entity.isPresent())
            return this.mapper.ToDTO(entity.get());
        else throw new ServiceException("address.not.found", "1500");
    }

    @Override
    public List<AddressDTO> findAll() {
        return mapper.ToDTOs((List) this.dao.findAll());
    }

    @Override
    public List<AddressDTO> findAllByPaging(Pageable pageable) {
        return mapper.ToDTOs((List) this.dao.findAll(pageable));
    }
}
