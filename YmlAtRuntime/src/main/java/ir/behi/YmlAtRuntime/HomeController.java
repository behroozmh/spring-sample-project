package ir.behi.YmlAtRuntime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
    @GetMapping(value = "/getList")
    public ResponseEntity getYamlValues() {
        return ResponseEntity.ok(YamlUtils.getListYaml());
    }
}
