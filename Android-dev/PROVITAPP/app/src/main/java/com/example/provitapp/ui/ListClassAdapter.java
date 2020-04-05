package com.example.provitapp.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.provitapp.Order;
import com.example.provitapp.R;

import java.util.ArrayList;

public class ListClassAdapter extends RecyclerView.Adapter<ListClassAdapter.OrderViewHolder> implements View.OnClickListener{

    ArrayList<Order> listOfOrders;
    private View.OnClickListener listener;
    private String state;

    public ListClassAdapter(ArrayList<Order> listsOfOrders, String state) {
        this.listOfOrders = listsOfOrders;
        this.state = state;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView textObject, textVolumeNumber,
                textState, textReferenceID, textFecha;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            textObject = (TextView) itemView.findViewById(R.id.ObjectName);
            textVolumeNumber = (TextView) itemView.findViewById(R.id.VolumeNumber);
            textFecha = (TextView) itemView.findViewById(R.id.fechaNumber);
            textState = (TextView) itemView.findViewById(R.id.State);
            textReferenceID = (TextView) itemView.findViewById(R.id.ReferenceIdNum);
        }

    }


    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);

        view.setOnClickListener(this);

        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.textObject.setText("" + listOfOrders.get(position).getId_objeto());
        holder.textVolumeNumber.setText("" + listOfOrders.get(position).getCantidad());
        holder.textFecha.setText(listOfOrders.get(position).getFecha());
        holder.textState.setText(state);
        holder.textReferenceID.setText("" +listOfOrders.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return listOfOrders.size();
    }

    public void setOnClickListener (View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }




}
