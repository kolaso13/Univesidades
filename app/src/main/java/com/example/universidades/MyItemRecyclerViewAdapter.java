package com.example.universidades;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.universidades.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.universidades.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Universidad> mValues;

    public MyItemRecyclerViewAdapter(List<Universidad> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Button btn = null;
        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), btn);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getNombre());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mIdView;
        public final Button btn;
        public Universidad mItem;

        public ViewHolder(FragmentItemBinding binding, Button btn) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            this.btn = binding.btnLink;
        }

        @Override
        public String toString() {
            return super.toString() + " '" ;
        }

        @Override
        public void onClick(View view) {
            
        }
    }
}