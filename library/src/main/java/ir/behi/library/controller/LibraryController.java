package ir.behi.library.controller;

import ir.behi.library.dto.BorrowDTO;
import ir.behi.library.dto.LibraryDTO;
import ir.behi.library.exception.ServiceException;
import ir.behi.library.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 01:05 PM
 **/
@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity addPerson(@RequestBody LibraryDTO model) throws ServiceException {
        return ResponseEntity.ok().body(libraryService.create(model));
    }

    @PutMapping(value = "/updateReceive/{id}")
    public ResponseEntity updateReceive(@PathVariable Integer id)  {
        return ResponseEntity.ok(libraryService.updateWithReceive(id));
    }

    @PutMapping(value = "/updateReturn/{id}")
    public ResponseEntity updateReturn(@PathVariable Integer id) throws ServiceException {
        return ResponseEntity.ok(libraryService.updateWithReturn(id));
    }

    @GetMapping(value = "/lendingBooks")
    public ResponseEntity lendingBooks(@RequestBody BorrowDTO borrowDTO) throws ServiceException {
        return ResponseEntity.ok(libraryService.lendingBooks(borrowDTO));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllLibrary()  {
        return ResponseEntity.ok().body(libraryService.getAll());
    }

    @GetMapping(value = "/checkExistNum/{id}")
    public ResponseEntity checkExistNum(@PathVariable Integer id) {
        return ResponseEntity.ok(libraryService.checkExistNum(id));
    }

}
