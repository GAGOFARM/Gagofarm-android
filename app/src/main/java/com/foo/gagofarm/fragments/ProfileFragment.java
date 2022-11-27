package com.foo.gagofarm.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.foo.gagofarm.R;
import com.foo.gagofarm.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;

    public ProfileFragment() {
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    //onCreateView()메소드를 통해 프레그먼트가 보유줄 뷰가 만들어진 후 자동으로 실행되는 라이프사이클 콜백메소드
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ProfileUploadBtn.setOnClickListener(v -> Toast.makeText(getContext(), "upload", Toast.LENGTH_SHORT).show());
        binding.ProfileLogoutBtn.setOnClickListener(v -> Toast.makeText(getContext(), "logout", Toast.LENGTH_SHORT).show());
        binding.goBtn.setOnClickListener(v -> Toast.makeText(getContext(), "exchange", Toast.LENGTH_SHORT).show());
    }


}