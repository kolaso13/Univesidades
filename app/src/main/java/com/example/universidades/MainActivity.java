package com.example.universidades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ListView Lista;
    EditText pais, nombre;
    Button llamarAPI,atras;
    String strPais,strNombre;
    ScrollView sv;
    ArrayAdapter<String> mAdapter;
    static List<Universidad> universidades = new ArrayList<Universidad>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llamarAPI= findViewById(R.id.llamarAPI);

        atras = findViewById(R.id.atras);
        pais = findViewById(R.id.pais);
        nombre = findViewById(R.id.nombre);
        sv = findViewById(R.id.scrollV);
        sv.setVisibility(View.INVISIBLE);



        llamarAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeerApi();

                ItemFragment universidadFragment = new ItemFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .detach(universidadFragment)
                        .commit();

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragmentContainerView,universidadFragment)
                        .commit();

                sv.setVisibility(View.VISIBLE);
            }
        });



    }
    private void LeerApi() {
        strPais =  String.valueOf(pais.getText());
        strNombre = String.valueOf(nombre.getText());

        String url = "http://universities.hipolabs.com/search?country="+strPais+"&name="+strNombre;
        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject Object = json.getJSONObject(i);
                        Universidad universidad = new Universidad(Object.getString("name"),Object.getString("domains"),Object.getString("country"));
                        universidades.add(universidad);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
    }

}