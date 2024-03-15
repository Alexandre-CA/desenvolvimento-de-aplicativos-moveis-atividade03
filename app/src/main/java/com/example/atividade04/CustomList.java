package com.example.atividade04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<Aluno> {

    int resourceLayout;
    @NonNull
    Context context;
    public CustomList(@NonNull Context context, int resource, ArrayList<Aluno> objects) {
        super(context, resource,objects);
        this.context = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String nome = getItem(position).getNome();
        String matricula = getItem(position).getMatricula();
        String status = getItem(position).getStatus();

        Aluno aluno = new Aluno(nome,matricula,status);
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resourceLayout,parent,false);

        TextView tvNome = convertView.findViewById(R.id.text01);
        TextView tvMatricula = convertView.findViewById(R.id.text02);
        TextView tvStatus = convertView.findViewById(R.id.text03);

        tvNome.setText(nome);
        tvMatricula.setText(matricula);
        tvStatus.setText(status);

        return convertView;
    }
}
