package com.example.alexander.demo01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements RVMainAdapter.RVMainAdapterListener{
    private RecyclerView rvMain;
    private RVMainAdapter mRVMainAdapter;
    private Button btMain;
    private final int REQUEST_CODE = 1;
    private final int MODIFY_CODE = 2;
    private final View.OnClickListener btMainOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        rvMain = (RecyclerView)findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        mRVMainAdapter = new RVMainAdapter(MainActivity.this);
        rvMain.setAdapter(mRVMainAdapter);

        Persona persona = new Persona();
        persona.setId(UUID.randomUUID().toString());
        persona.setNombre("Luis");
        persona.setApellido("Rios");
        persona.setEdad(new Random().nextInt(50)+1);
        mRVMainAdapter.add(persona);

        persona = new Persona();
        persona.setId(UUID.randomUUID().toString());
        persona.setNombre("Luis");
        persona.setApellido("Rios");
        persona.setEdad(new Random().nextInt(50)+1);
        mRVMainAdapter.add(persona);

        persona = new Persona();
        persona.setId(UUID.randomUUID().toString());
        persona.setNombre("Luis");
        persona.setApellido("Rios");
        persona.setEdad(new Random().nextInt(50)+1);
        mRVMainAdapter.add(persona);

        persona = new Persona();
        persona.setId(UUID.randomUUID().toString());
        persona.setNombre("Luis");
        persona.setApellido("Rios");
        persona.setEdad(new Random().nextInt(50)+1);
        mRVMainAdapter.add(persona);

        persona = new Persona();
        persona.setId(UUID.randomUUID().toString());
        persona.setNombre("Luis");
        persona.setApellido("Rios");
        persona.setEdad(new Random().nextInt(50)+1);
        mRVMainAdapter.add(persona);

        persona = new Persona();
        persona.setId(UUID.randomUUID().toString());
        persona.setNombre("Luis");
        persona.setApellido("Rios");
        persona.setEdad(new Random().nextInt(50)+1);
        mRVMainAdapter.add(persona);

        persona = new Persona();
        persona.setId(UUID.randomUUID().toString());
        persona.setNombre("Luis");
        persona.setApellido("Rios");
        persona.setEdad(new Random().nextInt(50)+1);
        mRVMainAdapter.add(persona);

        persona = new Persona();
        persona.setId(UUID.randomUUID().toString());
        persona.setNombre("Luis");
        persona.setApellido("Rios");
        persona.setEdad(new Random().nextInt(50)+1);
        mRVMainAdapter.add(persona);

        persona = new Persona();
        persona.setId(UUID.randomUUID().toString());
        persona.setNombre("Luis");
        persona.setApellido("Rios");
        persona.setEdad(new Random().nextInt(50)+1);
        mRVMainAdapter.add(persona);

        btMain = (Button) findViewById(R.id.btMain);

        btMain.setOnClickListener(btMainOnClickListener);
    }

    @Override
    public void onClickItem(Persona persona) {
        Intent intent = new Intent();
        intent.putExtra("firstname",
        intent.putExtra("lastname", etApellido.getText().toString());
        intent.putExtra("document", etDocumento.getText().toString());
        intent.putExtra("age", etEdad.getText().toString());

        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                Persona per = new Persona();
                per.setNombre(data.getStringExtra("firstname"));
                per.setApellido(data.getStringExtra("lastname"));
                per.setDocumento(data.getStringExtra("document"));
                per.setEdad(Integer.parseInt(data.getStringExtra("age")));

                mRVMainAdapter.add(per);
            }
            else {
                Persona per = new Persona();
                per.setNombre(data.getStringExtra("firstname"));
                per.setApellido(data.getStringExtra("lastname"));
                per.setDocumento(data.getStringExtra("document"));
                per.setEdad(Integer.parseInt(data.getStringExtra("age")));

                mRVMainAdapter.update(per);
            }
        }
    }
}
