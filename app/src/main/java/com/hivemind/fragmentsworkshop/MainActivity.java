package com.hivemind.fragmentsworkshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputFN, inputLN, inputE, inputP;
    private String infn, inln, ine, inp;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind xml components to java vars
        inputFN = findViewById(R.id.first_name_et);
        inputLN = findViewById(R.id.last_name_et);
        inputE = findViewById(R.id.email_et);
        inputP = findViewById(R.id.phone_et);
        nextBtn  = findViewById(R.id.next_btn);

        //navigation
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //collect user data
                infn = inputFN.getText().toString().trim();
                inln = inputLN.getText().toString().trim();
                ine = inputE.getText().toString().trim();
                inp = inputP.getText().toString().trim();
                //perform navigation
                NavigateToHome(infn, inln, ine, inp);
            }
        });

    }

    //navigation
    void NavigateToHome(String fn, String ln, String e, String p){
        //declaring an intent
        Intent intent = new Intent(this, Home.class);
        //packaging user data
        intent.putExtra("STRING_FN", fn);
        intent.putExtra("STRING_LN", ln);
        intent.putExtra("STRING_E", e);
        intent.putExtra("STRING_P", p);
        //starting the intent towards destination
        startActivity(intent);
    }
}