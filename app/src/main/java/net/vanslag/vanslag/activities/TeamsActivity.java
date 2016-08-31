package net.vanslag.vanslag.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import net.vanslag.vanslag.R;
import net.vanslag.vanslag.VanSlagApplication;
import net.vanslag.vanslag.models.Team;

import java.util.Arrays;
import java.util.List;

public class TeamsActivity extends Activity {

    private RequestQueue requestQueue;

    private String teamsUrl = "https://www.vanslag.net/teams.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        requestQueue = ((VanSlagApplication) getApplicationContext()).getQueue();

        fetchTeams();
    }

    private void fetchTeams() {
        StringRequest request = new StringRequest(Request.Method.GET, teamsUrl, onNewsLoaded, onNewsError);
        requestQueue.add(request);
    };


    private final Response.Listener<String> onNewsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            List<Team> teams = ((VanSlagApplication) getApplicationContext()).parseTeams(response);
            Log.d("Test", Arrays.toString(teams.toArray()));
        }
    };

    private final Response.ErrorListener onNewsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(), "Unable to load teams.", Toast.LENGTH_LONG).show();
        }
    };


}
