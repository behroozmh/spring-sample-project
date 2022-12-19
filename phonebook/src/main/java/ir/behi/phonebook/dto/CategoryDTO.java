package ir.behi.phonebook.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO {
    private Integer id;
    @NotNull(message = "NotNull.CategoryDTO.name")
    @NotEmpty(message = "NotEmpty.CategoryDTO.name")
    private String name;
}
