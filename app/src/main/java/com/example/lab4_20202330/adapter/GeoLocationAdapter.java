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
import com.example.lab4_20202330.entity.GeoLocalizacion;

import java.util.List;

public class GeoLocationAdapter extends RecyclerView.Adapter<GeoLocationAdapter.ViewHolder> {

    private List<GeoLocalizacion> geoLocations;
    private Context context;

    public GeoLocationAdapter(Context context, List<GeoLocalizacion> geoLocations) {
        this.context = context;
        this.geoLocations = geoLocations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_geolocalizacion, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("DANITA HABLANDO","Entre a mandar la data");
        GeoLocalizacion location = geoLocations.get(position);
        holder.latitudeTextView.setText(location.getLat());
        holder.longitudeTextView.setText(location.getLon());
        Log.d("DANITA HABLANDO",location.getLat());
        Log.d("DANITA HABLANDO",location.getLon());
    }

    @Override
    public int getItemCount() {
        return geoLocations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView latitudeTextView;
        TextView longitudeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            latitudeTextView = itemView.findViewById(R.id.latitudeTextView);
            longitudeTextView = itemView.findViewById(R.id.longitudeTextView);
        }
    }
}
