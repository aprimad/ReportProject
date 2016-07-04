package com.example.varun.reportproject2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by varun on 6/28/16.
 */
public class AssessmentStudentDetailFragment extends Fragment{

        public static AssessmentSubmission studentSubmission;
        public static int positionStudentList;
        public static int studentPercentageRange;

        public AssessmentStudentDetailFragment(){

        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragmentassessmentstudentdetail, container, false);
            //if(AssessmentStudentListFragment.studentList.isEmpty()==true) {
            //} else {
            /*
            if(studentPercentageRange == 0){
                studentSubmission = AssessmentDetailFragment.A1ArrayList.get(positionStudentList);
            }
            else if(studentPercentageRange ==1){
                studentSubmission = AssessmentDetailFragment.A1ArrayList.get(positionStudentList);
            }
            else if(studentPercentageRange ==2){
                studentSubmission = AssessmentDetailFragment.A1ArrayList.get(positionStudentList);
            }
            else if(studentPercentageRange ==3){
                studentSubmission = AssessmentDetailFragment.A1ArrayList.get(positionStudentList);
            }
            else if(studentPercentageRange ==4){
                studentSubmission = AssessmentDetailFragment.A1ArrayList.get(positionStudentList);
            }
            else if(studentPercentageRange ==5){
                studentSubmission = AssessmentDetailFragment.A1ArrayList.get(positionStudentList);
            }
            else if(studentPercentageRange ==6){
                studentSubmission = AssessmentDetailFragment.A1ArrayList.get(positionStudentList);
            } */

                TextView textView = (TextView) rootView.findViewById(R.id.assessmentStudentDetailStudentName);
                textView.setText(studentSubmission.userName);
                textView = (TextView) rootView.findViewById(R.id.assessmentStudentDetailPercent);
                textView.setText(studentSubmission.percentage);
                textView = (TextView) rootView.findViewById(R.id.assessmentStudentDetailScore);
                textView.setText(studentSubmission.score);
                textView = (TextView) rootView.findViewById(R.id.assessmentStudentDetailLevel);
                textView.setText(studentSubmission.level);
                textView = (TextView) rootView.findViewById(R.id.assessmentStudentDetailCurrentQuestionNo);
                textView.setText(studentSubmission.currentQNumber);
                textView = (TextView) rootView.findViewById(R.id.assessmentStudentDetailCurrentQuestionID);
                textView.setText(studentSubmission.currentQID);
                textView = (TextView) rootView.findViewById(R.id.assessmentStudentDetailCurrentAttempt);
                textView.setText(studentSubmission.currentAttempt);
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();

            PieChart pieChart = (PieChart) rootView.findViewById(R.id.assessmentStudentDetailPieChart);
            ArrayList<Entry> entries = new ArrayList<>();
            ArrayList<String> labels = new ArrayList<String>();
            int flag = 0;
            if((studentSubmission.correctQuestions.matches("-"))||(studentSubmission.correctQuestions.matches(""))||(studentSubmission.correctQuestions.matches("0"))){
            }else {
                labels.add("Correct");
                entries.add(new Entry(Integer.valueOf(studentSubmission.correctQuestions),0));
                flag = 1;
            }
            if((studentSubmission.wrongQuestionNumber.matches("-"))||(studentSubmission.wrongQuestionNumber.matches(""))||(studentSubmission.wrongQuestionNumber.matches("0"))){

            }else{
                labels.add("Incorrect");
                entries.add(new Entry(Integer.valueOf(studentSubmission.wrongQuestionNumber),1));
                flag = 1;
            }
            if((studentSubmission.notAttemptedQuestionNumber.matches("-"))||(studentSubmission.notAttemptedQuestionNumber.matches(""))||(studentSubmission.notAttemptedQuestionNumber.matches("0"))){

            }else{
                labels.add("Not Attempted");
                entries.add(new Entry(Integer.valueOf(studentSubmission.notAttemptedQuestionNumber),2));
                flag = 1;
            }
            /*entries.add(new Entry(4,0));
            entries.add(new Entry(1,1));
            entries.add(new Entry(0,2));
            labels.add("Correct");
            labels.add("Incorrect");
            labels.add("Not Attempted"); */
            if(flag==0) pieChart.setVisibility(View.INVISIBLE);
            PieDataSet pieDataSet = new PieDataSet(entries,"Questions");
            PieData pieData = new PieData(labels,pieDataSet);
            pieChart.setData(pieData);
            pieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
            pieDataSet.setValueTextSize(MainActivity.size);    //fontsize
            pieChart.animateY(5000);

            rootView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if(i == KeyEvent.KEYCODE_BACK){
                        Fragment fragment = new CompleteAssessmentFragment();
                        //Fragment fragment1 = AssessmentStudentListFragment.newInstance(studentPercentageRange);
                        //FragmentManager fragmentManager = getFragmentManager();
                        //fragmentManager.beginTransaction().remove(fragment1);
                        //fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit();
                    }
                    return false;
                }
            });
            return rootView;
            //return super.onCreateView(inflater, container, savedInstanceState);
        }

        public static AssessmentStudentDetailFragment newInstance(AssessmentSubmission assessmentSubmission){
            AssessmentStudentDetailFragment assessmentStudentDetailFragment = new AssessmentStudentDetailFragment();
            studentSubmission = assessmentSubmission;
            //positionStudentList = position;
            //studentPercentageRange = range;
            return assessmentStudentDetailFragment;
        }



}
