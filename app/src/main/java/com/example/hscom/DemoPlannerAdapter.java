package com.example.hscom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DemoPlannerAdapter extends RecyclerView.Adapter<DemoPlannerAdapter.ViewHolder>{
    Context context;
    ArrayList<PlannerItemDemo> items = new ArrayList<PlannerItemDemo>();
    DemoPlannerAdapter.OnItemClickListener listener;
    public static interface OnItemClickListener{
        public void onItemClick(ViewHolder holder, View view, int position);
    }
    public DemoPlannerAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getItemCount(){
        return items.size();
    }

    @NonNull
    @Override
    public DemoPlannerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.planner_layout_demo,viewGroup,false);
        return new DemoPlannerAdapter.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlannerItemDemo item = items.get(position);
        holder.setItem(item);
        holder.setOnItemClickListener(listener);
    }
    public void addItem(PlannerItemDemo item){
        items.add(item);
    }
    public void addItems(ArrayList<PlannerItemDemo> item){
        this.items = items;
    }
    public PlannerItemDemo getItem(int position){
        return items.get(position);
    }
    public void setOnItemClickListener(DemoPlannerAdapter.OnItemClickListener listener){
        this.listener = listener;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPlannerText, textViewPlannerTime;
        OnItemClickListener listener;
        public ViewHolder(@NonNull final View itemView1){
            super(itemView1);
            textViewPlannerText = itemView1.findViewById(R.id.PlannerTextDemo);
            textViewPlannerTime = itemView1.findViewById(R.id.PlannerTimeTextDemo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, itemView, position);
                    }
                }
            });
        }

        public void setItem(PlannerItemDemo item){
            textViewPlannerText.setText(item.getTask());
            textViewPlannerTime.setText(item.getTime());
        }

        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }
    }
}
