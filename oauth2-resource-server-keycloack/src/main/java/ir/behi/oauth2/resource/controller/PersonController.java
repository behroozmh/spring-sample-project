package ir.behi.oauth2.resource.controller;

import ir.behi.oauth2.resource.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
