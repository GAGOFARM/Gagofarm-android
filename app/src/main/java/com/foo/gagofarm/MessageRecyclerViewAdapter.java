package com.foo.gagofarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import com.foo.gagofarm.data.MessageItem;
import com.foo.gagofarm.databinding.ActivityMessageItemBinding;
import com.foo.gagofarm.databinding.MessageFragmentRecyclerviewItemBinding;

public class MessageRecyclerViewAdapter extends RecyclerView.Adapter<MessageRecyclerViewAdapter.ViewHolder> {
    private ArrayList<MessageItem> data;
    private Context mContext;

    public MessageRecyclerViewAdapter(Context context){
        this.mContext = context;
    }
    public void setData(ArrayList<MessageItem> _data){
        this.data = _data;
    }

    @NonNull
    @Override
    public MessageRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ActivityMessageItemBinding binding = ActivityMessageItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MessageRecyclerViewAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageRecyclerViewAdapter.ViewHolder holder, int position) {
        MessageItem item = data.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ActivityMessageItemBinding binding;
        public ViewHolder(@NonNull ActivityMessageItemBinding _binding) {
            super(_binding.getRoot());
            binding = _binding;
        }

        public void bind(MessageItem item) {
            if (item.isSender()) {
                binding.profileImage.setVisibility(View.VISIBLE);
                binding.senderTitle.setVisibility(View.VISIBLE);

                binding.profileImage.setImageResource(R.drawable.imageIcon);
                binding.senderTitle.setText(item.getTitle());
                binding.MessageContent.setText(item.getContent());
                binding.messageTime.setText(item.getTime());
            } else {
                binding.profileImage.setVisibility(View.GONE);
                binding.senderTitle.setVisibility(View.GONE);

                binding.MessageContent.setText(item.getContent());
                binding.messageTime.setText(item.getTime());

            }
        }
    }
}
