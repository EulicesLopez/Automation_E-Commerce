package com.bot.frontend.baseClass.service.Eulices;

import com.bot.frontend.exceptions.ServiceException;

public class ValidaCodigoRespuesta {


    public static String validaCodigo(int codigo) throws ServiceException {
        String mensaje = "", tipoError = "";
        //  https://developer.mozilla.org/es/docs/Web/HTTP/Status   Codigos y descripcion

        if (codigo >= 100 && codigo <= 199) {
            tipoError = "Tipo Error: Respuestas informativas - Codigo: " + codigo;
        } else if (codigo >= 200 && codigo <= 299) {
            tipoError = "Tipo Error: Respuestas satisfactorias- Codigo: " + codigo;
            //throw new Exception(" Error del servidor->Código:"+codigo);
        } else if (codigo >= 300 && codigo <= 399) {
            tipoError = "Tipo Error: Redirecciones- Codigo: " + codigo;
        } else if (codigo >= 400 && codigo <= 499) {
            tipoError = "Tipo Error: Error de  cliente - Codigo: " + codigo;
        } else if (codigo >= 500 && codigo <= 599) {
            tipoError = "Tipo Error: Error de servidor- Codigo: " + codigo;
        }
        try {
        switch (codigo) {
            case 200:
                mensaje = "[Log] Codigo 200: OK-La solicitud ha tenido éxito ";
                break;
            case 201:
                mensaje = "[Log] Codigo 201: CREATED-La solicitud ha tenido éxito y se ha creado un nuevo recurso ";
                break;
            case 202:
                mensaje = "[Log] Codigo 202: ACCEPTED-La solicitud se ha recibido, pero aún no se ha actuado ";
                break;
            case 203:
                mensaje = "[Log] Codigo 203: NON AUTHORITATIVE INFORMATION-Contenido no se ha obtenido de la fuente originalmente solicitada ";
                break;
            case 204:
                mensaje = "[Log] Codigo 204: NO CONTENT-La respuesta no tiene ningún contenido ";
                break;
            default:
                mensaje = " " + tipoError;
                break;

        }
        //throw new ServiceException(mensaje)
    } catch (Throwable throwable) {
        if (codigo!=200) {
            throw new ServiceException("Servicio No Disponible: "+tipoError);
        }else{ throw new ServiceException( throwable);}
    }

        return mensaje;
    }


    public static void main(String[] args) throws ServiceException {
        System.out.println(validaCodigo(400));
    }

}
