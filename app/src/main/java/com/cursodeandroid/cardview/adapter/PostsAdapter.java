package com.cursodeandroid.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursodeandroid.cardview.databinding.PostDetalheBinding;
import com.cursodeandroid.cardview.model.Postagem;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    PostDetalheBinding binding;
    private List<Postagem> postagens;

    public PostsAdapter(List<Postagem> listaPostagens) {
        this.postagens = listaPostagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View itemLista = LayoutInflater.from(parent.getContext())
        //        .inflate(R.layout.post_detalhe, parent, false);

        binding = PostDetalheBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View itemLista = binding.getRoot();

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        Postagem postagem = postagens.get( position );
        holder.mBinding.textCategoria.setText(postagem.getNome());
        holder.mBinding.textPostagem.setText(postagem.getDescricao());
        holder.mBinding.imagePost.setImageResource(postagem.getImagem());
        holder.mBinding.textData.setText(postagem.getHora());

    }


    @Override
    public int getItemCount() {
        return postagens.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        PostDetalheBinding mBinding = binding;
        //private TextView nome, descricao, hora;
        //private ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //nome = itemView.findViewById(R.id.textNome);          sem binding
            //descricao = itemView.findViewById(R.id.textPostagem); ===========
            //imagem = itemView.findViewById(R.id.imagePost);          ========
            //hora = itemView.findViewById(R.id.textData);             ========

        }

    }


}
