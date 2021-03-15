package com.bot.frontend.baseClass.service.Eulices;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class TesTJson {
//fuente https://www.adictosaltrabajo.com/2012/09/17/gson-java-json/

    @Test
        public void debeDevolverJSONEnUnProperties() {
            final String json = "{\"id\":46,\"nombre\":\"Miguel\",\"empresa\":\"Autentia\"}";
            final Gson gson = new Gson();
            final Properties properties = gson.fromJson(json, Properties.class);
            assertEquals("46", properties.getProperty("id"));
            assertEquals("Miguel", properties.getProperty("nombre"));
            assertEquals("Autentia", properties.getProperty("empresa"));
            assertNull(properties.getProperty("propiedadInexistente"));
    }



}
