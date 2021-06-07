package com.cibertec.simulacro_pc03.api;

import com.cibertec.simulacro_pc03.entity.Revista;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceRevistaApi {

    @GET("revista")
    public abstract Call<List<Revista>> listaRevista();

    @GET("revista/{id}")
    public abstract Call<Optional<Revista>> buscarRevista(@Path(value = "id") String id);

    @POST("revista")
    public abstract Call<Revista> insertaRevistar(@Body Revista obj);

    @PUT("revista")
    public abstract Call<Revista> actualizaRevistar(@Body Revista obj);

    @DELETE("revista/{id}")
    public abstract Call<Revista>  eliminaRevistaPorId(@Path(value = "id") String id);


}
