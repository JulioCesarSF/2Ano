package br.com.julio.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity  implements View.OnClickListener{

    //Views
    EditText edtPrimeiroNumero, edtSegundoNumero;
    Button btnSoma, btnSubtrair, btnMultiplicar, btnDividir, btnLimpar;
    TextView txtResultado;

    //Variaveis numeros
    float x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        //edits
        edtPrimeiroNumero = (EditText) findViewById(R.id.edtPrimeiroNumero);
        edtSegundoNumero = (EditText) findViewById(R.id.edtSegundoNumero);

        //buttons
        btnSoma = (Button) findViewById(R.id.btnSomar);
        btnSubtrair = (Button) findViewById(R.id.btnSubtrair);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnDividir = (Button) findViewById(R.id.btnDividir);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        //textviews
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        //set listeners
        btnSoma.setOnClickListener(this);
        btnSubtrair.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);

        //set textWatchers
        edtPrimeiroNumero.addTextChangedListener(edtWatcher);
        edtSegundoNumero.addTextChangedListener(edtWatcher);
    }

    @Override
    public void onClick(View view) {
        //numeros em String
        String n1 = edtPrimeiroNumero.getText().toString().equals("") ? "0" : edtPrimeiroNumero.getText().toString();
        String n2 = edtSegundoNumero.getText().toString().equals("") ? "0" : edtSegundoNumero.getText().toString();

        //números digitados
        x = Float.parseFloat(n1.replace(",", "."));
        y = Float.parseFloat(n2.replace(",", "."));

        switch (view.getId()){
            case R.id.btnSomar:
                txtResultado.setText(String.valueOf(x+y).replace(".", ","));
                break;

            case R.id.btnSubtrair:
                txtResultado.setText(String.valueOf(x-y).replace(".", ","));
                break;

            case R.id.btnMultiplicar:
                txtResultado.setText(String.valueOf(x*y).replace(".", ","));
                break;

            case R.id.btnDividir:
                if(y == 0){
                    txtResultado.setText("0.0");
                    Toast.makeText(this, "Divisão por zero.", Toast.LENGTH_SHORT).show();
                }else{
                    txtResultado.setText(String.valueOf(x/y).replace(".", ","));
                }
                break;

            case R.id.btnLimpar:
                //limpar edits e resultado
                edtPrimeiroNumero.setText("");
                edtSegundoNumero.setText("");
                txtResultado.setText("0,0");
                break;
        }
    }

    private final TextWatcher edtWatcher = new TextWatcher() {

        String txtAnterior;

        @Override
        //s, start, count, after
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            txtAnterior = charSequence.toString();
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            int contador = editable.length() - editable.toString().replace(",", "").length();

            if(contador > 1 && edtPrimeiroNumero.getEditableText() == editable){
                edtPrimeiroNumero.setText(txtAnterior);
                edtPrimeiroNumero.setSelection(edtPrimeiroNumero.getText().length());
            }else if(contador > 1){
                edtSegundoNumero.setText(txtAnterior);
                edtSegundoNumero.setSelection(edtSegundoNumero.getText().length());
            }
        }
    };
}
