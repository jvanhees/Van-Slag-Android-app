package net.vanslag.vanslag;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.vanslag.vanslag.models.News;
import net.vanslag.vanslag.models.Position;
import net.vanslag.vanslag.models.Team;

import java.util.Arrays;
import java.util.List;

public class VanSlagApplication extends Application {

    private Gson gson;
    private RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();

        queue = Volley.newRequestQueue(this);

        // Specify json date format
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz");
        gson = gsonBuilder.create();
    }

    public RequestQueue getQueue() {
        return queue;
    }

    public List parseNews(String inputString){
        return Arrays.asList(gson.fromJson(inputString, News[].class));
    }

    public List parseSituation(String inputString){
        return Arrays.asList(gson.fromJson(inputString, Position[].class));
    }

    public List parseTeams(String inputString){
        return Arrays.asList(gson.fromJson(inputString, Team[].class));
    }
}