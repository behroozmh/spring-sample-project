package ir.behi.oauth2.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private String nationalCode;
    private byte[] picture;
    private String description;
}
