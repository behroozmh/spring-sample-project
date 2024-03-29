package ir.behi.yml_at_runtime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
    @GetMapping(value = "/getList")
    public ResponseEntity<List<ServiceModel>> getYamlValues() {
        List<ServiceModel> lst= YamlUtils.getListYaml();
        lst.get(0).getUrl();
        return ResponseEntity.ok(lst);
    }
}
