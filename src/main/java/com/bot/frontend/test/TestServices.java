package com.bot.frontend.test;


import com.google.gson.Gson;
import com.bot.frontend.baseClass.service.Eulices.ErrorCode;
import com.bot.frontend.baseClass.service.Eulices.ValidaCodigoRespuesta;
import com.bot.frontend.utility.services.DataService;
import com.bot.frontend.utility.services.HeaderConfigurations;
import com.bot.frontend.utility.services.Service;
import com.bot.frontend.utility.services.handleResponse.HandleXml;
import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class TestServices {
    String url;
    File requestFile;
    HeaderConfigurations headerConfigurations;
    HttpResponse response;

    private final String FILE_REQUEST_CALCULATOR = System.getProperty("user.dir") + "/src/main/resources/services/body_request/request-soap.XML";
    private final String FILE_REQUEST_MOVISTAR_TOKEN = System.getProperty("user.dir") + "/src/main/resources/services/body_request/enter.x-www-form-urlencoded";

    @Test
    public void file() throws Throwable {
        FileReader rfile = new FileReader(new File(FILE_REQUEST_CALCULATOR));
        String s = new BufferedReader(rfile).lines().map(e -> e.toString()).reduce("", String::concat);
//        for (Map.Entry<String, String> dato : datos.entrySet()) {
//            s.replaceAll("\\$\\{" +key+"}", value);
//        }
        InputStream dd = new ByteArrayInputStream(s.getBytes());
        new FileInputStream(s);
        System.out.println(s);
//        new BufferedReader(rfile).lines().forEach(System.out::println);
    }


    @Test
    public void generateToken() throws Throwable {
        url = "//graph.instagram.com/access_token";
        requestFile = new File(FILE_REQUEST_MOVISTAR_TOKEN);
        headerConfigurations = new HeaderConfigurations();
        headerConfigurations.setHeader("Content-type", "application/x-www-form-urlencoded");
        Map<String, String> dataInput = new HashMap<String, String>();
        Service service = new Service("POST", new DataService(url, headerConfigurations, requestFile, dataInput));
        response = service.create().build();
    }


    @Test
    public void getIntragram() throws Throwable {
        url = "https://api.instagram.com/v1/users/search?q=123&count=2";
        headerConfigurations = new HeaderConfigurations();
        headerConfigurations.setHeader("Cookie", "csrftoken=K6QA8WwgauZxb8nOusfEVJwjmOmrXo9g; ig_did=E2B22B9C-576E-4F54-93A9-C60546663C9B; ig_nrcb=1; mid=YE7hnQAEAAHrUuPplxls54mv_3_J");
        Service service = new Service("GET", new DataService(url, headerConfigurations));
        response = service.create().build();

        int codigo = response.getStatusLine().getStatusCode();
        assertEquals(200, codigo);
        System.out.println(ValidaCodigoRespuesta.validaCodigo(codigo));
    }






}
