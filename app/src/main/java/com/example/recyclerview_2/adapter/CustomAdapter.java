package com.example.recyclerview_2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_2.R;
import com.example.recyclerview_2.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NOT = 1;

    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        Member member = members.get(position);

        if (member.isAvailable()) {
            return TYPE_AVAILABLE_YES;
        }
        return TYPE_AVAILABLE_NOT;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_AVAILABLE_YES) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_yes,parent,false);
            return new CustomYesViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_not,parent,false);
        return new CustomNotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomYesViewHolder) {
            TextView firstName = ((CustomYesViewHolder) holder).firstName;
            TextView lastName = ((CustomYesViewHolder) holder).lastName;

            firstName.setText(member.getFirstName());
            lastName.setText(member.getLastName());
        }

        if (holder instanceof CustomNotViewHolder) {
            TextView firstname = ((CustomNotViewHolder) holder).firstName;
            TextView lastName = ((CustomNotViewHolder) holder).lastName;

            firstname.setText("This firstname is not available");
            lastName.setText("This lastname is not available");
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    // Holders here
    public static class CustomYesViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView firstName, lastName;

        public CustomYesViewHolder(View v) {
            super(v);
            view = v;

            // Add your UI components here
            firstName = view.findViewById(R.id.tv_firstName);
            lastName = view.findViewById(R.id.tv_lastName);
        }
    }

    public static class CustomNotViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView firstName, lastName;

        public CustomNotViewHolder(View v) {
            super(v);
            view = v;

            // Add your UI components here.
            firstName = view.findViewById(R.id.tv_firstName);
            lastName = view.findViewById(R.id.tv_lastName);
        }
    }
}
