package ir.behi.library.mapper;

import ir.behi.library.base.GeneralMapper;
import ir.behi.library.dto.CategoryDTO;
import ir.behi.library.entity.Category;
import org.mapstruct.Mapper;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 11:30 AM
 **/
@Mapper(componentModel = "spring")
public interface CategoryConverter extends GeneralMapper<Category, CategoryDTO> {
}
