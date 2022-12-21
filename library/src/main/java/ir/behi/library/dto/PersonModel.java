package ir.behi.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:37 AM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {
    private int id;
    private String fullName;
    private int nationalCode;
}

