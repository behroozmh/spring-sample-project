package ir.behi.library.service;

import ir.behi.library.dto.CategoryDTO;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 12:35 AM
 **/
public interface CategoryService {

    Boolean findNameExists(String categoryName) throws Exception;

    CategoryDTO create(CategoryDTO dto) throws Exception;

    CategoryDTO update(CategoryDTO dto);

    boolean delete(Integer id);

    CategoryDTO get(Integer id);

    List<CategoryDTO> getAll();
}
