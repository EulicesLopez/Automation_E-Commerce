package com.bot.frontend.baseClass.service.Eulices;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class LeerdatosJson {
    public static void main(String[] args) throws FileNotFoundException {
      JsonParser parser = new JsonParser();
         String FILE_DATOS= System.getProperty("user.dir") + "/src/main/resources/services/body_request/json/datos.json";
        FileReader fr = new FileReader(FILE_DATOS);
        JsonElement datos = parser.parse(fr);

        long inicioDate = System.currentTimeMillis();
        long startTime = System.nanoTime();
        analizeJsonElement(datos);
        long endTime = System.nanoTime();
        long finDate = System.currentTimeMillis();
        System.out.println("[LOG] Tiempo de respuesta: "+((finDate -inicioDate)/1000.0)+" segs");
        System.out.println("Duración Nanosegundos: " + (endTime-startTime) + " ns");//1e6

       /*Gson gson = new Gson();
        MiObjeto obj = new MiObjeto("Juan", "Madrid", null);
        String jsonString = gson.toJson(obj);
        System.out.println("JSON: " + jsonString);*/


    }

    public static void analizeJsonElement(JsonElement elemento) {
        int cont=1;
        if (elemento.isJsonObject()) {
            System.out.println("\n Es objeto ");
            JsonObject obj = elemento.getAsJsonObject();
         Set<Map.Entry<String, JsonElement>> entradas = obj.entrySet();
            Iterator<Map.Entry<String, JsonElement>> iter = entradas.iterator();
            while (iter.hasNext()) {
                Map.Entry<String, JsonElement> entrada = iter.next();
                System.out.println("Clave: " + entrada.getKey());
               // System.out.println("Valor:");
                analizeJsonElement(entrada.getValue());

            }

        } else if (elemento.isJsonArray()) {
            JsonArray array = elemento.getAsJsonArray();
            System.out.println("Es array. Numero de elementos: " + array.size());

           Iterator<JsonElement> iter = array.iterator();
            while (iter.hasNext()) {
                JsonElement entrada = iter.next();
                cont++;
                analizeJsonElement(entrada);
            }
        } else if (elemento.isJsonPrimitive()) {
            //System.out.println("Es primitiva");
            JsonPrimitive valor = elemento.getAsJsonPrimitive();
            if (valor.isBoolean()) {
                System.out.println("Valor booleano: " + valor.getAsBoolean());
            } else if (valor.isNumber()) {
                System.out.println("Valor numero: " + valor.getAsNumber());
            } else if (valor.isString()) {
                System.out.println("Valor texto: " + valor.getAsString());
            }
        } else if (elemento.isJsonNull()) {
            System.out.println("Es NULL");
        } else {
            System.out.println("Es otra cosa");
        }
    }


    static class MiObjeto {
        private String nombre;
        private String origen;
        String miCadena;
        Collection miColeccion = new ArrayList();
        Vector miVector;
        private MiObjeto(String nombre, String origen, String cadena) {
            this.nombre = nombre;
            this.origen = origen;
            this.miCadena = cadena;
            miColeccion.add("adios");
            miColeccion.add(10);
            miVector = new Vector();
            miVector.add("Elemento1");
            miVector.add(null);
            miVector.add("Elemento3");
            miVector.add("Elemento4");
        }
    }



}
