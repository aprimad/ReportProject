package com.example.varun.reportproject2;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by varun on 6/27/16.
 */
public class CompleteAssessmentAdapter extends RecyclerView.Adapter<CompleteAssessmentAdapter.ViewHolder> {
        private ArrayList<Assessment> mDataset;
        private int[] mResID;
        public Context mContext;
        //int mode = 1;

        public static class ViewHolder extends RecyclerView.ViewHolder{
            public TextView titleLabel;
            public TextView subject;
            public TextView teacher;
            public TextView topic;
            public TextView type;
            public TextView level;
            public TextView assignedTo;
            public Button studentWiseDetail;
            public Button questionWiseDetail;
            public ViewHolder(View v){
                super(v);
                titleLabel = (TextView) v.findViewById(R.id.completeAssessmentTitle);
                subject = (TextView) v.findViewById(R.id.completeSubject);
                teacher = (TextView) v.findViewById(R.id.completeTeacher);
                topic = (TextView) v.findViewById(R.id.topic);
                type = (TextView) v.findViewById(R.id.type);
                level = (TextView) v.findViewById(R.id.level);
                assignedTo = (TextView) v.findViewById(R.id.assignedTo);
                studentWiseDetail = (Button) v.findViewById(R.id.completeAssessmentStudentWiseDetail);
                questionWiseDetail = (Button) v.findViewById(R.id.completeAssessmentQuestionWiseDetail);
            }
        }

        public CompleteAssessmentAdapter(Context context, ArrayList<Assessment> myDataset){
            mDataset = myDataset;
            mContext = context;
        }

        @Override
        public CompleteAssessmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.completeassessment_cardview,parent,false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //holder.stringName.setText(mDataset[position]);
            holder.titleLabel.setText(mDataset.get(position).assessmentTitle);
            holder.subject.setText(mDataset.get(position).subject);
            holder.teacher.setText(mDataset.get(position).teacher);
            holder.topic.setText(mDataset.get(position).topic);
            holder.type.setText(mDataset.get(position).type);
            holder.level.setText(mDataset.get(position).level);
            holder.assignedTo.setText(mDataset.get(position).assignedTo);
            holder.studentWiseDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragment = new AssessmentDetailFragment();
                    FragmentManager fragmentManager = ((MainActivity) mContext).getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("AssessmentDetailFragment").commit();
                }
            });
            holder.questionWiseDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragment = new AssessmentQuestionWiseFragment();
                    FragmentManager fragmentManager = ((MainActivity) mContext).getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("QuestionWiseAssessmentFragment").commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            Log.v("AssessmentAdapterTag ",String.valueOf(mDataset.size()));
            return mDataset.size();
        }


}
