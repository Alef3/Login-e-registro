package com.cursodeandroid.cardview.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cursodeandroid.cardview.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.view.View.*;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    private FirebaseAuth autenticacao;
    public static String TAG = "FIREBASELOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        autenticacao = FirebaseAuth.getInstance();

        listenerCadastro();
        listenerLogin();
    }

    public void listenerCadastro(){
        binding.textRegistrarse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCadastrar = new Intent(getApplicationContext(), CadastrarActivity.class);
                startActivity(intentCadastrar);

                Toast.makeText(LoginActivity.this, "Tela de cadastro", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void listenerLogin(){
        binding.buttonEntrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                logar();
            }
        });
    }

    public void logar(){
        String email = binding.editTextEmail.getText().toString();
        String senha = binding.editTextSenha.getText().toString();

        autenticacao.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser usuario = autenticacao.getCurrentUser();
                            Toast.makeText(LoginActivity.this, "Authentication sucessful.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(usuario);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }

    public void updateUI(FirebaseUser account){
        if(account != null){
            Toast.makeText(LoginActivity.this, "Logado com sucesso!", Toast.LENGTH_LONG).show();
            //startActivity(new Intent(this, MainActivity.class));
        }else {
            Toast.makeText(this, "Ops! Algo errado", Toast.LENGTH_SHORT).show();
        }
    }
}