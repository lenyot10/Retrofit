package com.intentimplisit.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Kontakapi {
    String BASE_URL = "http://210.210.154.65/api/";
    @GET("kontak")
    Call<List<Kontak>> getAllContact();

    //@GET("Kontak/(id)")
   // Call<List<Kontak>>getContact(@Path("id")int contactId);

   // @POST
   // Call<Kontak>saveContact();
}
