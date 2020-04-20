package com.priyanka.media_magic_task;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public GridView listView;
    public ArrayList<itemModel> arrayList;
    public SwipeRefreshLayout swipeRefresh;

    public JSONArray jArray;

    public itemModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (GridView) findViewById(R.id.listView);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);

        arrayList = new ArrayList<>();
        new fetchData().execute();
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new fetchData().execute();
            }
        });
    }

    public class fetchData extends AsyncTask<String, String, String> {

        @Override
        public void onPreExecute() {
            super .onPreExecute();
            swipeRefresh.setRefreshing(true);
        }

        @Override
        protected String doInBackground(String... params) {

            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall("https://picsum.photos/list");

            try {
                jArray=new JSONArray(jsonStr);

                for(int i=0;i<jArray.length();i++)
                {
                    JSONObject o=jArray.getJSONObject(i);

                    String id=o.getString("id");

                    String authorName=o.getString("author");

                    String imageurlstr="https://picsum.photos/300/300?image="+id;






                    Log.d("URL",imageurlstr);

                    model = new itemModel();
                    model.setName(authorName);
                    model.setId(id);
                    model.setUrl(imageurlstr);

                    arrayList.add(model);

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.d( "Response from url: ",  jsonStr);

            String result = null;

            return result;
        }

        @Override
        public void onPostExecute(String s) {
            super .onPostExecute(s);
            swipeRefresh.setRefreshing(false);

            CustomAdapter adapter = new CustomAdapter(MainActivity.this, arrayList);
            listView.setAdapter(adapter);

        }
    }
}