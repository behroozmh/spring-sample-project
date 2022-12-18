package ir.behi.phonebook.mapper;

import ir.behi.phonebook.dto.CategoryDTO;
import ir.behi.phonebook.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends GeneralMapper<Category, CategoryDTO> {
}
