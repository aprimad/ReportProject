package com.example.varun.reportproject2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by varun on 6/29/16.
 */
public class AssessmentQuestionWiseFragment extends Fragment{
        public RecyclerView.LayoutManager mLayoutManager;
        public RecyclerView mRecyclerView;
        public AssessmentQuestionWiseAdapter mAdpater;
        public ArrayList<QuestionWiseAssessment> assessmentQuestionList = new ArrayList<QuestionWiseAssessment>();
        String jsonData;
        String jsonData1;
        String totalAccess;
        String totalStudent;
        String totalSubmit;
        public AssessmentQuestionWiseFragment(){

        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //String JSONAssessmentData = "\"{\\\"Info\\\":\\\"[{\\\\\\\"questionNumber\\\\\\\":1,\\\\\\\"percentageCorrect\\\\\\\":0,\\\\\\\"percentageWrong\\\\\\\":100,\\\\\\\"attemptsToCorrect\\\\\\\":1,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"testId\\\\\\\":688},{\\\\\\\"questionNumber\\\\\\\":2,\\\\\\\"percentageCorrect\\\\\\\":100,\\\\\\\"percentageWrong\\\\\\\":0,\\\\\\\"attemptsToCorrect\\\\\\\":1,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"testId\\\\\\\":688},{\\\\\\\"questionNumber\\\\\\\":3,\\\\\\\"percentageCorrect\\\\\\\":0,\\\\\\\"percentageWrong\\\\\\\":100,\\\\\\\"attemptsToCorrect\\\\\\\":1,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"testId\\\\\\\":688},{\\\\\\\"questionNumber\\\\\\\":4,\\\\\\\"percentageCorrect\\\\\\\":0,\\\\\\\"percentageWrong\\\\\\\":100,\\\\\\\"attemptsToCorrect\\\\\\\":1,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"testId\\\\\\\":688},{\\\\\\\"questionNumber\\\\\\\":5,\\\\\\\"percentageCorrect\\\\\\\":0,\\\\\\\"percentageWrong\\\\\\\":100,\\\\\\\"attemptsToCorrect\\\\\\\":1,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"testId\\\\\\\":688},{\\\\\\\"questionNumber\\\\\\\":6,\\\\\\\"percentageCorrect\\\\\\\":0,\\\\\\\"percentageWrong\\\\\\\":100,\\\\\\\"attemptsToCorrect\\\\\\\":1,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"testId\\\\\\\":688},{\\\\\\\"questionNumber\\\\\\\":7,\\\\\\\"percentageCorrect\\\\\\\":0,\\\\\\\"percentageWrong\\\\\\\":100,\\\\\\\"attemptsToCorrect\\\\\\\":1,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"testId\\\\\\\":688},{\\\\\\\"questionNumber\\\\\\\":8,\\\\\\\"percentageCorrect\\\\\\\":0,\\\\\\\"percentageWrong\\\\\\\":100,\\\\\\\"attemptsToCorrect\\\\\\\":1,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"testId\\\\\\\":688}]\\\",\\\"userAccess\\\":\\\"{\\\\\\\"totalAccess\\\\\\\":1,\\\\\\\"totalStudent\\\\\\\":2,\\\\\\\"totalSubmit\\\\\\\":1}\\\"}\"";
            String JSONAssessmentData = "\"{\\\"Info\\\":\\\"[{\\\\\\\"questionNumber\\\\\\\":1,\\\\\\\"percentageCorrect\\\\\\\":96,\\\\\\\"percentageWrong\\\\\\\":4,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":2,\\\\\\\"percentageCorrect\\\\\\\":50,\\\\\\\"percentageWrong\\\\\\\":50,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":3,\\\\\\\"percentageCorrect\\\\\\\":86,\\\\\\\"percentageWrong\\\\\\\":14,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":4,\\\\\\\"percentageCorrect\\\\\\\":86,\\\\\\\"percentageWrong\\\\\\\":14,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":5,\\\\\\\"percentageCorrect\\\\\\\":69,\\\\\\\"percentageWrong\\\\\\\":31,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"3\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":6,\\\\\\\"percentageCorrect\\\\\\\":43,\\\\\\\"percentageWrong\\\\\\\":57,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":7,\\\\\\\"percentageCorrect\\\\\\\":86,\\\\\\\"percentageWrong\\\\\\\":14,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":8,\\\\\\\"percentageCorrect\\\\\\\":93,\\\\\\\"percentageWrong\\\\\\\":7,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":9,\\\\\\\"percentageCorrect\\\\\\\":64,\\\\\\\"percentageWrong\\\\\\\":36,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":10,\\\\\\\"percentageCorrect\\\\\\\":64,\\\\\\\"percentageWrong\\\\\\\":36,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":11,\\\\\\\"percentageCorrect\\\\\\\":50,\\\\\\\"percentageWrong\\\\\\\":50,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":12,\\\\\\\"percentageCorrect\\\\\\\":86,\\\\\\\"percentageWrong\\\\\\\":14,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":13,\\\\\\\"percentageCorrect\\\\\\\":50,\\\\\\\"percentageWrong\\\\\\\":50,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":14,\\\\\\\"percentageCorrect\\\\\\\":100,\\\\\\\"percentageWrong\\\\\\\":0,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481},{\\\\\\\"questionNumber\\\\\\\":15,\\\\\\\"percentageCorrect\\\\\\\":46,\\\\\\\"percentageWrong\\\\\\\":54,\\\\\\\"percentUnattempted\\\\\\\":0,\\\\\\\"questionsChosen\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"userQuestCount\\\\\\\":14,\\\\\\\"testId\\\\\\\":1481}]\\\",\\\"userAccess\\\":\\\"{\\\\\\\"totalAccess\\\\\\\":19,\\\\\\\"totalStudent\\\\\\\":27,\\\\\\\"totalSubmit\\\\\\\":14}\\\"}\"";

            Gson gson = new Gson();
            JSONAssessmentData = gson.fromJson(JSONAssessmentData,String.class);
            String JSONAssessmentData1 = JSONAssessmentData;
            try {
                JSONObject jsonAssessmentObject = new JSONObject(JSONAssessmentData);
                Log.v("AssessmentTag0 ",jsonAssessmentObject.toString());
                JSONArray jsonAssessmentArray = new JSONArray();
                jsonAssessmentArray = jsonAssessmentObject.getJSONArray("Info");
                Log.v("AssessmentTag1 ",jsonAssessmentArray.toString());
            }catch (JSONException Ex) {
                Log.e("AssessmentTag2 ", Ex.toString());
                JSONAssessmentData = Ex.toString();
                JSONAssessmentData = JSONAssessmentData.substring(30,JSONAssessmentData.length()-66);
                JSONAssessmentData = "{\"array\":"+ JSONAssessmentData + "}";
                jsonData = JSONAssessmentData;
                //JSONAssesmentData = gson.fromJson(JSONAssesmentData,String.class);
                Log.v("AssessmentTag3 ",JSONAssessmentData);
            }
            try {
                JSONObject jsonAssessmentObject = new JSONObject(JSONAssessmentData1);
                Log.v("AssessmentTag0 ",jsonAssessmentObject.toString());
                JSONArray jsonAssessmentArray = new JSONArray();
                jsonAssessmentArray = jsonAssessmentObject.getJSONArray("userAccess");
                Log.v("AssessmentTag1 ",jsonAssessmentArray.toString());
            }catch (JSONException Ex) {
                Log.e("AssessmentTag2 ", Ex.toString());
                JSONAssessmentData1 = Ex.toString();
                JSONAssessmentData1 = JSONAssessmentData1.substring(30,JSONAssessmentData1.length()-72);
                JSONAssessmentData1 = "{\"array\":["+ JSONAssessmentData1 + "]}";
                jsonData1 = JSONAssessmentData1;
                //JSONAssesmentData = gson.fromJson(JSONAssesmentData,String.class);
                Log.v("AssessmentTag3 ",JSONAssessmentData1);
            }
            try {
                assessmentQuestionList.clear();
                JSONObject jsonObject = new JSONObject(JSONAssessmentData);
                //JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = new JSONArray();
                jsonArray = jsonObject.optJSONArray("array");
                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    QuestionWiseAssessment questionWiseAssessment;
                    String questionNumber = jsonObject1.optString("questionNumber").toString();
                    String percentageCorrect = jsonObject1.optString("percentageCorrect").toString();
                    String percentageWrong = jsonObject1.optString("percentageWrong").toString();
                    String attemptsToCorrect = jsonObject1.optString("attemptsToCorrect").toString();
                    String questionsChosen = jsonObject1.optString("questionsChosen").toString();
                    String testId = jsonObject1.optString("testId").toString();
                    questionWiseAssessment = new QuestionWiseAssessment(questionNumber,percentageCorrect,percentageWrong,attemptsToCorrect,questionsChosen,testId);
                    assessmentQuestionList.add(questionWiseAssessment);
                    Log.v("Name ",questionNumber);
                }
            } catch(JSONException Ex) {
                Log.e("JSONException ", Ex.toString());
            }
            try {
                JSONObject jsonObject = new JSONObject(JSONAssessmentData1);
                //JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = new JSONArray();
                jsonArray = jsonObject.optJSONArray("array");
                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    totalAccess = jsonObject1.optString("totalAccess").toString();
                    totalStudent = jsonObject1.optString("totalStudent").toString();
                    totalSubmit = jsonObject1.optString("totalSubmit").toString();
                    Log.v("Name ",totalAccess);
                }
            } catch(JSONException Ex) {
                Log.e("JSONException ", Ex.toString());
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragmentassessmentquestionwise, container, false);
            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_assessment_questionwise_recycler_view);
            mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdpater = new AssessmentQuestionWiseAdapter(this.getContext(),assessmentQuestionList);
            mRecyclerView.setAdapter(mAdpater);
            return rootView;
            //return super.onCreateView(inflater, container, savedInstanceState);
        }

        public static AssessmentQuestionWiseFragment newInstance(){
            AssessmentQuestionWiseFragment assessmentQuestionWiseFragment = new AssessmentQuestionWiseFragment();
            return assessmentQuestionWiseFragment;
        }
}
