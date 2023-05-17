package fr.ekwateur.backend.particular.core.controller;

import fr.ekwateur.backend.invoice.core.service.InvoiceService;
import fr.ekwateur.backend.particular.core.service.ParticularService;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParticularControllerTest {

    private ParticularService particularService;
    private InvoiceService invoiceService;

    @Autowired
    private MockMvc mvc;

    private static JSONObject json;

    @BeforeAll
    void setUp() throws Exception {
        particularService = Mockito.mock(ParticularService.class);
        invoiceService = Mockito.mock(InvoiceService.class);
    }

    @AfterAll
    void tearDown() throws Exception {
        particularService = null;
        invoiceService = null;
        json = null;
    }

    @Test
    @Order(value = 0)
    public void testThatWeCanCreateParticular() throws Exception {
//        MvcResult result = this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .post("/api/particulars")
//                                .content("{"
//                                        + 	"\"firstname\": \"Philemon\","
//                                        + 	"\"lastname\": \"Globlehi\","
//                                        + 	"\"civility\": \"Monsieur\""
//                                        + "}"
//                                )
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.firstname").value("Philemon"))
//                .andExpect(jsonPath("$.lastname").value("Globlehi"))
//                .andExpect(jsonPath("$.civility").value("Monsieur"))
//                .andExpect(jsonPath("$.reference").exists())
//                .andReturn()
//                ;
//        json = new JSONObject(result.getResponse().getContentAsString());
    }

    @Test
    @Order(value = 1)
    public void testThatWeCanReadParticular() throws Exception {
//        this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/particulars/" + json.getInt("id"))
//                )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(json.getInt("id")))
//                .andExpect(jsonPath("$.firstname").value("Philemon"))
//                .andExpect(jsonPath("$.lastname").value("Globlehi"))
//                .andExpect(jsonPath("$.civility").value("Monsieur"))
//                .andExpect(jsonPath("$.reference").exists())
//        ;
    }

    @Test
    @Order(value = 2)
    public void testThatWeCanShowListParticular() throws Exception {
//        this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/particulars")
//                )
//                .andDo(print())
//                .andExpect(status().isOk())
//
//                .andExpect(jsonPath("$.[0].firstname").value("Philemon"))
//                .andExpect(jsonPath("$.[0].lastname").value("Globlehi"))
//                .andExpect(jsonPath("$.[0].civility").value("Monsieur"))
//                .andExpect(jsonPath("$.[0].reference").exists())
//        ;
    }

    @Test
    @Order(value = 3)
    public void testThatWeCanUpdateParticular() throws Exception {
//        this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .put("/api/particulars/" + json.getInt("id"))
//                                .content("{"
//                                        + 	"\"id\":" + json.getInt("id") + ","
//                                        + 	"\"firstname\": \"Yves\","
//                                        + 	"\"lastname\": \"Hermann\","
//                                        + 	"\"civility\": \"Monsieur\""
//                                        + "}"
//                                )
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstname").value("Yves"))
//                .andExpect(jsonPath("$.lastname").value("Hermann"))
//                .andExpect(jsonPath("$.civility").value("Monsieur"))
//        ;
    }

    @Test
    @Order(value = 4)
    public void testThatWeCanDeleteParticular() throws Exception {
//        this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .delete("/api/particulars/" + json.getInt("id"))
//                )
//                .andExpect(status().isNoContent());
    }
}
