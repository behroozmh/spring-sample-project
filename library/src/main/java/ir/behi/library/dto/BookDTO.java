package ir.behi.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:32 AM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private int id;
    private String name;
    private int isbn;
    private Date printDate;
    private CategoryDTO category;
}
