package com.example.varun.reportproject2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by varun on 6/28/16.
 */
public class AssessmentStudentListFragment extends Fragment{
        public RecyclerView.LayoutManager mLayoutManager;
        public RecyclerView mRecyclerView;
        public AssessmentStudentListAdapter mAdpater;
        public AssessmentStudentListAccessedAdapter mAdpater2;
        public static ArrayList<AssessmentSubmission> studentList = new ArrayList<AssessmentSubmission>();
    public static ArrayList<AssessmentSubmission> accessedList = new ArrayList<AssessmentSubmission>();
    public static ArrayList<AssessmentSubmission> submittedList = new ArrayList<AssessmentSubmission>();
    public static ArrayList<AssessmentSubmission> notAccessedList = new ArrayList<AssessmentSubmission>();
    public static int opMode;
        public static int studentPercentageRange;

        public AssessmentStudentListFragment(){

        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragmentassessmentstudentlist, container, false);
            /*if(studentPercentageRange == 0){
                studentList.clear();
                studentList = AssessmentDetailFragment.A1ArrayList;
                Log.v("A1SizeinList",String.valueOf(AssessmentDetailFragment.A1ArrayList.size()));
            }
            else if(studentPercentageRange ==1){
                studentList.clear();
                studentList = AssessmentDetailFragment.A2ArrayList;
            }
            else if(studentPercentageRange ==2){
                studentList.clear();
                studentList = AssessmentDetailFragment.B1ArrayList;
            }
            else if(studentPercentageRange ==3){
                studentList.clear();
                studentList = AssessmentDetailFragment.B2ArrayList;
            }
            else if(studentPercentageRange ==4){
                studentList.clear();
                studentList = AssessmentDetailFragment.C1ArrayList;
            }
            else if(studentPercentageRange ==5){
                studentList.clear();
                studentList = AssessmentDetailFragment.C2ArrayList;
            }
            else if(studentPercentageRange ==6){
                studentList.clear();
                studentList = AssessmentDetailFragment.DArrayList;
            } */
            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_assessment_student_recycler_view);
            mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
            if(opMode==0) {
                mAdpater = new AssessmentStudentListAdapter(getActivity(), studentList);
                mRecyclerView.setAdapter(mAdpater);
            }else if(opMode==1) {
                mAdpater2 = new AssessmentStudentListAccessedAdapter(getActivity(), accessedList);
                mRecyclerView.setAdapter(mAdpater2);
            }else if(opMode==2) {
                mAdpater = new AssessmentStudentListAdapter(getActivity(), submittedList);
                mRecyclerView.setAdapter(mAdpater);
            }else if(opMode==3) {
                mAdpater2 = new AssessmentStudentListAccessedAdapter(getActivity(), notAccessedList);
                mRecyclerView.setAdapter(mAdpater2);
            }
            return rootView;
            //return super.onCreateView(inflater, container, savedInstanceState);
        }

        public static AssessmentStudentListFragment newInstance(int mode, ArrayList<AssessmentSubmission> assessmentSubmissions){
            AssessmentStudentListFragment assessmentStudentListFragment = new AssessmentStudentListFragment();
            if(mode==0) {
                studentList = assessmentSubmissions;
            } else if(mode==1){
                accessedList = assessmentSubmissions;
            } else if(mode==2) {
                submittedList = assessmentSubmissions;
            } else if(mode==3) {
                notAccessedList = assessmentSubmissions;
            }
            opMode = mode;
            Log.v("StudentListSize",String.valueOf(studentList.size()));
            //studentPercentageRange = range;
            return assessmentStudentListFragment;
        }

}
