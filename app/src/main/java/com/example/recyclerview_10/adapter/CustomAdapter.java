package com.example.recyclerview_10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_10.MainActivity;
import com.example.recyclerview_10.R;
import com.example.recyclerview_10.model.Member;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MainActivity activity;
    private List<Member> members;

    public CustomAdapter(MainActivity activity, List<Member> members) {
        this.activity = activity;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);

        if (holder instanceof CustomViewHolder) {
            TextView firstName = ((CustomViewHolder) holder).firstName;
            TextView lastName = ((CustomViewHolder) holder).lastName;
            LinearLayout lay_click = ((CustomViewHolder) holder).lay_click;

            firstName.setText(member.getFirstName());
            lastName.setText(member.getLastName());
            lay_click.setOnClickListener((v) -> {
                activity.openItemDetails(member);
            });
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView firstName, lastName;
        LinearLayout lay_click;

        public CustomViewHolder(View v) {
            super(v);
            view = v;

            // Add your UI components here
            firstName = view.findViewById(R.id.tv_firstName);
            lastName = view.findViewById(R.id.tv_lastName);
            lay_click = view.findViewById(R.id.lay_click);
        }
    }
}
