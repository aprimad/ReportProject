package com.example.varun.reportproject2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by varun on 7/1/16.
 */
public class StudentAssessmentFragment extends Fragment {
        public RecyclerView.LayoutManager mLayoutManager;
        public RecyclerView mRecyclerView;
        public AssessmentAdapter mAdpater;
        public static ArrayList<Assessment> assessmentList = new ArrayList<Assessment>();
        public static ArrayList<Assessment> submittedList = new ArrayList<Assessment>();
        public static ArrayList<Assessment> pendingList = new ArrayList<Assessment>();
        public static ArrayList<Assessment> marksList = new ArrayList<Assessment>();
        public static ArrayList<Float> marks = new ArrayList<Float>();
        public static ArrayList<String> subjects = new ArrayList<String>();
        public String[] myDataset = {"stark","lannister","targaryen","tyrell","greyjoy"};
        public StudentAssessmentFragment(){

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //String JSONAssesmentData = "\"{\\\"infoUrl\\\":\\\"\\\",\\\"assessment\\\":\\\"[{\\\\\\\"testId\\\\\\\":\\\\\\\"117\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Título\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Christõpher Nõlãn\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 19:40\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"17 Jul 2015 08:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Avaliação\\\\\\\",\\\\\\\"questionCount\\\\\\\":2,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Tópicos\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":1,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441280458,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1437091200,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"202\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Título\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Christõpher Nõlãn\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 19:40\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"18 Jul 2015 00:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Padrão\\\\\\\",\\\\\\\"questionCount\\\\\\\":12,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Tópicos\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":2,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441280446,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1437148800,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"318\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"AP Quiz - 1\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Daniel Manning\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 19:40\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"30 Jul 2015 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Personalizado\\\\\\\",\\\\\\\"questionCount\\\\\\\":25,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Random\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":3,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441280421,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1438228800,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"452\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Insira um título\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Daniel Manning\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 19:40\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"12 Aug 2015 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Avaliação\\\\\\\",\\\\\\\"questionCount\\\\\\\":2,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Insira um ou mais tópico(s)\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":1,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441280432,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1439352000,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"453\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Insira um título\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Amar T\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 19:40\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"13 Aug 2015 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Avaliação\\\\\\\",\\\\\\\"questionCount\\\\\\\":2,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Insira um ou mais tópico(s)\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":1,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441280411,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1439438400,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"474\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Insira um título\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Amar T\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"03 Sep 2015 15:36\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"03 Sep 2015 15:36\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"04 Sep 2015 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Avaliação\\\\\\\",\\\\\\\"questionCount\\\\\\\":2,\\\\\\\"marks\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Insira um ou mais tópico(s)\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":1,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1441265781,\\\\\\\"submittedDateLong\\\\\\\":1441265790,\\\\\\\"dueDateLong\\\\\\\":1441339200,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"2438\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Practice 1\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Christõpher Nõlãn\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"20 May 2016 14:52\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"20 May 2016 14:52\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"27 May 2016 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Personalizado\\\\\\\",\\\\\\\"questionCount\\\\\\\":2,\\\\\\\"marks\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"NUmber Notation\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Primary 2\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Mathematics\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":3,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1463727129,\\\\\\\"submittedDateLong\\\\\\\":1463727150,\\\\\\\"dueDateLong\\\\\\\":1464321600,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0}]\\\",\\\"scorecardUrl\\\":\\\"http:\\/\\/assessment.lumos.heymath.com\\/showScoreCard.action?userID=sheela\\\"}\"";
            String JSONAssesmentData = "\"{\\\"infoUrl\\\":\\\"\\\",\\\"assessment\\\":\\\"[{\\\\\\\"testId\\\\\\\":\\\\\\\"1480\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Quiz 01_3º ano_22\\/03\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Lucas Luna\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"01 Abr 2016 15:38\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"10 Jun 2016 15:57\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"23 Mar 2016 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Padrão\\\\\\\",\\\\\\\"questionCount\\\\\\\":20,\\\\\\\"marks\\\\\\\":\\\\\\\"13\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Decomposição e Composição dos números\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Year 3\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Matemática\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":2,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1459535894,\\\\\\\"submittedDateLong\\\\\\\":1465585059,\\\\\\\"dueDateLong\\\\\\\":1458745200,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"1595\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Quiz 02_3º ano_01\\/04\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Lucas Luna\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"01 Abr 2016 15:38\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"01 Abr 2016 15:57\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"08 Abr 2016 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Padrão\\\\\\\",\\\\\\\"questionCount\\\\\\\":50,\\\\\\\"marks\\\\\\\":\\\\\\\"17\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Espaço e Forma; Sólidos geométricos\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Year 3\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Matemática\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":2,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1459535916,\\\\\\\"submittedDateLong\\\\\\\":1459537050,\\\\\\\"dueDateLong\\\\\\\":1460127600,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"1689\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Quiz 2.1_3º ano_05\\/04\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Lucas Luna\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"05 Abr 2016 16:06\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"10 Jun 2016 16:08\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"12 Abr 2016 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Padrão\\\\\\\",\\\\\\\"questionCount\\\\\\\":50,\\\\\\\"marks\\\\\\\":\\\\\\\"30\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Espaço e Forma; Sólidos geométricos\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Year 3\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Matemática\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":2,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1459883179,\\\\\\\"submittedDateLong\\\\\\\":1465585709,\\\\\\\"dueDateLong\\\\\\\":1460473200,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"1896\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Quiz 03_3º ano_15\\/04\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Lucas Luna\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"07 Jun 2016 15:47\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"10 Jun 2016 15:52\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"22 Abr 2016 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Padrão\\\\\\\",\\\\\\\"questionCount\\\\\\\":40,\\\\\\\"marks\\\\\\\":\\\\\\\"29\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Adição\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Year 3\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Matemática\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":2,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1465325260,\\\\\\\"submittedDateLong\\\\\\\":1465584728,\\\\\\\"dueDateLong\\\\\\\":1461337200,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"1898\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Quiz_3º ano_15\\/04\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Lucas Luna\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"15 Abr 2016 15:32\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"15 Abr 2016 16:06\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"22 Abr 2016 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Padrão\\\\\\\",\\\\\\\"questionCount\\\\\\\":40,\\\\\\\"marks\\\\\\\":\\\\\\\"21\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Adição\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Year 3\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Matemática\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":2,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1460745170,\\\\\\\"submittedDateLong\\\\\\\":1460747209,\\\\\\\"dueDateLong\\\\\\\":1461337200,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"1980\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Quiz_3º ano_22\\/04\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Lucas Luna\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"22 Abr 2016 15:33\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"10 Jun 2016 16:09\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"29 Abr 2016 14:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Padrão\\\\\\\",\\\\\\\"questionCount\\\\\\\":35,\\\\\\\"marks\\\\\\\":\\\\\\\"19\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Subtração\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Year 3\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Matemática\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":2,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1461349982,\\\\\\\"submittedDateLong\\\\\\\":1465585789,\\\\\\\"dueDateLong\\\\\\\":1461949200,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"2303\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Quiz_3º ano_10\\/05\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Lucas Luna\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"10 Mai 2016 15:38\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"21 Jun 2016 16:10\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"17 Mai 2016 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Personalizado\\\\\\\",\\\\\\\"questionCount\\\\\\\":26,\\\\\\\"marks\\\\\\\":\\\\\\\"26\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Adição e Subtração\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Year 3\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Matemática\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":3,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1462905494,\\\\\\\"submittedDateLong\\\\\\\":1466536235,\\\\\\\"dueDateLong\\\\\\\":1463497200,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0},{\\\\\\\"testId\\\\\\\":\\\\\\\"2540\\\\\\\",\\\\\\\"title\\\\\\\":\\\\\\\"Quiz_3º ano_31\\/05\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"teacher\\\\\\\":\\\\\\\"Lucas Luna\\\\\\\",\\\\\\\"issuedDate\\\\\\\":\\\\\\\"31 Mai 2016 15:36\\\\\\\",\\\\\\\"submittedDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"dueDate\\\\\\\":\\\\\\\"07 Jun 2016 12:00\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"Personalizado\\\\\\\",\\\\\\\"questionCount\\\\\\\":30,\\\\\\\"marks\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"topic\\\\\\\":\\\\\\\"Multiplicação\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Year 3\\\\\\\",\\\\\\\"subject\\\\\\\":\\\\\\\"Matemática\\\\\\\",\\\\\\\"assessmentType\\\\\\\":0,\\\\\\\"assessmentMode\\\\\\\":3,\\\\\\\"randomType\\\\\\\":0,\\\\\\\"assignedDateLong\\\\\\\":0,\\\\\\\"issuedDateLong\\\\\\\":1464719800,\\\\\\\"submittedDateLong\\\\\\\":0,\\\\\\\"dueDateLong\\\\\\\":1465311600,\\\\\\\"solutionDateLong\\\\\\\":0,\\\\\\\"isHold\\\\\\\":0}]\\\",\\\"scorecardUrl\\\":\\\"http:\\/\\/assessment.lumos.heymath.com\\/showScoreCard.action?userID=cmpedrofd\\\"}\"";
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
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragmentstudentassessment, container, false);
            ArrayList<Entry> entries = new ArrayList<>();
            ArrayList<String> labels = new ArrayList<String>();
            submittedList.clear();
            pendingList.clear();
            PieChart pieChart = (PieChart) rootView.findViewById(R.id.studentAssessmentSubmittedDetail);
            LineChart lineChart = (LineChart) rootView.findViewById(R.id.studentAssessmentLineChart);
            int submittedCount = 0;
            int pendingCount = 0;
            int flag = 0;
            float average = 0;
            ArrayList<Entry> lineEntries = new ArrayList<Entry>();
            ArrayList<String> lineLabels = new ArrayList<String>();
            int count = 0;
            for(int i=0;i<assessmentList.size();i++) {
                if((assessmentList.get(i).marks.matches("-"))||(assessmentList.get(i).marks.matches(""))) {
                    pendingList.add(assessmentList.get(i));
                    pendingCount++;
                    flag=1;
                } else {
                    submittedList.add(assessmentList.get(i));
                    submittedCount++;
                    average += Integer.valueOf(assessmentList.get(i).marks);
                    Log.v("Calc",assessmentList.get(i).marks+" "+assessmentList.get(i).questionCount);
                    lineEntries.add(new Entry(( Float.valueOf(Integer.valueOf((assessmentList.get(i).marks)))/Integer.valueOf(assessmentList.get(i).questionCount))*100,count));
                    marksList.add(assessmentList.get(i));
                    count++;
                    lineLabels.add(assessmentList.get(i).subject);
                    flag = 1;
                }
            }
            LineDataSet lineDataSet = new LineDataSet(lineEntries,"Marks");
            lineDataSet.setValueTextSize(MainActivity.size);
            LineData lineData = new LineData(lineLabels,lineDataSet);
            lineChart.setData(lineData);
            lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                @Override
                public void onValueSelected(Entry entry, int i, Highlight highlight) {
                    ArrayList<Assessment> marksData = new ArrayList<Assessment>();
                    marksData.add(marksList.get(entry.getXIndex()));
                    Fragment fragment = AssessmentFragment.newInstance(marksData);
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("AssessmentFragmentMarksData").commit();
                }

