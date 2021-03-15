package com.bot.frontend.baseClass.service.Eulices;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerJson {
    public static void main(String[] args) {
     JSONParser parser = new JSONParser();

        try {
            String FILE_DATOS= System.getProperty("user.dir") + "/src/main/resources/usuario.json";
            Object obj = parser.parse(new FileReader(FILE_DATOS));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("JSON LEIDO: " + jsonObject);

            JSONArray array = (JSONArray) jsonObject.get("Usuarios");
            System.out.println("");

            for(int i = 0 ; i < array.size() ; i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);

                System.out.println("DATOS DEL USUARIO: " + i);
                System.out.println("ID: " + jsonObject1.get("id"));
                System.out.println("Nombre: " + jsonObject1.get("nombre"));
                System.out.println("Telefono: " + jsonObject1.get("telefono"));
                System.out.println("Email: " + jsonObject1.get("email"));

                System.out.println("");
            }

        } catch(FileNotFoundException e) { }
        catch(IOException e) { }
        catch(ParseException e) { }

/*
        JSONObject myObject = new JSONObject();

        // Cadenas de texto básicas
        myObject.put("name", "Carlos");
        myObject.put("last_name", "Carlos");

        // Valores primitivos
        myObject.put("age", new Integer(21));
        myObject.put("bank_account_balance", new Double(20.2));
        myObject.put("is_developer", new Boolean(true));

        // Matrices
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        myObject.put("number_list", myList);

        // Objeto dentro de objeto
        JSONObject subdata = new JSONObject();
        myObject.put("extra_data", subdata);

        // Generar cadena de texto JSON
        System.out.println(myObject);
*/


    }

}
