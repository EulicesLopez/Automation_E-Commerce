package com.bot.frontend.baseClass.service.Eulices;

public class ErrorCode {

    public static String validaCodigo(int codigo) throws Exception {
        String mensaje = "";
        if (codigo>=100 && codigo <=199){
            throw new Exception("Respuesta informativo");
        }
        else if (codigo>=200 && codigo <=299){
            if (codigo==200){
                mensaje="[LOG] La solicitud ha tenido éxito >"+codigo;}
            else if (codigo==201){
                mensaje="[LOG] La solicitud ha tenido éxito y se ha creado un nuevo recurso >"+codigo;}
            else if (codigo ==204){
                mensaje="[LOG] La solicitud se ha completado con éxito, pero su contenifo no se ha obtenido >"+codigo;}
            else if (codigo!=200 && codigo!=201 && codigo!=204){
                mensaje=" Respuesta satisfactoria ->Código:"+codigo;}
        }
        else if (codigo>=300 && codigo <=399){
            throw new Exception("Error de Redirección: "+codigo);
        }
        else if (codigo>=400 && codigo <=499){
            throw new Exception("Error del cliente: "+codigo);
        }
        else if (codigo>=500 && codigo <=599){
            throw new Exception(" Error del servidor: "+codigo);
        }
        return mensaje;
    }

    public static void main(String[] args) throws Exception {
        System.out.println( validaCodigo(350));
    }
}
