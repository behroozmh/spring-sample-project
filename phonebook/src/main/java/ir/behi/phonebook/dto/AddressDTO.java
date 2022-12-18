package ir.behi.phonebook.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Integer id;
    private String phone;
    private String address;
    private PersonDTO person;
}
