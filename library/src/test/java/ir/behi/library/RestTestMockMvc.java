package ir.behi.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * create User: behrooz.mh
 * Date: 12/25/2022
 * TIME: 11:00 AM
 **/
@WebMvcTest
public class RestTestMockMvc {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoadsTestWithMockMvc() throws Exception {
        this.mockMvc.perform(get("/person/getAll"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
