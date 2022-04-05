package com.example.recyclerview_4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_4.R;
import com.example.recyclerview_4.listener.OnBottomReachedListener;
import com.example.recyclerview_4.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NOT = 1;
    private static final int TYPE_ITEM_HEADER = 2;
    private static final int TYPE_ITEM_FOOTER = 3;

    public Context context;
    public List<Member> members;
    public OnBottomReachedListener listener;

    public CustomAdapter(Context context, List<Member> members, OnBottomReachedListener listener) {
        this.context = context;
        this.members = members;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) return TYPE_ITEM_HEADER;
        if (isFooter(position)) return TYPE_ITEM_FOOTER;

        Member member = members.get(position);

        if (member.isAvailable()) {
            return TYPE_AVAILABLE_YES;
        }
        return TYPE_AVAILABLE_NOT;

    }

    public boolean isHeader(int position) {
        return position == 0;
    }

    public boolean isFooter(int position) {
        return position == (members.size() -1);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This one for ITEM_CUSTOM_LAYOUT_YES
        if (viewType == TYPE_AVAILABLE_YES) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_yes,parent,false);
            return new CustomYesViewHolder(view);
        }else if (viewType == TYPE_ITEM_HEADER) { // This one for HEADER
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_header,parent,false);
            return new CustomHeaderViewHolder(view);
        }else if (viewType == TYPE_ITEM_FOOTER) { // This one for FOOTER
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_footer,parent,false);
            return new CustomFooterViewHolder(view);
        }

        // This one for ITEM_CUSTOM_LAYOUT_NOT
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_not,parent,false);
        return new CustomNotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == members.size()-1) {
            listener.onBottomReached(position);
        }

        if (isHeader(position) || isFooter(position)) return;

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

    // Header
    public static class CustomHeaderViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public CustomHeaderViewHolder(View v){
            super(v);
            view = v;

            // Add UI component here
        }
    }

    // Footer
    public static class CustomFooterViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public CustomFooterViewHolder(View v) {
            super(v);
            view = v;

            // Add UI component here
        }
    }
}
