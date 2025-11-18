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
    private TextView dlugoscView, cyfryView, znakiView, mLiteryView, dLiteryView;
    private Button zatwierdzButton, generujButton, mocHalsaButton;
    private boolean czyPoprawne = false;

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
        dlugoscView = findViewById(R.id.dlugosc);
        znakiView = findViewById(R.id.znaki);
        mLiteryView = findViewById(R.id.mLitery);
        dLiteryView = findViewById(R.id.dLitery);
        cyfryView = findViewById(R.id.cyfry);
        mocHalsaButton = findViewById(R.id.moc);

        zatwierdzButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EmailSprawdzenie(emailInput.getText().toString(), hasloInput1.getText().toString(), hasloInput2.getText().toString());
                    }
                }
        );

        mocHalsaButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mocHaslaSprawdzenie();
                    }
                }
        );
        generujButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

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
            czyPoprawne = true;
        }
    }
    String alfabet = "abcdefghijklmnopqrstuvwxyz";
    String cyfry = "1234567890";
    String znaki = "!@#$%^&*.,";
    private void mocHaslaSprawdzenie(){
        for(int i = 0; i < hasloInput1.getText().toString().length(); i++){
            if(alfabet.toUpperCase().contains(Character.toString(hasloInput1.getText().toString().charAt(i)))){
                dLiteryView.setTextColor(getColor(R.color.poprawne));
                i = hasloInput1.getText().toString().length();
            }
            else{
                dLiteryView.setTextColor(getColor(R.color.niepoprawne));

            }
        }
        for(int i = 0; i < hasloInput1.getText().toString().length(); i++){
            if(alfabet.contains(Character.toString(hasloInput1.getText().toString().charAt(i)))){
                mLiteryView.setTextColor(getColor(R.color.poprawne));
                i = hasloInput1.getText().toString().length();
            }
            else{
                mLiteryView.setTextColor(getColor(R.color.niepoprawne));

            }
        }
        for(int i = 0; i < hasloInput1.getText().toString().length(); i++){
            if(cyfry.contains(Character.toString(hasloInput1.getText().toString().charAt(i)))){
                cyfryView.setTextColor(getColor(R.color.poprawne));
                i = hasloInput1.getText().toString().length();
            }
            else{
                cyfryView.setTextColor(getColor(R.color.niepoprawne));

            }
        }
        for(int i = 0; i < hasloInput1.getText().toString().length(); i++){
            if(znaki.contains(Character.toString(hasloInput1.getText().toString().charAt(i)))){
                znakiView.setTextColor(getColor(R.color.poprawne));
                i = hasloInput1.getText().toString().length();
            }
            else{
                znakiView.setTextColor(getColor(R.color.niepoprawne));

            }
        }
        if(hasloInput1.getText().toString().length() > 12){
            dlugoscView.setTextColor(getColor(R.color.poprawne));

        }
        else{
            dlugoscView.setTextColor(getColor(R.color.niepoprawne));

        }

    }
}