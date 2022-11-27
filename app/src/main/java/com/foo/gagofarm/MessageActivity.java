package com.foo.gagofarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.foo.gagofarm.data.MessageFragmentItem;
import com.foo.gagofarm.data.MessageItem;
import com.foo.gagofarm.databinding.ActivityMessageBinding;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {
    MessageRecyclerViewAdapter mAdapter;
    private ArrayList<MessageItem> data;
    private ActivityMessageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar5);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdapter = new MessageRecyclerViewAdapter(this);
        makeDummyData();
        mAdapter.setData(data);

        binding.messageContentRecyclerView.setAdapter(mAdapter);
        binding.messageContentRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
    }

    private void makeDummyData(){
        data =  new ArrayList<>();
        data.add(new MessageItem("","준익 농장 ","싸고 좋음","10:10",false));
        data.add(new MessageItem("","준익 농장 ","ㅎㅇㅎㅇ","10:9",true));


    }
}