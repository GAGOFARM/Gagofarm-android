package com.foo.gagofarm.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foo.gagofarm.MessageFragmentRecyclerViewAdapter;
import com.foo.gagofarm.data.MessageFragmentItem;
import com.foo.gagofarm.databinding.FragmentMessageBinding;

import java.util.ArrayList;

public class MessageFragment extends Fragment {
    private MessageFragmentRecyclerViewAdapter mAdapter;
    private ArrayList<MessageFragmentItem> data;
    private FragmentMessageBinding binding;

    public MessageFragment() {
    }
    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMessageBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new MessageFragmentRecyclerViewAdapter(getContext());
        makeDummyData();
        mAdapter.setList(data);

        binding.messageRecyclerView.setAdapter(mAdapter);
        binding.messageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
    }
    private void makeDummyData(){
        data =  new ArrayList<>();
        data.add(new MessageFragmentItem("","준익 농장 ","싸고 좋음","2022-11-11"));
        data.add(new MessageFragmentItem("","준익 농장 ","싸고 좋음","2022-11-11"));
        data.add(new MessageFragmentItem("","준익 농장 ","싸고 좋음","2022-11-11"));
        data.add(new MessageFragmentItem("","준익 농장 ","싸고 좋음","2022-11-11"));
        data.add(new MessageFragmentItem("","준익 농장 ","싸고 좋음","2022-11-11"));
        data.add(new MessageFragmentItem("","준익 농장 ","싸고 좋음","2022-11-11"));
        data.add(new MessageFragmentItem("","준익 농장 ","싸고 좋음","2022-11-11"));


    }
}