package ir.behi.phonebook.controller;

import ir.behi.phonebook.dto.CategoryDTO;
import ir.behi.phonebook.dto.PersonDTO;
import ir.behi.phonebook.exception.ServiceException;
import ir.behi.phonebook.service.PersonService;
import ir.behi.phonebook.service.PersonService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * create User: behrooz.mh
 * Date: 12/19/2022
 * TIME: 10:16 AM
 **/
@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Integer id) throws ServiceException {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/getAllByPaging")
    public ResponseEntity getAllByPaging(@RequestParam Pageable pageable) {
        return ResponseEntity.ok(personService.findAllByPaging((pageable)));
    }

    @GetMapping("/getById")
    public ResponseEntity getById(@RequestParam Integer id) throws ServiceException {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PersonDTO person) {
        return ResponseEntity.ok(personService.insert(person));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody PersonDTO person) {
        return ResponseEntity.ok(personService.update(person));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) throws ServiceException {
        return ResponseEntity.ok(personService.delete(id));
    }
}
