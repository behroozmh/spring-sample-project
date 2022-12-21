package ir.behi.library.controller;

import ir.behi.library.dto.BorrowDTO;
import ir.behi.library.dto.PersonDTO;
import ir.behi.library.service.BorrowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 01:15 PM
 **/
@RestController
@RequestMapping(value = "/borrow")
public class BorrowController {

    private BorrowService service;

    public BorrowController(BorrowService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public ResponseEntity addPerson(@RequestBody BorrowDTO borrowDTO) throws Exception {
        return ResponseEntity.ok().body(service.create(borrowDTO));
    }

    @GetMapping(value = "/getAllByPerson")
    public ResponseEntity getAllByPerson(@RequestBody PersonDTO person) throws Exception {
        return ResponseEntity.ok(service.getAllBorrowByPersonId(person.getId()));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllBorrow() throws Exception {
        return ResponseEntity.ok(service.getAllBorrow());
    }

    @GetMapping(value = "/get")
    public ResponseEntity searchPerson(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(service.getAllBorrowByPersonId(id));
    }
}
