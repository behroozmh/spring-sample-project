package ir.behi.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:35 AM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDTO {
    private Integer id;
    private Integer number;
    private Integer existNum;
    private Boolean isBorrowAble;
    private BookDTO book;
}
