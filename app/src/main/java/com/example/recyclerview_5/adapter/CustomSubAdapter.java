package com.example.recyclerview_5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_5.R;
import com.example.recyclerview_5.model.MemberSub;

import java.util.List;

public class CustomSubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<MemberSub> memberSubs;

    public CustomSubAdapter(Context context, List<MemberSub> memberSubs) {
        this.context = context;
        this.memberSubs = memberSubs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view_sub,parent,false);
        return new CustomSubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MemberSub memberSub = memberSubs.get(position);

        if (holder instanceof CustomSubViewHolder) {

        }
    }

    @Override
    public int getItemCount() {
        return memberSubs.size();
    }

    public static class CustomSubViewHolder extends RecyclerView.ViewHolder {
        View view;
        public CustomSubViewHolder(View v) {
            super(v);
            view = v;
        }
    }
}
