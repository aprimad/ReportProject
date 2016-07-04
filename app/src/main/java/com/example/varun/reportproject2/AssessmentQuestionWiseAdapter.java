package com.example.varun.reportproject2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;

/**
 * Created by varun on 6/29/16.
 */
public class AssessmentQuestionWiseAdapter extends RecyclerView.Adapter<AssessmentQuestionWiseAdapter.ViewHolder>{
        private ArrayList<QuestionWiseAssessment> mDataset;
        private int[] mResID;
        public Context mContext;
        //int mode = 1;

        public static class ViewHolder extends RecyclerView.ViewHolder{
            public TextView questionNumber;
            public DonutProgress percentageCorrect;
            public TextView questionsChosen;
            public ViewHolder(View v){
                super(v);
                questionNumber = (TextView) v.findViewById(R.id.assessmentQuestionWiseQuestionNumber);
                percentageCorrect = (DonutProgress) v.findViewById(R.id.assessmentQuestionWisePercentageCorrect);
                questionsChosen = (TextView) v.findViewById(R.id.assessmentQuestionWiseQuestionsChosen);
            }
        }

        public AssessmentQuestionWiseAdapter(Context context, ArrayList<QuestionWiseAssessment> myDataset){
            mDataset = myDataset;
            mContext = context;
        }

        @Override
        public AssessmentQuestionWiseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.assessmentquestionwise_cardview,parent,false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //holder.stringName.setText(mDataset[position]);
            holder.questionNumber.setText(mDataset.get(position).questionNumber);
            holder.percentageCorrect.setProgress(Integer.valueOf(mDataset.get(position).percentageCorrect));
            holder.questionsChosen.setText(mDataset.get(position).questionsChosen);
        }

        @Override
        public int getItemCount() {
            Log.v("AssessmentAdapterTag ",String.valueOf(mDataset.size()));
            return mDataset.size();
        }


}