                @Override
                public void onNothingSelected() {

                }
            });
            if(pendingCount!=0) {
                entries.add(new Entry(pendingCount,0));
                labels.add("Pending");
            }
            if(submittedCount!=0){
                entries.add(new Entry(submittedCount,1));
                labels.add("Submitted");
            }
            if(flag==0) pieChart.setVisibility(View.INVISIBLE);
            PieDataSet pieDataSet = new PieDataSet(entries,"Assessments");
            PieData pieData = new PieData(labels,pieDataSet);
            pieChart.setData(pieData);
            pieDataSet.setValueTextSize(MainActivity.size);
            pieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
            pieChart.animateY(5000);
            pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                @Override
                public void onValueSelected(Entry entry, int i, Highlight highlight) {
                    if(entry.getXIndex()==0) {
                        Fragment fragment = AssessmentFragment.newInstance(pendingList);
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("assessmentFragmentPending").commit();
                    } else if(entry.getXIndex()==1){
                        Fragment fragment = AssessmentFragment.newInstance(submittedList);
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("assessmentFragmentSubmitted").commit();
                    }
                }

                @Override
                public void onNothingSelected() {

                }
            });

            /*mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_assessment_recycler_view);
            mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdpater = new AssessmentAdapter(this.getContext(),assessmentList);
            mRecyclerView.setAdapter(mAdpater); */

            return rootView;
            //return super.onCreateView(inflater, container, savedInstanceState);
        }

        public static StudentAssessmentFragment newInstance(){
            StudentAssessmentFragment studentAssessmentFragment = new StudentAssessmentFragment();
            return studentAssessmentFragment;
        }

}
