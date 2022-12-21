package ir.behi.library.mapper;

import ir.behi.library.base.GeneralMapper;
import ir.behi.library.dto.BorrowDTO;
import ir.behi.library.entity.Borrow;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 11:25 AM
 **/
@Mapper(componentModel = "spring")
public interface BorrowConverter extends GeneralMapper<Borrow, BorrowDTO> {
}
