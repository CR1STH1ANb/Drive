package com.example.drive.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class mensaje {
    public String nombre;
    public String url;
    public String img2;

    public String getImg2() {
        return img2;
    }

    public String getNombre() {

        return nombre;
    }


    public String getUrl() {

        return url;
    }

    public mensaje(JSONObject a) throws JSONException {
        this.nombre = a.getString("nombre").toString();
        this.img2 = a.getString("imagen2").toString();
        this.url = a.getString("imagen").toString();
    }
    //Metodo para parsear los datos
    public static ArrayList<mensaje> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<mensaje> mensaje = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            mensaje.add(new mensaje(datos.getJSONObject(i)));
        }
        return mensaje;
    }

}
