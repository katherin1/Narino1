package com.example.narino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.narino.modelos.Mun;
import com.example.narino.modelos.MunRespuesta;
import com.example.narino.narinoDatos.NarinoapiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Narino";
    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListaMunAdaptador listaMunAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaMunAdaptador = new ListaMunAdaptador(this);
        recyclerView.setAdapter(listaMunAdaptador);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();

    }

    private void obtenerDatos() {

        NarinoapiService service = retrofit.create(NarinoapiService.class);
        Call<List<MunRespuesta>> munRespuestaCall = service.obtenerListaMun();

        munRespuestaCall.enqueue(new Callback<List<MunRespuesta>>() {
            @Override
            public void onResponse(Call<List<MunRespuesta>> call, Response<List<MunRespuesta>> response) {
                if (response.isSuccessful()) {

                    List<MunRespuesta> munRespuesta = response.body();
                   // ArrayList<Mun> listaMun = munRespuesta.getResults();

                    listaMunAdaptador.agregarListaMun(munRespuesta);
                } else {
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<MunRespuesta>> call, Throwable t) {
                Log.e(TAG, " onResponse: " + t.getMessage());
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, Acerca.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
