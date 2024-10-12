/*
@author:<Matheus Augusto Marti>
 */

package br.edu.fateczl.atv3ex2combustivel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etConsumo;
    private EditText etCombustivel;
    private TextView tvRes;

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

        etConsumo = findViewById(R.id.etConsumo);
        etCombustivel = findViewById(R.id.etCombustivel);
        tvRes = findViewById(R.id.tvRes);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(op -> calc());
    }

    private void calc() {
        tvRes.setText("");
        double consumo = Double.parseDouble(etConsumo.getText().toString());
        double combustivel = Double.parseDouble(etCombustivel.getText().toString());
        double autonomia = (combustivel * consumo) * 1000;
        String res = "Autonomia: " + autonomia + " m";
        tvRes.setText(res);
        etConsumo.setText("");
        etCombustivel.setText("");
    }
}