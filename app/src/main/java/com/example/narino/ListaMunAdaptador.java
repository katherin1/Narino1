package com.example.narino;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.narino.modelos.Mun;
import com.example.narino.modelos.MunRespuesta;

import java.util.ArrayList;
import java.util.List;



public class ListaMunAdaptador extends RecyclerView.Adapter<ListaMunAdaptador.ViewHolder>{

    private ArrayList<Mun> dataset;
    private Context context;

    public  ListaMunAdaptador(Context context){

        this.context = context;
        dataset = new ArrayList<>();

    }

    public ListaMunAdaptador(){
        dataset=new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mun,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Mun p = dataset.get(position);
        holder.nomMun.setText(p.getNombremunicipio());

        holder.nomMun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetMunicipio.class);
                intent.putExtra("mun", p.getNombremunicipio());
                intent.putExtra("alc", p.getNombrealcalde());
                intent.putExtra("email", p.getCorreocontactenos());
                intent.putExtra("dir", p.getDireccion());
                intent.putExtra("tel", p.getTelefonocontacto());
                intent.putExtra("web", p.getPortalweb());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void agregarListaMun(List<MunRespuesta> munRespuesta) {

        dataset.addAll(munRespuesta);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nomMun;
        public ViewHolder(View itemView) {
            super(itemView);

            nomMun = (TextView) itemView.findViewById(R.id.nombreTxt);
        }
    }
}
