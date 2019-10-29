package com.wordpress.techbeatsweb.inern;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DELL on 12-Oct-19.
 */
public interface APIService {

    @GET("heroes.php")
    Call<Heroes> getHeroes();
}