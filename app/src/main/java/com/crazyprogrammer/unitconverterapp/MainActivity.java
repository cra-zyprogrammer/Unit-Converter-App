package com.crazyprogrammer.unitconverterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView title, textView;
    EditText kiloWeight;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        title = findViewById(R.id.title);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        kiloWeight = findViewById(R.id.kiloWeight);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = kiloWeight.getText().toString();

                // converting a string into a double
                double kilos = Double.parseDouble(inputText);

                // converting kilos into pounds
                double pounds = makeConversion(kilos);

                // displaying the conversion result
                textView.setText("" + pounds);

            }
        });

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public double makeConversion(double kilos){
//        1 kilo = 2.20462 pounds
        return kilos* 2.20462;
    }
}