package ir.behi.phonebook.dto;

import lombok.Data;

@Data
public class PersonDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String picture;
    private CategoryDTO category;
}
