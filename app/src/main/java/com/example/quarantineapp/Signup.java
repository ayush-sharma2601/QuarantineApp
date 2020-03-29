package com.example.quarantineapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
    EditText name, email, password,id,address;
    Button signin;
    TextView login;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    DatabaseReference userReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        attachID();
        if (fAuth.getCurrentUser() != null) {
            //Bhai yahan par Intent wali line likh dena
            finish();
        }
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nameMH = name.getText().toString();
                final String addressMH = address.getText().toString();
                final String idMH = id.getText().toString();
                String decider= getIntent().getStringExtra("key");

                String mail = email.getText().toString().trim();
                String pass = password.getText().toString();

                progressBar.setVisibility(View.VISIBLE);
                fAuth.createUserWithEmailAndPassword(mail, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        userReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("name").setValue(nameMH);
                        userReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("id").setValue(addressMH);
                        userReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("address").setValue(idMH);
                        Toast.makeText(Signup.this, "User created", Toast.LENGTH_SHORT).show();
                        //bhai yahan par intent wali line likh dena
//                        Intent goLogin = new Intent(Signup.this,Login.class);
//                        startActivity(goLogin);
//                        finish();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Signup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });



            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginPage=new Intent(Signup.this,Login.class);
                startActivity(loginPage);
                finish();;
            }
        });

    }

    private void attachID() {
        name=findViewById(R.id.ed_name);
        email=findViewById(R.id.ed_email);
        password=findViewById(R.id.ed_pass);
        signin=findViewById(R.id.btnl_signup);
        login=findViewById(R.id.tv_login);
        progressBar=findViewById(R.id.pgbar);
        id = findViewById(R.id.ed_ID);
        address= findViewById(R.id.ed_address);
        fAuth=FirebaseAuth.getInstance();
        userReference= FirebaseDatabase.getInstance().getReference().child("users");

    }

    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
