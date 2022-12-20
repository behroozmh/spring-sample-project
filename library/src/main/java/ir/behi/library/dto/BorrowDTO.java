package ir.behi.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:33 AM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDTO {
    private BookDTO book;
    private Date rejectDate;
    private PersonDTO person;
    private Date receiveDate;
}
