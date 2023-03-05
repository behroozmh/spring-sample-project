package ir.behi.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/")
    public ResponseEntity getRoot() {
        return ResponseEntity.ok("You are in me Root");
    }

    @GetMapping(value = "/hello")
    public ResponseEntity getHello() {
        return ResponseEntity.ok("Hello you");
    }
}
