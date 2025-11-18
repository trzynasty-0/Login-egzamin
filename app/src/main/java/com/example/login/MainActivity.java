package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText emailInput, hasloInput1, hasloInput2;
    private TextView emailView;
    private Button zatwierdzButton, generujButton;
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

        emailInput = findViewById(R.id.email);
        hasloInput1 = findViewById(R.id.haslo1);
        hasloInput2 = findViewById(R.id.haslo2);
        emailView = findViewById(R.id.emailView);
        zatwierdzButton = findViewById(R.id.zatwierdz);

        zatwierdzButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EmailSprawdzenie(emailInput.getText().toString(), hasloInput1.getText().toString(), hasloInput2.getText().toString());
                    }
                }
        );

    }
    private void EmailSprawdzenie(String email, String haslo1, String haslo2){
        if(!email.contains("@")){
            emailView.setText("Nieprawidłowy adres email");
        }
        else if(!haslo2.equals(haslo1)){
            emailView.setText("Hasła się różnią");
        }
        else{
            emailView.setText("Hello" + email);
        }
    }
}