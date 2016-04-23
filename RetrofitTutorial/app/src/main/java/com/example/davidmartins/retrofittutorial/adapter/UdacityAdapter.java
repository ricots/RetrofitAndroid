package com.example.davidmartins.retrofittutorial.adapter;


import android.content.Context;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.davidmartins.retrofittutorial.R;
import com.example.davidmartins.retrofittutorial.models.Course;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by davidmartins on 21/04/16.
 */
public class UdacityAdapter extends RecyclerView.Adapter<UdacityAdapter.ViewHolder> {

    private List<Course> courses;

    public UdacityAdapter(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.titleCourseTextView.setText(course.title);
        holder.subtitleCourseTextView.setText(course.subtitle);
    }

    @Override
    public int getItemCount() {
        return courses.size() == 0 ? 0 : courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.course_title_textView)
        TextView titleCourseTextView;
        @Bind(R.id.course_subtitle_textView)
        TextView subtitleCourseTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
