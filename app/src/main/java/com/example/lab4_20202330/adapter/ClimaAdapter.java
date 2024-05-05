package com.example.lab4_20202330.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_20202330.R;
import com.example.lab4_20202330.entity.Clima;

import java.util.List;

public class ClimaAdapter extends RecyclerView.Adapter<ClimaAdapter.ClimaViewHolder> {

    private Context context;
    private List<Clima> climaDetallesList;

    public ClimaAdapter(Context context, List<Clima> climaDetallesList) {
        this.context = context;
        this.climaDetallesList = climaDetallesList;
    }

    @NonNull
    @Override
    public ClimaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_clima, parent, false);
        return new ClimaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClimaViewHolder holder, int position) {
        Clima clima = climaDetallesList.get(position);
        holder.bind(clima);
    }

    @Override
    public int getItemCount() {
        return climaDetallesList.size();
    }

    public class ClimaViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTemperatura;
        private TextView ciudad;
        private TextView minTextView;
        private TextView maxTextView;
        private TextView vientoTextView;

        public ClimaViewHolder(@NonNull View itemView) {
            super(itemView);
            ciudad = itemView.findViewById(R.id.ciudad);
            textViewTemperatura = itemView.findViewById(R.id.textView_temperatura);
            minTextView = itemView.findViewById(R.id.minTextView);
            maxTextView = itemView.findViewById(R.id.maxTextView);
            vientoTextView = itemView.findViewById(R.id.vientoTextView);


        }

        public void bind(Clima clima) {
            ciudad.setText(String.valueOf(Clima.getNombre()));
            textViewTemperatura.setText(String.valueOf(Clima.getTemperatura()));
            minTextView.setText(String.valueOf(Clima.getMin()));
            maxTextView.setText(String.valueOf(Clima.getMax()));
            vientoTextView.setText(String.valueOf(Clima.getViento()));
            Log.d("DANITA CLIMA",Clima.getTemperatura());
        }
    }
}
