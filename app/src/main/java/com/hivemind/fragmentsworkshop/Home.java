package com.hivemind.fragmentsworkshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private TextView inputFN, inputLN, inputE, inputP;
    private Button fragOneBtn, fragTwoBtn, updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inputFN = findViewById(R.id.first_name_tv);
        inputLN = findViewById(R.id.last_name_tv);
        inputE = findViewById(R.id.email_tv);
        inputP = findViewById(R.id.phone_tv);
        fragOneBtn = findViewById(R.id.frag_one_btn);
        fragTwoBtn = findViewById(R.id.frag_two_btn);
        updateBtn = findViewById(R.id.update_profile_btn);

        Intent intent = getIntent();

        String infn = intent.getStringExtra("STRING_FN");
        String inln = intent.getStringExtra("STRING_LN");
        String ine = intent.getStringExtra("STRING_E");
        String inp = intent.getStringExtra("STRING_P");

        inputFN.setText(infn);
        inputLN.setText(inln);
        inputE.setText(ine);
        inputP.setText(inp);

        fragOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchFragments(new FragmentOne());
            }
        });

        fragTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchFragments(new FragmentTwo());
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateUserProfile();
            }
        });

    }

    void SwitchFragments(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    void UpdateUserProfile(){

    }
}