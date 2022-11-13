package com.foo.gagofarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import com.foo.gagofarm.data.MessageViewItem;
import com.foo.gagofarm.databinding.MessageRecyclerviewItemBinding;

public class MessageRecyclerViewAdapter  extends RecyclerView.Adapter<MessageRecyclerViewAdapter.ViewHolder> {
    private ArrayList<MessageViewItem> data;
    private Context mContext;


    public MessageRecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<MessageViewItem> _data) {
        this.data = _data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MessageRecyclerviewItemBinding binding = MessageRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageViewItem item = data.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MessageRecyclerviewItemBinding binding;
        public ViewHolder(@NonNull MessageRecyclerviewItemBinding _binding) {
            super(_binding.getRoot());
            binding = _binding;
        }

        public void bind(MessageViewItem item) {
            binding.circleIv.setImageDrawable(null /*item.getImage()*/);
            binding.messageTitleTextView.setText(item.getTitle());
            binding.messageContentTextView.setText(item.getContent());
            binding.messageContentTextView.setText(item.getContent());
            binding.messageDateTextView.setText(item.getDate());
            binding.messageRegionTextView.setText(item.getRegion());
        }
    }
}

