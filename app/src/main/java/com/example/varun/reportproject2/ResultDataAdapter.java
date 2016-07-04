package com.example.varun.reportproject2;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

/**
 * Created by varun on 6/21/16.
 */
public class ResultDataAdapter extends RecyclerView.Adapter<ResultDataAdapter.ViewHolder> {

    private ArrayList<Student> mDataset;
    private int[] mResID;
    public Context mContext;
    //int mode = 1;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView studentName;
        public TextView className;
        public TextView timeSpent;
        public TextView assessmentCount;
        public CardView cardView;
        public ViewHolder(View v){
            super(v);
            studentName = (TextView) v.findViewById(R.id.studentName);
            className = (TextView) v.findViewById(R.id.classLevel);
            timeSpent = (TextView) v.findViewById(R.id.timeSpent);
            assessmentCount = (TextView) v.findViewById(R.id.assessmentCount);
            cardView = (CardView) v.findViewById(R.id.resultCardView);
        }
    }

    public ResultDataAdapter(Context context, ArrayList<Student> myDataset){
        mDataset = myDataset;
        mContext = context;
    }

    public ResultDataAdapter(Context context, int[] myResID){
        mResID = myResID;
        mContext = context;
        //mode = 2;
    }

    @Override
    public ResultDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_cardview,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.stringName.setText(mDataset[position]);
        holder.studentName.setText(mDataset.get(position).userName);
        holder.className.setText(mDataset.get(position).levelName);
        if(mDataset.get(position).loginDuration.matches("")) {
            holder.timeSpent.setText("0");
        } else holder.timeSpent.setText(mDataset.get(position).loginDuration);
        if(mDataset.get(position).assessmentCount.matches("")){
            holder.assessmentCount.setText("0");
        } else holder.assessmentCount.setText(mDataset.get(position).assessmentCount);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new StudentAssessmentFragment();
                FragmentManager fragmentManager = ((MainActivity) mContext).getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("AssessmentFragment").commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
