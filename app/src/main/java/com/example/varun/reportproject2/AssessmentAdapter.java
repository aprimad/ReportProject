package com.example.varun.reportproject2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by varun on 6/24/16.
 */
public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.ViewHolder> {
    private ArrayList<Assessment> mDataset;
    private int[] mResID;
    public Context mContext;
    //int mode = 1;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView titleLabel;
        public TextView subject;
        public TextView teacher;
        public TextView issuedDate;
        public TextView dueDate;
        public TextView submittedDate;
        public TextView mark;
        public ViewHolder(View v){
            super(v);
            titleLabel = (TextView) v.findViewById(R.id.assessmentTitle);
            subject = (TextView) v.findViewById(R.id.subject);
            teacher = (TextView) v.findViewById(R.id.teacher);
            issuedDate = (TextView) v.findViewById(R.id.issuedDate);
            dueDate = (TextView) v.findViewById(R.id.dueDate);
            submittedDate = (TextView) v.findViewById(R.id.submittedDate);
            mark = (TextView) v.findViewById(R.id.mark);
        }
    }

    public AssessmentAdapter(Context context, ArrayList<Assessment> myDataset){
        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public AssessmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.assessment_cardview,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.stringName.setText(mDataset[position]);
        holder.titleLabel.setText(mDataset.get(position).assessmentTitle);
        holder.subject.setText(mDataset.get(position).subject);
        holder.teacher.setText(mDataset.get(position).teacher);
        holder.issuedDate.setText(mDataset.get(position).issuedDate);
        holder.dueDate.setText(mDataset.get(position).dueDate);
        holder.submittedDate.setText(mDataset.get(position).submittedDate);
        if(mDataset.get(position).marks.matches("-")) {
            holder.mark.setText(mDataset.get(position).marks);
        } else {
            holder.mark.setText(mDataset.get(position).marks+"/"+mDataset.get(position).questionCount);
        }
    }

    @Override
    public int getItemCount() {
        Log.v("AssessmentAdapterTag ",String.valueOf(mDataset.size()));
        return mDataset.size();
    }
}
