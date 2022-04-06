package com.example.recyclerview_11.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.recyclerview_11.R;
import com.example.recyclerview_11.adapter.MainAdapter;
import com.example.recyclerview_11.model.Member;

import java.util.List;

public class MainActivity extends BaseActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        refreshAdapter(prepareMemberList());
    }

    public void openItemDetails(Member member) {
        Log.d("@@@"," item is clicked " + member.getFirstName());
        Intent intent = new Intent(this,DetailsActivity.class);
        startActivity(intent);
    }

    private void refreshAdapter(List<Member> members) {
        MainAdapter adapter = new MainAdapter(this,members);
        recyclerView.setAdapter(adapter);
    }
}