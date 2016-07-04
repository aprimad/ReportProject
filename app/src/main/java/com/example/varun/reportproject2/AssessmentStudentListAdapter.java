package com.example.varun.reportproject2;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;

/**
 * Created by varun on 6/28/16.
 */
public class AssessmentStudentListAdapter extends RecyclerView.Adapter<AssessmentStudentListAdapter.ViewHolder> {
        private ArrayList<AssessmentSubmission> mDataset;
        private int[] mResID;
        public Context mContext;

        public static class ViewHolder extends RecyclerView.ViewHolder{
            public TextView studentName;
            public DonutProgress percent;
            public CardView cardView;
            public ViewHolder(View v){
                super(v);
                studentName = (TextView) v.findViewById(R.id.assessmentStudentListStudentName);
                percent = (DonutProgress) v.findViewById(R.id.assessmentStudentListStudentPercent);
                cardView = (CardView) v.findViewById(R.id.assessmentStudentListCardView);
            }
        }

        public AssessmentStudentListAdapter(Context context, ArrayList<AssessmentSubmission> myDataset){
            mDataset = myDataset;
            mContext = context;
        }

        @Override
        public AssessmentStudentListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.assessmentstudentlist_cardview,parent,false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            //holder.stringName.setText(mDataset[position]);
            holder.studentName.setText(mDataset.get(position).userName);
            holder.percent.setProgress(Integer.valueOf(mDataset.get(position).percentage));
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(AssessmentStudentListFragment.opMode==0){
                        Fragment fragment = AssessmentStudentDetailFragment.newInstance(AssessmentStudentListFragment.studentList.get(position));
                        FragmentManager fragmentManager = ((MainActivity) mContext).getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("AssessmentStudentDetailFragment").commit();
                    } else if(AssessmentStudentListFragment.opMode==2) {
                        Fragment fragment = AssessmentStudentDetailFragment.newInstance(AssessmentStudentListFragment.submittedList.get(position));
                        FragmentManager fragmentManager = ((MainActivity) mContext).getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("AssessmentStudentDetailFragment").commit();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            Log.v("StudentListAdapterTag ",String.valueOf(mDataset.size()));
            return mDataset.size();
        }


}
