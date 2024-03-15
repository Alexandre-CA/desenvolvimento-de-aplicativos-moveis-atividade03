package com.example.atividade04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Aluno> alunos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list);


        alunos.add(new Aluno("Nome 01","1","Ativo"));

        CustomList adapter = new CustomList(this, R.layout.layout_list, alunos);
        listView.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.buttonAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nomeInput = (EditText) findViewById(R.id.editTextText);
                if(!nomeInput.getText().toString().isEmpty()){
                    alunos.add(new Aluno(nomeInput.getText().toString(),alunos.size()+1+"","Ativo"));
                    nomeInput.setText("");

                }
            }
        });
    }
}