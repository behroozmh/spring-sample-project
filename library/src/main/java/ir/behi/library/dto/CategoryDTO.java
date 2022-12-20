package ir.behi.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:30 AM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private int id;
    @NotNull(message = "NotNull.CategoryDTO.name")
    private String name;
}
