package com.example.recyclerview_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_1.R;
import com.example.recyclerview_1.model.Member;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
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
            TextView firsName = ((CustomViewHolder) holder).first_name;
            TextView lastName = ((CustomViewHolder) holder).last_name;

            firsName.setText(member.getFirstName());
            lastName.setText(member.getLastName());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    // Holders here
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView first_name, last_name;

        public CustomViewHolder(View v) {
            super(v);
            view = v;

            first_name = view.findViewById(R.id.tv_firstName);
            last_name = view.findViewById(R.id.tv_lastName);
        }

    }
}
