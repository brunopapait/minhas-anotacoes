package br.com.minhasanotacoes;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        TextView texto = findViewById(R.id.editText);

        SharedPreferences sharedPreferences = getSharedPreferences("MINHAS_ANOTACOES", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("anotacoes", texto.getText().toString());
        editor.apply();

        Snackbar.make(v, "Anotações salvas com sucesso !", Snackbar.LENGTH_LONG)
                .setAction("OK", null).show();
      }
    });
    TextView textValue = findViewById(R.id.editText);
    SharedPreferences sharedPreferences = getSharedPreferences("MINHAS_ANOTACOES", MODE_PRIVATE);
    if (sharedPreferences.contains("anotacoes")) {
      String texto = sharedPreferences.getString("anotacoes", "");
      textValue.setText(texto);
    }
  }
}
