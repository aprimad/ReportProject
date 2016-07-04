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
public class AssessmentFragment extends Fragment {
    public RecyclerView.LayoutManager mLayoutManager;
    public RecyclerView mRecyclerView;
    public AssessmentAdapter mAdpater;
    public static ArrayList<Assessment> assessmentList = new ArrayList<Assessment>();
    public String[] myDataset = {"stark","lannister","targaryen","tyrell","greyjoy"};
    public AssessmentFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*String JSONAssesmentData = "\"{\\\"infoUrl\\\":\\\"\\\",\\\"assessment\\\":\\\"[{\\\\\\\"testId\\\\\\\":\\\\\\\"117\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Título\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Christõpher Nõlãn\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 19:40\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"17 Jul 2015 08:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Avaliação\\\\\\\",\\\\\\\"questionCount\\\\\\\":2,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Tópicos\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":1,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441280458,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1437091200,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"202\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Título\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Christõpher Nõlãn\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 19:40\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"18 Jul 2015 00:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Padrão\\\\\\\",\\\\\\\"questionCount\\\\\\\":12,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Tópicos\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":2,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441280446,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1437148800,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"318\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"AP Quiz - 1\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Daniel Manning\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 19:40\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"30 Jul 2015 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Personalizado\\\\\\\",\\\\\\\"questionCount\\\\\\\":25,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Random\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":3,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441280421,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1438228800,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"452\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Insira um título\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Daniel Manning\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 19:40\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"12 Aug 2015 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Avaliação\\\\\\\",\\\\\\\"questionCount\\\\\\\":2,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Insira um ou mais tópico(s)\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":1,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441280432,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1439352000,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"453\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Insira um título\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Amar T\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 19:40\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"13 Aug 2015 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Avaliação\\\\\\\",\\\\\\\"questionCount\\\\\\\":2,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Insira um ou mais tópico(s)\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":1,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441280411,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1439438400,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"474\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Insira um título\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Amar T\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 15:36\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"03 Sep 2015 15:36\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"04 Sep 2015 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Avaliação\\\\\\\",\\\\\\\"questionCount\\\\\\\":2,\\\\\\\"marks\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Insira um ou mais tópico(s)\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":1,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441265781,\\\\\\\"submittedDateLong\\\\\\\":1441265790,\\\\\\\"dueDateLong\\\\\\\":1441339200,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"2438\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Practice 1\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Christõpher Nõlãn\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"20 May 2016 14:52\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"20 May 2016 14:52\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"27 May 2016 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Personalizado\\\\\\\",\\\\\\\"questionCount\\\\\\\":2,\\\\\\\"marks\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"NUmber Notation\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":3,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1463727129,\\\\\\\"submittedDateLong\\\\\\\":1463727150,\\\\\\\"dueDateLong\\\\\\\":1464321600,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0}]\\\",\\\"scorecardUrl\\\":\\\"http:\\/\\/assessment.lumos.heymath.com\\/showScoreCard.action?userID=sheela\\\"}\"";
        Gson gson = new Gson();
        JSONAssesmentData = gson.fromJson(JSONAssesmentData,String.class);
        try {
            JSONObject jsonAssessmentObject = new JSONObject(JSONAssesmentData);
            Log.v("AssessmentTag0 ",jsonAssessmentObject.toString());
            JSONArray jsonAssessmentArray = new JSONArray();
            jsonAssessmentArray = jsonAssessmentObject.getJSONArray("assessment");
            Log.v("AssessmentTag1 ",jsonAssessmentArray.toString());
        }catch (JSONException Ex) {
            Log.e("AssessmentTag2 ", Ex.toString());
            JSONAssesmentData = Ex.toString();
            JSONAssesmentData = JSONAssesmentData.substring(30,JSONAssesmentData.length()-72);
            JSONAssesmentData = "{\"array\":"+ JSONAssesmentData + "}";
            //JSONAssesmentData = gson.fromJson(JSONAssesmentData,String.class);
            Log.v("AssessmentTag3 ",JSONAssesmentData);
        }
        try {
            assessmentList.clear();
            JSONObject jsonObject = new JSONObject(JSONAssesmentData);
            //JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray = jsonObject.optJSONArray("array");
            for(int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Assessment assessment = new Assessment();
                String assesmentTitle = jsonObject1.optString("title").toString();
                String status = jsonObject1.optString("status").toString();
                String teacher = jsonObject1.optString("teacher").toString();
                String issuedDate = jsonObject1.optString("issuedDate").toString();
                String dueDate = jsonObject1.optString("dueDate").toString();
                String submittedDate = jsonObject1.optString("submittedDate").toString();
                String topic = jsonObject1.optString("topic").toString();
                String subject = jsonObject1.optString("subject").toString();
                String questionCount = jsonObject1.optString("questionCount").toString();
                String marks = jsonObject1.optString("marks").toString();
                assessment = new Assessment(assesmentTitle,teacher,status,dueDate,issuedDate,submittedDate,topic,subject,questionCount,marks);
                assessmentList.add(assessment);
                Log.v("Name ",assesmentTitle);
            }
        } catch(JSONException Ex) {
            Log.e("JSONException ", Ex.toString());
        } */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_assessmentdata, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_assessment_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdpater = new AssessmentAdapter(this.getContext(),assessmentList);
        mRecyclerView.setAdapter(mAdpater);

        return rootView;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static AssessmentFragment newInstance(ArrayList<Assessment> assessments){
        AssessmentFragment assessmentFragment = new AssessmentFragment();
        assessmentList = assessments;
        return assessmentFragment;
    }



}
/**
 * Created by varun on 6/24/16.
 */

