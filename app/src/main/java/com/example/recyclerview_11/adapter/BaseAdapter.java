package com.example.recyclerview_11.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_11.R;
import com.example.recyclerview_11.network.BaseServer;

public class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements BaseServer {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // Methods here

    protected String getServer() {
        if (IS_TESTER) {
            return SERVER_DEVELOPMENT;
        }
        return SERVER_DEPLOYMENT;
    }

    protected static boolean isEmpty(final String s) {
        // Nul-safe, short-circuit evaluation
        return s == null || s.trim().isEmpty();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView firstName, lastName;
        LinearLayout lay_click;

        public CustomViewHolder(View v) {
            super(v);
            view = v;

            // Add UI components here
            firstName = view.findViewById(R.id.tv_firstName);
            lastName = view.findViewById(R.id.tv_lastName);
            lay_click = view.findViewById(R.id.lay_click);
        }
    }
}
