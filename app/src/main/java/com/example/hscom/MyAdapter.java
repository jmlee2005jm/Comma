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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    ArrayList<MyItem> items = new ArrayList<MyItem>();
    OnItemClickListener listener;
    public static interface OnItemClickListener{
        public void onItemClick(ViewHolder holder, View view, int position);
    }
    public MyAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getItemCount(){
        return items.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.my_item,viewGroup,false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyItem item = items.get(position);
        holder.setItem(item);
        holder.setOnItemClickListener(listener);
    }
    public void addItem(MyItem item){
        items.add(item);
    }
    public MyItem getItem(int position){
        return items.get(position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button button;
        OnItemClickListener listener;
        public ViewHolder(@NonNull final View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.nameText);
            button = itemView.findViewById(R.id.schoolSelectBtn);

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

        public void setItem(MyItem item){
            textView.setText(item.getName());
        }

        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }
    }
}
