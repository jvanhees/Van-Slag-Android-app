package net.vanslag.vanslag.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import net.vanslag.vanslag.R;
import net.vanslag.vanslag.VanSlagApplication;
import net.vanslag.vanslag.models.News;

import java.util.List;

public class SituationActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private String situationUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_situation);

        requestQueue = ((VanSlagApplication) getApplicationContext()).getQueue();
        String baseUrl = ((VanSlagApplication) getApplicationContext()).getBaseUrl();

        situationUrl = baseUrl + "news.json";

        fetchSituation();
    }

    public void fetchSituation() {
        StringRequest request = new StringRequest(Request.Method.GET, situationUrl, onSituationLoaded, onSituationError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onSituationLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            List<News> SituationItems = ((VanSlagApplication) getApplicationContext()).parseSituation(response);
        }
    };

    private final Response.ErrorListener onSituationError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(), "Unable to load situation.", Toast.LENGTH_LONG).show();
        }
    };
}
