package com.foo.gagofarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.foo.gagofarm.databinding.ItemSliderBinding;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ViewHolder> {
    private Context context;
    private int[] images;

    public ImageSliderAdapter(Context context) {
        this.context = context;
    }
    public void setList(int [] _images){
        images = _images;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSliderBinding binding = ItemSliderBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ImageSliderAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int item = images[position];
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemSliderBinding binding;

        public ViewHolder(@NonNull ItemSliderBinding _binding) {
            super(_binding.getRoot());
           binding = _binding;
        }

        public void bind(int item) {
            binding.imageSlider.setImageResource(item);
        }
    }
}