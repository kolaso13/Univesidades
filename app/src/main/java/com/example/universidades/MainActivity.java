package com.example.universidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

class Universidad{
    String nombre, pais, paginaWeb;


    public Universidad(String nombre, String paginaWeb, String pais) {
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.pais = pais;
    }
}
public class MainActivity extends AppCompatActivity {
    ArrayList<Universidad> Universidades = new ArrayList<Universidad>();

    ListView Lista;
    EditText pais, nombre;
    Button llamarAPI;
    Editable strPais,strNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llamarAPI= findViewById(R.id.llamarAPI);

        pais = findViewById(R.id.pais);
        nombre = findViewById(R.id.nombre);
        Lista = findViewById(R.id.Lista);
        llamarAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strPais =  pais.getText();
                strNombre = nombre.getText();
                LeerApi();
            }
        });
    }


    private void LeerApi() {
        String url = "http://universities.hipolabs.com/search?country="+strPais+"&name="+strNombre;

        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray json = new JSONArray(response);

                    for (int i = 0; i < json.length(); i++) {
                        JSONObject Object = json.getJSONObject(i);
                        Universidades.add(new Universidad(Object.getString("name"),Object.getString("domains"),Object.getString("country")));
                    }
                    for (Universidad Universi: Universidades){
                        Log.i("Val", Universi.nombre + " " + Universi.paginaWeb);
                    }

                    ArrayAdapter  adapter = new ArrayAdapter(MainActivity.this, R.layout.activity_main, Universidades);
                    Lista.setAdapter(adapter);

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