package com.example.recyclerview_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerview_3.adapter.CustomAdapter;
import com.example.recyclerview_3.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Context context;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));

        refreshAdapter(prepareMemberList());
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        members.add(new Member()); // For HEADER

        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 5 || i == 16 || i == 25) {
                members.add(new Member("Azizbek " + i, "Khushvaktov " + i, false));
            } else {
                members.add(new Member("Azizbek " + i, "Khushvaktov " + i, true));
            }
        }

        members.add(new Member()); // For FOOTER
        return members;
    }
}