package com.android.example.consumodecombustivel;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculaKmPorLitro();

        calculaConsumoaos100();

    }

    private void calculaKmPorLitro() {

        final float[] media = new float[1];

        Button kmPorLitro = findViewById(R.id.kml);

        kmPorLitro.setOnClickListener(v -> {

            EditText litros = findViewById(R.id.litros);
            String strlitros = litros.getText().toString();
            EditText km = findViewById(R.id.km);
            String strkm = km.getText().toString();

            if (TextUtils.isEmpty(strlitros) || TextUtils.isEmpty(strkm)) {

                Context context = getApplicationContext();
                CharSequence text = "Preencha os campos litros e km!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                return;

            }

            TextView tvResultado = findViewById(R.id.resultadoKmPorLitro);
            TextView tvDescricao = findViewById(R.id.descricao_kmPorLitro);

            float lt = Float.parseFloat(litros.getText().toString());
            float kilometros = Float.parseFloat(km.getText().toString());

            media[0] = kilometros / lt;
            tvResultado.setText(media[0] + "");
            tvDescricao.setText("Km/l");
        });
    }

    private void calculaConsumoaos100() {

        final float[] consumoAos100 = new float[1];


        Button consumo100 = findViewById(R.id.consumoaos100);


        consumo100.setOnClickListener(v -> {

            float valor = 100;
            float m;
            EditText litros = findViewById(R.id.litros);
            String strlitros = litros.getText().toString();
            EditText km = findViewById(R.id.km);
            String strkm = km.getText().toString();

            if (TextUtils.isEmpty(strlitros) || TextUtils.isEmpty(strkm)) {

                Context context = getApplicationContext();
                CharSequence text = "Preencha os campos litros e km!";
                int duration = Toast.LENGTH_SHORT;


                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                return;

            }

            TextView tvResultado = findViewById(R.id.resultadoKmPorLitro);
            TextView tvDescricao = findViewById(R.id.descricao_kmPorLitro);
            float lt = Float.parseFloat(litros.getText().toString());
            float kilometros = Float.parseFloat(km.getText().toString());


            m = kilometros / lt;
            consumoAos100[0] = valor / m;
            tvResultado.setText(consumoAos100[0] + "");
            tvDescricao.setText("litros aos 100 km");
        });

    }


}