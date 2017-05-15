package com.example.alexander.demo01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by alexander on 14/05/17.
 */

public class SecondActivity extends AppCompatActivity {
    private EditText etNombre, etApellido, etDocumento, etEdad;
    private Button btRegistrar, btModificar, btEliminar;
    private final int REQUEST_CODE = 1;

    private final View.OnClickListener btRegistrarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("firstname", etNombre.getText().toString());
            intent.putExtra("lastname", etApellido.getText().toString());
            intent.putExtra("document", etDocumento.getText().toString());
            intent.putExtra("age", etEdad.getText().toString());

            setResult(RESULT_OK, intent);
            finish();
        }
    };
    private final View.OnClickListener btModificarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("firstname", etNombre.getText().toString());
            intent.putExtra("lastname", etApellido.getText().toString());
            intent.putExtra("document", etDocumento.getText().toString());
            intent.putExtra("age", etEdad.getText().toString());

            setResult(RESULT_OK, intent);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etDocumento = (EditText) findViewById(R.id.etDocumento);
        etEdad = (EditText) findViewById(R.id.etEdad);

        btRegistrar = (Button) findViewById(R.id.btRegistrar);
        btRegistrar.setOnClickListener(btRegistrarOnClickListener);

        btModificar = (Button) findViewById(R.id.btModificar);
        btModificar.setOnClickListener(btModificarOnClickListener);
    }

}
