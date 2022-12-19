package ir.behi.phonebook.service.impl;

import ir.behi.phonebook.dao.CategoryDAO;
import ir.behi.phonebook.dto.CategoryDTO;
import ir.behi.phonebook.entity.Category;
import ir.behi.phonebook.exception.ServiceException;
import ir.behi.phonebook.mapper.CategoryMapper;
import ir.behi.phonebook.service.CategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    public CategoryServiceImpl(CategoryDAO categoryDAO, CategoryMapper categoryMapper) {
        this.dao = categoryDAO;
        this.mapper = categoryMapper;
    }

    private CategoryDAO dao;
    private CategoryMapper mapper;

    @Override
    public CategoryDTO insert(CategoryDTO model) {
        Category category = this.mapper.ToEntity(model);
        category = this.dao.save(category);
        CategoryDTO dto = this.mapper.ToDTO(category);
        return dto;
    }

    @Override
    public CategoryDTO update(CategoryDTO model) {
        return this.mapper.ToDTO(this.dao.save(mapper.ToEntity(model)));
    }

    @Override
    public void delete(Object id) throws ServiceException {
        if (id != null) {
            Optional<Category> category = this.dao.findById((Integer) id);
            if (category.isPresent())
                this.dao.delete(category.get());
            else throw new ServiceException("entity.not.found", "1500");
        } else throw new ServiceException("id.not.found", "1500");
    }

    @Override
    public CategoryDTO findById(Object id) throws ServiceException {
        Optional<Category> category = this.dao.findById((Integer) id);
        if (category.isPresent())
            return this.mapper.ToDTO(category.get());
        else throw new ServiceException("entity.not.found", "1500");
    }

    @Override
    public List<CategoryDTO> findAll(CategoryDTO model) {
        return mapper.ToDTOs((List) this.dao.findAll());
    }

    @Override
    public List<CategoryDTO> findByPaging(Pageable pageable) {
        return mapper.ToDTOs((List) this.dao.findAll(pageable));
    }
}
