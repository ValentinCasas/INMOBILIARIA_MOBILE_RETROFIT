package com.example.inmobiliaria_android_mobile.ui.inquilinos;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria_android_mobile.MainActivity;
import com.example.inmobiliaria_android_mobile.modelo.Inmueble;
import com.example.inmobiliaria_android_mobile.request.ApiClient;
import com.example.inmobiliaria_android_mobile.request.ApiClientRetrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InquilinosViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<ArrayList<Inmueble>> inmueblesAlquilados;

    public InquilinosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<ArrayList<Inmueble>> getInmueblesAlquilados() {
        if(inmueblesAlquilados == null){
            inmueblesAlquilados = new MutableLiveData<>();
        }
        return inmueblesAlquilados;
    }


    public void obtenerPropiedadesAlquiladas() {
        SharedPreferences sp = context.getSharedPreferences("token.xml", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");

        if (token.isEmpty()) {
            Intent intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
            return;
        }

        ApiClientRetrofit.EndPointInmobiliaria end = ApiClientRetrofit.getEndPointInmobiliaria();
        Call<ArrayList<Inmueble>> call = end.obtnerPropiedadesAlquiladas(token);

        call.enqueue(new Callback<ArrayList<Inmueble>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Inmueble>> call, @NonNull Response<ArrayList<Inmueble>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        inmueblesAlquilados.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Inmueble>> call, @NonNull Throwable t) {
                Toast.makeText(context, "Error al obtener propiedades alquiladas", Toast.LENGTH_SHORT).show();
            }
        });
    }

}