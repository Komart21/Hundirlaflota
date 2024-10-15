package com.project.hundirlaflota;


import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia al TableLayout definido en el XML
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Definir las letras para las columnas (A - J)
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        // Crear la primera fila con las letras (A - J)
        TableRow primeraFila = new TableRow(this);
        primeraFila.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

        // Añadir una celda vacía en la esquina superior izquierda
        TextView emptyCorner = new TextView(this);
        emptyCorner.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        primeraFila.addView(emptyCorner);

        // Añadir las letras de A a J
        for (String letra : letras) {
            TextView textView = new TextView(this);
            textView.setText(letra);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(16, 16, 16, 16);
            primeraFila.addView(textView);
        }

        // Añadir la primera fila (letras) al TableLayout
        tableLayout.addView(primeraFila);

        // Crear el resto de la cuadrícula con botones
        for (int fila = 1; fila <= 10; fila++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            // Añadir el número de la fila (1 - 10)
            TextView textView = new TextView(this);
            textView.setText(String.valueOf(fila));
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(16, 16, 16, 16);
            tableRow.addView(textView);

            // Añadir los botones para cada columna en la fila
            for (int col = 0; col < letras.length; col++) {
                Button boton = new Button(this);
                boton.setLayoutParams(new TableRow.LayoutParams(100, 100));
                final String posicion = letras[col] + fila;

                // Listener para manejar el clic en cada botón
                boton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Casilla seleccionada: " + posicion, Toast.LENGTH_SHORT).show();
                    }
                });

                // Añadir el botón a la fila
                tableRow.addView(boton);
            }

            // Añadir la fila al TableLayout
            tableLayout.addView(tableRow);
        }
    }
}
