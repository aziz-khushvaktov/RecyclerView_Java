package com.example.recyclerview_16.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_16.R;
import com.example.recyclerview_16.model.Member;

import java.util.Collections;
import java.util.List;


/**
 * You have to implement ItemTouchHelperAdapter to Adapter of
 * recyclerView.
 */

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

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
            if (position % 3 == 0) {
                ((CustomViewHolder) holder).profile.setImageResource(R.drawable.background_1);
            }else if (position % 4 == 0) {
                ((CustomViewHolder) holder).profile.setImageResource(R.drawable.im_camera_4);
            }else {
                ((CustomViewHolder) holder).profile.setImageResource(R.drawable.youtube_2);
            }

        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }


    // Holder here

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView profile;

        public CustomViewHolder(View v) {
            super(v);
            view = v;

            // Add your UI components here
            profile = view.findViewById(R.id.iv_profile);
        }
    }
}
