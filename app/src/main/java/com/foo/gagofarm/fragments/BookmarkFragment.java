package com.foo.gagofarm.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.foo.gagofarm.R;
import com.foo.gagofarm.SearchRecyclerViewAdapter;
import com.foo.gagofarm.data.SearchViewItem;
import com.foo.gagofarm.databinding.FragmentBookmarkBinding;

import java.util.ArrayList;

public class BookmarkFragment extends Fragment {
    private SearchRecyclerViewAdapter mAdapter;
    private ArrayList<SearchViewItem> data ;
    private FragmentBookmarkBinding binding;

    public BookmarkFragment() {
    }
    public static BookmarkFragment newInstance(String param1, String param2) {
        BookmarkFragment fragment = new BookmarkFragment();
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
        binding = FragmentBookmarkBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new SearchRecyclerViewAdapter(getContext());
        makeDummyData();
        mAdapter.setList(data);

        binding.bookmarkRecyclerView.setAdapter(mAdapter);
        binding.bookmarkRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
    }


    private void makeDummyData(){
        data =  new ArrayList<>();
        data.add(new SearchViewItem("","title1","1~1","12",12,true));
        data.add(new SearchViewItem("","title1","1~1","12",12,true));
        data.add(new SearchViewItem("","title1","1~1","12",12,true));
        data.add(new SearchViewItem("","title1","1~1","12",12,true));
        data.add(new SearchViewItem("","title1","1~1","12",12,true));
        data.add(new SearchViewItem("","title1","1~1","12",12,true));
        data.add(new SearchViewItem("","title1","1~1","12",12,true));

    }
}