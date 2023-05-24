package com.example.inmobiliaria_android_mobile.request;

import com.example.inmobiliaria_android_mobile.modelo.Propietario;
import com.example.inmobiliaria_android_mobile.modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public class ApiClientRetrofit {

    private static final String PATH = "http://192.168.0.102:5250/api/";
    private static EndPointInmobiliaria endPointInmobiliaria;

    public static EndPointInmobiliaria getEndPointInmobiliaria() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        endPointInmobiliaria = retrofit.create(EndPointInmobiliaria.class);

        return endPointInmobiliaria;
    }


    public interface EndPointInmobiliaria {

        //login propietario
        @POST("Propietario/loginn")
        Call<String> login(@Body Usuario usuario);

        //perfil del propietario
        @GET("Propietario/data")
        Call<Propietario> obtenerPerfil(@Header("Authorization") String token);



    }


}