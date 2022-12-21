package ir.behi.library.service.Impl;

import ir.behi.library.dao.CategoryRepo;
import ir.behi.library.dto.CategoryDTO;
import ir.behi.library.mapper.CategoryConverter;
import ir.behi.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/21/2022
 * TIME: 10:22 AM
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo categoryRepo;
    private CategoryConverter converter;

    public CategoryServiceImpl(CategoryRepo categoryRepo, CategoryConverter converter) {
        this.categoryRepo = categoryRepo;
        this.converter = converter;
    }

    public Boolean findNameExists(String categoryName) {
        if (categoryRepo.existsByNameEquals(categoryName)) {
            return true;
        }
        return false;
    }

    @Override
    public CategoryDTO create(CategoryDTO model) throws Exception {
        if (!this.findNameExists(model.getName())) {
            return converter.ToDTO(categoryRepo.save(converter.ToEntity(model)));
        } else
            throw new Exception("This name exists");
    }


    @Override
    public CategoryDTO update(CategoryDTO model) {
        return converter.ToDTO(categoryRepo.save(converter.ToEntity(model)));
    }

    @Override
    public boolean delete(Integer id) {
        categoryRepo.deleteById(id);
        return true;
    }

    @Override
    public CategoryDTO get(Integer id) {
        return converter.ToDTO(categoryRepo.findById(id).get());
    }

    @Override
    public List<CategoryDTO> getAll() {
        return converter.ToDTOs(categoryRepo.findAll());
    }
}
