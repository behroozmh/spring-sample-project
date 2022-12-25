package ir.behi.library;

import ir.behi.library.dto.CategoryDTO;
import ir.behi.library.dto.PersonDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LibraryApplicationTests {
    @Value(value="${local.server.port}")
    private int port=8081;
    @Value(value="${server.servlet.context-path}")
    private String context="library";
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoadsTestWithRestTemplate() {
        List<CategoryDTO> lstCategory= this.restTemplate.getForObject("http://localhost:" + port +context+ "/category/getAll",
                List.class);
        Assert.notEmpty(lstCategory,"Category is Empty");

        List<PersonDTO> lstPerson= this.restTemplate.getForObject("http://localhost:" + port +context+ "/person/getAll",
                List.class);
        Assert.notEmpty(lstPerson,"Person is Empty");
    }



}
