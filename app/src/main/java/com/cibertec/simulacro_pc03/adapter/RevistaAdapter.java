package com.cibertec.simulacro_pc03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cibertec.simulacro_pc03.R;
import com.cibertec.simulacro_pc03.entity.Revista;

import java.util.List;

public class RevistaAdapter extends ArrayAdapter<Revista> {

    private List<Revista> lista;
    private Context context;

    public RevistaAdapter(@NonNull Context context, int resource, @NonNull List<Revista> lista) {
        super(context, resource, lista);
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.activity_revista_item, parent, false);

        Revista objRevista = lista.get(position);

        TextView txtNombre = (TextView) row.findViewById(R.id.idItemCrudRevistaNombre);
        txtNombre.setText(objRevista.getNombre());

        return row;
    }
}
