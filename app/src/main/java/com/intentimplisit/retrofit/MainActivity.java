package com.intentimplisit.retrofit;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    TextView textResult;
    Kontakapi kontakApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = (TextView) findViewById(R.id.text_result);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //MAKE RETROFIT OBJECT FOR BASE CONFIG OF RETROFIT

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Kontakapi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        kontakApi = retrofit.create(Kontakapi.class);

        Call<List<Kontak>> call = kontakApi.getAllContact();
        call.enqueue(new Callback<List<Kontak>>() {
            @Override
            public void onResponse(Call<List<Kontak>> call, Response<List<Kontak>> response) {
                if (!response.isSuccessful()){
                    textResult.setText("Code Response :"+response.code());
                    return;
                }
                List<Kontak> kontaks = response.body();
                for (Kontak kontak : kontaks) {
                    String content = "";
                    content += "ID: " + kontak.getId() + "\n";
                    content += "Nama: " + kontak.getName() + "\n";
                    content += "Email: " + kontak.getEmail() + "\n";
                    content += "No Phone: " + kontak.getNoHp() + "\n";
                    content += "Alamat: " + kontak.getAddr() + "\n\n";
                    textResult.append(content);
                    Log.i("Res :",content);
                }

                }


            @Override
            public void onFailure(Call<List<Kontak>> call, Throwable t) {
                Log.e("error : ",t.getMessage());
            }
        });
    }
}
