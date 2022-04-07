package com.example.recyclerview_14.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_14.R;
import com.example.recyclerview_14.helper.ItemTouchHelperAdapter;
import com.example.recyclerview_14.model.Member;

import java.util.Collections;
import java.util.List;

/**
 * You have to implement ItemTouchHelperAdapter to Adapter of
 * recyclerView.
 */

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchHelperAdapter {

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
            TextView firstName = ((CustomViewHolder) holder).firstName;
            TextView lastName = ((CustomViewHolder) holder).lastName;

            firstName.setText(member.getFirstName());
            lastName.setText(member.getLastName());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    /**
     * We need to override two methods from SimpleItemTouchHelperCallBack that
     * were written to interface of ItemTouchHelper
     * These ones: onItemMove and onItemDismiss that we overrode from
     */
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(members,i,i+1);
            }
        }else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(members,i,i-1);
            }
        }
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        members.remove(position);
        notifyItemRemoved(position); // reprints the list
    }

    // Holder here

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView firstName, lastName;

        public CustomViewHolder(View v) {
            super(v);
            view = v;

            // Add your UI components here
            firstName = view.findViewById(R.id.tv_firstName);
            lastName = view.findViewById(R.id.tv_lastName);
        }
    }
}
