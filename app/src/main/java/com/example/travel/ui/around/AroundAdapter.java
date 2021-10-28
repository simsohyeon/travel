package com.example.travel.ui.around;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.travel.R;

import java.util.List;
import java.util.Locale;

public class AroundAdapter extends RecyclerView.Adapter<AroundAdapter.ViewHolder> {

    private final List<Around> list;
    private OnItemClickListener onItemClickListener;

    public AroundAdapter(List<Around> list) {
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameText;
        private final TextView addressText;
        private final TextView telText;
        private final TextView distanceText;

        public ViewHolder(View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.txtHospitalName);
            addressText = itemView.findViewById(R.id.txtHospitalAddress);
            telText = itemView.findViewById(R.id.txtHospitalTel);
            distanceText = itemView.findViewById(R.id.txtHospitalDistance);
        }
        public void bind(Around model, OnItemClickListener listener) {

            nameText.setText(model.getName());
            addressText.setText(model.getAddress());
            telText.setText(model.getTel());

            String strDistance = String.format(Locale.getDefault(),
                    "%dm", Math.round(model.getDistance()));
            distanceText.setText(strDistance);

            if (listener != null) {
                itemView.setOnClickListener(v -> {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                });
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_around, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Around item = list.get(position);
        holder.bind(item, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}
