package com.example.narino.narinoDatos;

import com.example.narino.modelos.MunRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jhon on 1/06/2017.
 */

public interface NarinoapiService {

    @GET("v2gq-kc7t.json")
    Call<List<MunRespuesta>> obtenerListaMun();
}
