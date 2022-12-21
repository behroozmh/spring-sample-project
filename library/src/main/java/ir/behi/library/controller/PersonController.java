package ir.behi.library.controller;

import ir.behi.library.dto.PersonDTO;
import ir.behi.library.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 01:12 PM
 **/
@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity addPerson(@RequestBody @Valid PersonDTO person) throws Exception {
        return ResponseEntity.ok().body(personService.create(person));
    }

    @GetMapping(value = "/getByNationalCode/{code}")
    public ResponseEntity person(@PathVariable String code) throws Exception {
        return ResponseEntity.ok(personService.findByNationalCode(code));
    }

    @GetMapping(value = "/get")
    public ResponseEntity person(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(personService.get(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity people() throws Exception {
        return ResponseEntity.ok(personService.getAll());
    }

    @PutMapping(value = "/update")
    public ResponseEntity updatePerson(@RequestBody PersonDTO person) throws Exception {
        return ResponseEntity.ok(personService.update(person));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deletePerson(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(personService.delete(id));
    }
}
