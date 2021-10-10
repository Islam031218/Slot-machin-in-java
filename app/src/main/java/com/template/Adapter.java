package com.template;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name , record,number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.list_item_name);
            record = itemView.findViewById(R.id.list_item_record);
            number = itemView.findViewById(R.id.list_item_number);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("MyTag", String.valueOf(position));
        holder.name.setText(Utils.list.get(position).name);
        holder.record.setText(Utils.list.get(position).record);
        holder.number.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return  Utils.list.size();
    }

}

