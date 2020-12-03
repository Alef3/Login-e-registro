package com.cursodeandroid.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cursodeandroid.cardview.R;
import com.cursodeandroid.cardview.adapter.PostsAdapter;
import com.cursodeandroid.cardview.databinding.ActivityMainBinding;
import com.cursodeandroid.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Intent intentLogin = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intentLogin);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Define layout
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        binding.recyclerPostagem.setLayoutManager( layoutManager );

        //define adapter
        this.prepararPostagens();

        PostsAdapter adapter = new PostsAdapter( postagens );
        binding.recyclerPostagem.setAdapter( adapter );

    }

    public void prepararPostagens (){
        Postagem p = new Postagem("Viagem legal", "Nas nuvens",R.drawable.imagem1 , "agora mesmo");
        this.postagens.add( p );

        p = new Postagem("Viagem legal 2", "Nas nuvens 2", R.drawable.imagem2, "agora mesmo");
        this.postagens.add( p );

        p = new Postagem("Viagem legal 3", "Nas nuvens 3", R.drawable.imagem3, "agora mesmo");
        this.postagens.add( p );

        p = new Postagem("Viagem legal 4", "Nas nuvens 4", R.drawable.imagem4, "agora mesmo");
        this.postagens.add( p );
    }
}