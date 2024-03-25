package com.example.parcial1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText usuario, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = findViewById(R.id.btn);
        usuario =findViewById(R.id.botonuser);
        contraseña = findViewById(R.id.botonpass);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 =usuario.getText().toString();
                String v2 =contraseña.getText().toString();

                if (v1.equals("") && v2.equals("")) {
                    Toast.makeText(MainActivity.this, "Tiene que llenar los campos", Toast.LENGTH_LONG).show();
                }else if (v1.equals("uac123") && v2.equals("12345678")) {
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Ingresando sesion", Toast.LENGTH_LONG).show();
                } if (!v1.equals("uac123") ) {
                    Toast.makeText(MainActivity.this, "Usuario equivocado", Toast.LENGTH_LONG).show();
                }else if (!v2.equals("12345678")) {
                    Toast.makeText(MainActivity.this, "Contraseña equivocada", Toast.LENGTH_LONG).show();
                }
            }
        });


        }
    }
