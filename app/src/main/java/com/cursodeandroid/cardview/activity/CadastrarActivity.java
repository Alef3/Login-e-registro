package com.cursodeandroid.cardview.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cursodeandroid.cardview.databinding.ActivityCadastrarBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CadastrarActivity extends AppCompatActivity {

    private ActivityCadastrarBinding binding;
    private FirebaseAuth autenticacao;
    public static String TAG = "FIREBASECADASTRO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCadastrarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        autenticacao = FirebaseAuth.getInstance();


        binding.buttonCadastrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                criarConta();
            }
        });
    }
    public void onStart(){
        super.onStart();

        FirebaseUser usuarioAtual = autenticacao.getCurrentUser();
        updateUI(usuarioAtual);
    }

    public void updateUI(FirebaseUser account){
        if(account != null){
            Toast.makeText(this, "Logado com sucesso!", Toast.LENGTH_LONG);
            //startActivity(new Intent(this, MainActivity.class));
        }else {
            Toast.makeText(this, "Ops! Algo errado", Toast.LENGTH_SHORT);
        }
    }

    public void criarConta(){
        String email = binding.editTextCadastroEmail.getText().toString();
        String senha = binding.editTextCadastroSenha.getText().toString();

        autenticacao.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){// sign in sucess, update UI with the signed-in users information
                            Log.d(TAG, "createUserWithEmail:sucess");
                            FirebaseUser usuario = autenticacao.getCurrentUser();
                            updateUI(usuario);
                        }else{
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CadastrarActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);

                        }
                    }
                });
    }

}