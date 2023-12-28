package com.mygorithmtest.myvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    static RequestQueue requestQueue;

    RecyclerView recyclerView;
    UserAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.textView);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlStr = editText.getText().toString();
                request(urlStr);
            }
        });

        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public void request(String urlStr) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                urlStr,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("응답 ->" + response);

                        processResponse(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러 ->" + error.toString());

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
        println("요청보냄");
    }

    public void println(String data){
        textView.append(data +"\n");
    }

    public void processResponse(String response) {
        Gson gson = new Gson();
        ArrayList<UserList> arrayList = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(response);
            Log.d("find","third");
            int index= 0;
            while (index < jsonArray.length()) {
                UserList userList = gson.fromJson(jsonArray.get(index).toString(), UserList.class);
                arrayList.add(userList);

                index++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            println("에러난건가..");
        }
        int outputdex = 0;
        while (outputdex<arrayList.size()) {
            println("변환 후 \n"+ arrayList.get(outputdex).id);
            outputdex++;
        }
        for (int i =0; i <arrayList.size(); i++) {
            UserList userList2 = arrayList.get(i);
            adapter.addItem(userList2);
        }
        adapter.notifyDataSetChanged();





//        println("변환 후 : "+ userList.userLists.get(1));
//        println("변환 후 : "+ userList.userLists.get(2));

    }
}