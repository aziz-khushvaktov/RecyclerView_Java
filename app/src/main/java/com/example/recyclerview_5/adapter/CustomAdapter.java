package com.example.recyclerview_5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_5.R;
import com.example.recyclerview_5.listener.OnBottomReachedListener;
import com.example.recyclerview_5.model.Member;
import com.example.recyclerview_5.model.MemberSub;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

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
        Member member = members.get(position);

        if (member.getMemberSubs() != null) return TYPE_ITEM_LIST;
        return TYPE_ITEM_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_LIST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_list,parent,false);
            return new CustomListHolder(view);
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (position == members.size()-1) {
            listener.onBottomReached(position);
        }

        if (holder instanceof CustomViewHolder) {}

        if (holder instanceof CustomListHolder) {
            RecyclerView recyclerView = ((CustomListHolder) holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));

            List<MemberSub> memberSubs = member.getMemberSubs();
            refreshAdapter(recyclerView,memberSubs);
        }

    }

    public void refreshAdapter(RecyclerView recyclerView, List<MemberSub> memberSubs) {
        CustomSubAdapter adapter = new CustomSubAdapter(context,memberSubs);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    // Holders here

    public static class CustomListHolder extends RecyclerView.ViewHolder {
        View view;
        RecyclerView recyclerView;

        public CustomListHolder(View v) {
            super(v);
            view = v;

            // UI components is here
            recyclerView = view.findViewById(R.id.recyclerView);
        }
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;

        public CustomViewHolder(View v) {
            super(v);
            view = v;

            // UI components is here
        }
    }
}
