package toto.pocSpring.planet.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import toto.pocSpring.planet.entity.Planet;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Classe de test pour le controller {@link PlanetController}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PlanetControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/planet/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").isNotEmpty());
    }

    @Test
    public void testGetById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/planet/2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2));
    }

    @Test
    public void testGetByIdNotFound() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/planet/2000")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testGetAllPlanetsName() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/planet/names")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").isString());
    }

    @Test
    public void testCreateNewPlanet() throws Exception {

        Planet newPlanet = new Planet();
        newPlanet.setName("This Is A Test");
        newPlanet.setPopulation(BigInteger.valueOf(100000));
        newPlanet.setTerrain("Water");

        mvc.perform(MockMvcRequestBuilders
                .post("/planet/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(newPlanet)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testDeletePlanet() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/planet/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * fonction privée pour sérialiser un objet
     */
    private byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
