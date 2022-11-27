package com.foo.gagofarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import com.foo.gagofarm.data.MessageFragmentItem;
import com.foo.gagofarm.databinding.MessageFragmentRecyclerviewItemBinding;

public class MessageFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MessageFragmentRecyclerViewAdapter.ViewHolder> {
    private ArrayList<MessageFragmentItem> data;
    private Context mContext;


    public MessageFragmentRecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<MessageFragmentItem> _data) {
        this.data = _data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MessageFragmentRecyclerviewItemBinding binding = MessageFragmentRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageFragmentItem item = data.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setList(ArrayList<MessageFragmentItem> _data)
    {
        data = _data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MessageFragmentRecyclerviewItemBinding binding;
        public ViewHolder(@NonNull MessageFragmentRecyclerviewItemBinding _binding) {
            super(_binding.getRoot());
            binding = _binding;
        }

        public void bind(MessageFragmentItem item) {
            binding.circleIv.setImageDrawable(null /*item.getImage()*/);
            binding.messageTitleTextView.setText(item.getTitle());
            binding.messageContentTextView.setText(item.getContent());
            binding.messageDateTextView.setText(item.getDate());
            binding.imageView3.setImageResource(R.drawable.underline);
        }
    }
}

