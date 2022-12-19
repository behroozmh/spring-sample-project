package ir.behi.phonebook.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PersonDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    @Size(min = 11,max = 11,message = "Size.PersonDTO.mobile")
    private String mobile;
    private String picture;
    @NotNull(message = "NotNull.PersonDTO.category")
    private CategoryDTO category;
}
