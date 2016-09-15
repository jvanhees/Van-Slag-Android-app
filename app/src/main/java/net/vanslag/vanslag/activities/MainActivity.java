package net.vanslag.vanslag.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import net.vanslag.vanslag.VanSlagApplication;
import net.vanslag.vanslag.models.News;
import net.vanslag.vanslag.adapters.NewsAdapter;
import net.vanslag.vanslag.R;

import java.io.UnsupportedEncodingException;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG_TITLE = "title";
    private static final String TAG_BODY = "body";

    private RequestQueue requestQueue;

    private String newsUrl;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = ((VanSlagApplication) getApplicationContext()).getQueue();
        String baseUrl =  ((VanSlagApplication) getApplicationContext()).getBaseUrl();

        newsUrl = baseUrl + "news.json";

        fetchNews();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void goToSituation(View view) {
        Intent intent = new Intent(this, SituationActivity.class);
        startActivity(intent);
    }

    public void goToTeams(View view) {
        Intent intent = new Intent(this, TeamsActivity.class);
        startActivity(intent);
    }

    public void fetchNews() {
        StringRequest request = new StringRequest(Request.Method.GET, newsUrl, onNewsLoaded, onNewsError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onNewsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            List<News> newsItems = ((VanSlagApplication) getApplicationContext()).parseNews(response);

            NewsAdapter adapter = new NewsAdapter(getApplicationContext(), newsItems);

            ListView listView = (ListView) findViewById(R.id.newsList);
            listView.setAdapter(adapter);

        }
    };

    private final Response.ErrorListener onNewsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("VOLLEY", error.toString());
            Toast.makeText(getApplicationContext(), "Unable to load news:" + error.toString(), Toast.LENGTH_LONG).show();
        }
    };


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://vanslag.net"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://net.vanslag.vanslag/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://net.vanslag.vanslag/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
