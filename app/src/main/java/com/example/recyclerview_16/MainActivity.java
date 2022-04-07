package com.example.recyclerview_16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.recyclerview_16.adapter.CustomAdapter;
import com.example.recyclerview_16.helper.SpaceItemDecoration;
import com.example.recyclerview_16.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


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
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        SpaceItemDecoration decoration = new SpaceItemDecoration(10);
        recyclerView.addItemDecoration(decoration);

//        asPager();

        refreshAdapter(prepareMemberList());
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            members.add(new Member(R.drawable.im_gamer));
        }
        return members;
    }

    private void asPager() {
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int activePosition = layoutManager.findFirstVisibleItemPosition();
                if (activePosition == RecyclerView.NO_POSITION) return;
                Log.d("@@@","Active position " + activePosition);
            }
        });

    }


}