package ir.behi.session_with_redis.controller;

import ir.behi.session_with_redis.dto.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    private HttpSession httpSession;

    public PersonController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @GetMapping(value = "/get")
    public ResponseEntity getPerson() {
        PersonDTO person = new PersonDTO();
        Object obj = httpSession.getAttribute("person");
        if (obj != null)
            person = (PersonDTO) obj;
        return ResponseEntity.ok().body(person);
    }

    @PostMapping(value = "/create")
    public ResponseEntity createPerson(@RequestBody PersonDTO person) {
        if (person == null) {
            person = new PersonDTO();
            person.setFirstName("ali");
            person.setLastName("aliZadeh");
            person.setBirthDate(new Date());
            person.setNationalCode(UUID.randomUUID().toString());
        }
        httpSession.setAttribute("person", person);
        return ResponseEntity.ok().body(person);
    }
}
