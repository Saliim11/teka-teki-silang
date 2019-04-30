package com.saliim.tekatekisilang;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.saliim.tekatekisilang.model.GetTts;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class API {

    static Retrofit retrofit;
    public static String baseURL = "http://192.168.18.84/";

    public static Retrofit getInstance() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build();

            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL + "t2_silang/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }

    public static Call<ArrayList<GetTts>> getTJMendatar() {
        MasterTTS service = getInstance().create(MasterTTS.class);
        return service.getTJMendatar();
    }

    public static Call<ArrayList<GetTts>> getTJMenurun() {
        MasterTTS service = getInstance().create(MasterTTS.class);
        return service.getTJMenurun();
    }

    public interface MasterTTS {

        @GET("get_tts_mendatar.php")
        Call<ArrayList<GetTts>> getTJMendatar();

        @GET("get_tts_menurun.php")
        Call<ArrayList<GetTts>> getTJMenurun();

    }
}
