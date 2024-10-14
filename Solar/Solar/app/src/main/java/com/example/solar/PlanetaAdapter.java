package com.example.solar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;
public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    Context mContext;
    int mResourceXML;
    List<Planeta> planetas;
    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects)
        {
        super(context, resource, objects);
        mContext=context;
        mResourceXML=resource;
        planetas=objects;

    }

    @Override
    public View getView(int position, @NonNull View converView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View v = layoutInflater.inflate(mResourceXML, parent, false);
        TextView tvnomeplaneta = v.findViewById(R.id.nome);
        ImageView imageView = v.findViewById(R.id.imageView);
        Planeta planeta = planetas.get(position);
        tvnomeplaneta.setText(planeta.nome);
        imageView.setImageResource(planeta.image);

        return v;
    }
}

