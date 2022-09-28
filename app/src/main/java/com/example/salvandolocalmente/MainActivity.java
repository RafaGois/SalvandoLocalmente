package com.example.salvandolocalmente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String ARQUIVO_PREFERENCIA = "ArqivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salvaNome();
    }

    private void salvaNome () {
        ImageButton button = findViewById(R.id.botao);
        EditText editText = findViewById(R.id.input);
        TextView textView = findViewById(R.id.resultado);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor =  preferences.edit();

                if (editText.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Informe o nome", Toast.LENGTH_SHORT).show();
                } else {
                    String nome = editText.getText().toString();
                    editor.putString("nome",nome);
                    editor.commit();
                    textView.setText("Olá "+ nome);
                }
            }
        });

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

        if ( preferences.contains("nome")) {
            String nome = preferences.getString("nome","Usuário não definido");

            textView.setText("Olá "+ nome);
        } else {
            textView.setText("Usuário não encontrado");
        }

    }

    private void buscaNome () {


        EditText editText = findViewById(R.id.input);


    }
}