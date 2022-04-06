package com.example.recyclerview_11.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview_11.R;
import com.example.recyclerview_11.adapter.DetailsAdapter;
import com.example.recyclerview_11.model.Member;

import java.util.List;

public class DetailsActivity extends BaseActivity {

    private DetailsActivity activity;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(activity,1));

        refreshAdapter(prepareMemberList2());
    }

    private void refreshAdapter(List<Member>members) {
        DetailsAdapter adapter = new DetailsAdapter(this,members);
        recyclerView.setAdapter(adapter);
    }

    public void backToMain(Member member) {
        finish();
    }

}