package com.example.novo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText editTextNome, editTextEmail, editTextDnsc;
    Button button;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome=findViewById(R.id.editNome);
        editTextEmail=findViewById(R.id.editEmail);
        editTextDnsc=findViewById(R.id.editDnsc);
        button=findViewById(R.id.buttonCadastrar);
        listView=findViewById(R.id.listview);
        //Definindo tratamento para evento de clicl do botao
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome=editTextNome.getText().toString();
                String email=editTextEmail.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put("nome", nome);
                cv.put("email", email);
                long status=database.insert("pessoas", null, cv);
                if(status>0){
                    Toast.makeText(getApplicationContext(), "Usuário inserido com sucesso",
                            Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Erro na inserção!",
                            Toast.LENGTH_LONG).show();
                }
                carregarListagem();
            }
        });

        database=openOrCreateDatabase("meubd",MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT,nome varchar, " +
                "email varchar, dtnsc DATE)");
        carregarListagem();

    }
    public void carregarListagem(){
        Cursor cursor=database.rawQuery("SELECT * FROM pessoas", null);
        cursor.moveToFirst();
        ArrayList<String> nomes = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            nomes.add(cursor.getString(1));
            cursor.moveToNext();

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes);
        listView.setAdapter(adapter);
    }
}