package com.example.drive.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.drive.R;

import java.util.ArrayList;

public class adtMensajes extends RecyclerView.Adapter<adtMensajes.MyViewHolder> {
    private static final int TYPE_HEADER=0;
    private static final int TYPE_LIST=0;


    private Context mContext;



    private ArrayList<mensaje> mLista;

    public TextView lblNombre;
    public ImageView imgIcon;
    public ImageView imgFoto;

    public adtMensajes(Context context, ArrayList<mensaje> lista) {
        mContext = context;
        mLista=lista;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
           view= LayoutInflater.from(mContext)
                   .inflate(R.layout.item_mail,null,false);
           return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        lblNombre.setText(mLista.get(position).getNombre());
   /*     lblAsunto.setText(mLista.get(position).getAsunto());
        lblMensaje.setText(mLista.get(position).getMensaje());
        lblHora.setText(mLista.get(position).getHora());*/

        Glide.with(mContext)
                .load(mLista.get(position).getUrl())
                .into(imgFoto);
        Glide.with(mContext)
                .load(mLista.get(position).getImg2())
                .into(imgIcon);
    }


    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        int view_type;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

                lblNombre=(TextView)itemView.findViewById(R.id.lblNombre);
               imgIcon= (ImageView) itemView.findViewById(R.id.imageView2);
                imgFoto=(ImageView) itemView.findViewById(R.id.imageView);

        }
    }

}
