package ir.behi.oauth2.resource.controller;

import ir.behi.oauth2.resource.dto.PersonDTO;
import ir.behi.oauth2.resource.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return ResponseEntity.ok(personService.get(id));
    }

    @GetMapping(value = "/getList")
    public ResponseEntity getList() {
        return ResponseEntity.ok(personService.getList());
    }

    @PostMapping(value = "/update")
    public ResponseEntity update(@RequestBody PersonDTO dto) {
        return ResponseEntity.ok(personService.update(dto));
    }
}
