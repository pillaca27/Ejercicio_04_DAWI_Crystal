package com.cibertec.simulacro_pc03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.cibertec.simulacro_pc03.adapter.RevistaAdapter;
import com.cibertec.simulacro_pc03.api.ServiceRevistaApi;
import com.cibertec.simulacro_pc03.entity.Revista;
import com.cibertec.simulacro_pc03.util.ConnectionRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RevistaListaActivity extends AppCompatActivity {

    List<Revista> lstData = new ArrayList<Revista>();
    RevistaAdapter adaptador = null;
    ListView lstView = null;
    ServiceRevistaApi api = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revista_lista);

        lstView = findViewById(R.id.idCrudRevistaList);

        adaptador= new RevistaAdapter(this, R.layout.activity_revista_item, lstData);
        lstView.setAdapter(adaptador);

        api = ConnectionRest.getConnection().create(ServiceRevistaApi.class);

        lista();
    }

    public void lista(){
        mensaje("LOG -> En método lista 1");

        Call<List<Revista>> call = api.listaRevista();
        call.enqueue(new Callback<List<Revista>>() {
            @Override
            public void onResponse(Call<List<Revista>> call, Response<List<Revista>> response) {
                mensaje("LOG -> En método lista 2");
                if(response.isSuccessful()){
                    mensaje("LOG -> En método lista 3");

                    List<Revista> lista = response.body();
                    mensaje("LOG -> size: " + lista.size());

                    lstData.clear();
                    lstData.addAll(lista);
                    adaptador.notifyDataSetChanged();
                }else{
                    mensaje("Error -> " + "Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<List<Revista>> call, Throwable t) {
                mensaje("ERROR -> " + "Error en la respuesta");
            }
        });
    }

    void mensaje(String msg){
        Toast toast1 = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        toast1.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.idMenuRevista){
            Intent intent = new Intent(this,RevistaListaActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.idMenuAlumno){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}