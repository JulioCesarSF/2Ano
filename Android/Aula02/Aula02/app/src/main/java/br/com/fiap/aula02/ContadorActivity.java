package br.com.fiap.aula02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContadorActivity extends AppCompatActivity {

    TextView txtResultado;
    Button btnMenos, btnMais, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        txtResultado = (TextView)findViewById(R.id.txtResultado);
        btnMenos = (Button)findViewById(R.id.btnMenos);
        btnMais = (Button)findViewById(R.id.btnMais);
        btnLimpar = (Button)findViewById(R.id.btnLimpar);

        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                somar(view);
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menos(view);
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar(view);
            }
        });
    }

    public void somar(View v){
        int val = Integer.parseInt(txtResultado.getText().toString());
        val++;
        txtResultado.setText(String.valueOf(val));
    }
    public void menos(View v){
        int val = Integer.parseInt(txtResultado.getText().toString());
        val--;
        txtResultado.setText(String.valueOf(val));
    }

    public void limpar(View v){
        txtResultado.setText("0");
    }

}
