package com.example.davidmartins.retrofittutorial.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.davidmartins.retrofittutorial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by davidmartins on 21/04/16.
 */
public class UdacityAdapter extends RecyclerView.Adapter<UdacityAdapter.ViewHolder> {

    public UdacityAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.course_textView)
        TextView courserTextView;
        @Bind(R.id.teacher_textView)
        TextView teacherTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
