package com.example.recyclerview_11.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.recyclerview_11.R;
import com.example.recyclerview_11.model.Member;
import com.example.recyclerview_11.network.BaseServer;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements BaseServer {

    protected String getServer() {
        if (IS_TESTER) {
            return SERVER_DEVELOPMENT;
        }
        return SERVER_DEPLOYMENT;
    }

    protected List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 31; i++) {
            members.add(new Member("Tojiyev " + i,"Shakriyor " + i));
        }
        return members;
    }

    protected List<Member> prepareMemberList2() {
        List<Member> members = new ArrayList<>();

        for (int i = 30; i < 50; i++) {
            members.add(new Member("Sherzod " + i, "Murodov " + i));
        }

        return members;
    }

    protected static boolean isEmpty(final String s) {
        // Nul-safe, short-circuit evaluation
        return s == null || s.trim().isEmpty();
    }

}