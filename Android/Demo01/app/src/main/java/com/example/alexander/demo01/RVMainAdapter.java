package com.example.alexander.demo01;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 14/05/17.
 */

public class RVMainAdapter extends RecyclerView.Adapter<RVMainAdapter.RVMainAdapterViewHolder> {
    private List<Persona> mLstPersona = new ArrayList<>();
    public TextView tvMainItemFullname, tvMainItemDocument, tvMainItemAge;
    interface RVMainAdapterListener{
        void onClickItem(Persona persona);
    }

    private RVMainAdapterListener mRVMainAdapterListener;

    public RVMainAdapter(RVMainAdapterListener rvMainAdapterListener) {
        this.mRVMainAdapterListener = rvMainAdapterListener;
    }

    //AGREGAR ITEM
    public void add(Persona persona) {
        mLstPersona.add(persona);
        notifyItemInserted(mLstPersona.size() - 1);
    }

    //UPDATE ITEM
    public void update(Persona persona) {
        for (int i = 0; i < mLstPersona.size(); i++) {
            if (mLstPersona.get(i).getId().equals(persona.getId())) {
                mLstPersona.get(i).setNombre(persona.getNombre());
                mLstPersona.get(i).setEdad(persona.getEdad());
                mLstPersona.get(i).setApellido(persona.getApellido());
                notifyItemChanged(i);
                break;
            }
        }
    }

    //DELETE ITEM
    public void delete(Persona persona){
        for (int i = 0; i < mLstPersona.size(); i++) {
            if (mLstPersona.get(i).getId().equals(persona.getId())) {
                mLstPersona.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }

    //CREACION DE CADA FILA
    @Override
    public RVMainAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        RVMainAdapterViewHolder rvMainAdapterViewHolder = new RVMainAdapterViewHolder(view);
        return rvMainAdapterViewHolder;
    }

    //REFRESCAR LA VISTA
    @Override
    public void onBindViewHolder(RVMainAdapterViewHolder holder, int position) {
        Persona persona = mLstPersona.get(position);
        holder.itemView.setOnClickListener(itemViewOnClickListener);
        holder.itemView.setTag(persona);
        holder.tvMainItemFullname.setText(persona.getNombre() + " " + persona.getApellido());
        holder.tvMainItemDocument.setText(persona.getDocumento());
        holder.tvMainItemAge.setText(String.valueOf(persona.getEdad()));
    }

    private View.OnClickListener itemViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Persona persona = (Persona) view.getTag();
            if(mRVMainAdapterListener != null)
                mRVMainAdapterListener.onClickItem(persona);
        }
    };

    //CANTIDAD DE ITEMS EN LA LISTA
    @Override
    public int getItemCount() {
        return mLstPersona.size();
    }

    //VIEW HOLDER DE LA VISTA
    static class RVMainAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tvMainItemFullname, tvMainItemDocument, tvMainItemAge;
        public RVMainAdapterViewHolder(View itemView) {
            super(itemView);

            tvMainItemFullname = (TextView) itemView.findViewById(R.id.tvMainItemFullname);
            tvMainItemDocument = (TextView) itemView.findViewById(R.id.tvMainItemDocument);
            tvMainItemAge = (TextView) itemView.findViewById(R.id.tvMainItemAge);

        }
    }
}
