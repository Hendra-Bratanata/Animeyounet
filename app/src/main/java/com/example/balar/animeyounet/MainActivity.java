package com.example.balar.animeyounet;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String JSON_URL = "https://animeyou.net/api/home.php";
    /*ListView listView;

    private List<AnimeItem> animeItemList;*/
    private ProgressDialog dialog;


    @BindView(R.id.rv_category)
    RecyclerView rvAnime;
    AnimeAdapter adapter;

    final ArrayList<AnimeItem> animex = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        adapter = new AnimeAdapter(this);

        /*listView = findViewById(R.id.listView);
        animeItemList = new ArrayList<>();*/


        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.show();


        loadAnime();

    }

    private void loadAnime() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray animeArray = object.getJSONArray("data");

                    for (int i = 0; i < animeArray.length(); i++) {
                        JSONObject animeObject = animeArray.getJSONObject(i);

                        AnimeItem animeItem = new AnimeItem(
                                animeObject.getString("judul"),
                                animeObject.getString("gambar"),
                                animeObject.getString("tanggal"),
                                animeObject.getString("genre"),
                                animeObject.getString("video"),
                                animeObject.getString("video2"),
                                animeObject.getString("video3")
                        );
                        /*animeItemList.add(animeItem);*/
                        animex.add(animeItem);
                    }

                    /*AnimeAdapter adapter = new AnimeAdapter(animeItemList, getApplicationContext());
                    listView.setAdapter(adapter);
                    dialog.dismiss();*/

                    dialog.dismiss();
                    rvAnime.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapter.setAnimeItemList(animex);
                    rvAnime.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}


/*public class MainActivity extends AppCompatActivity {
    ListView listView;
    private ArrayList<AnimeItem> animeItemList;
    private AnimeAdapter adapter;
    private String JUDUL;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        animeItemList = new ArrayList<>();

        adapter = new AnimeAdapter(this);



        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.show();

    }



}*/





