package com.example.varun.reportproject2;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
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
 * Created by varun on 6/27/16.
 */
public class AssessmentDetailFragment extends Fragment {
        public static ArrayList<AssessmentSubmission> assessmentList = new ArrayList<AssessmentSubmission>();
        public static ArrayList<AssessmentSubmission> A1ArrayList = new ArrayList<AssessmentSubmission>();
        public static ArrayList<AssessmentSubmission> A2ArrayList = new ArrayList<AssessmentSubmission>();
        public static ArrayList<AssessmentSubmission> B1ArrayList = new ArrayList<AssessmentSubmission>();
        public static ArrayList<AssessmentSubmission> B2ArrayList = new ArrayList<AssessmentSubmission>();
        public static ArrayList<AssessmentSubmission> C1ArrayList = new ArrayList<AssessmentSubmission>();
        public static ArrayList<AssessmentSubmission> C2ArrayList = new ArrayList<AssessmentSubmission>();
        public static ArrayList<AssessmentSubmission> DArrayList = new ArrayList<AssessmentSubmission>();
        public static ArrayList<AssessmentSubmission> submittedList = new ArrayList<AssessmentSubmission>();
        public static ArrayList<AssessmentSubmission> accessedList = new ArrayList<AssessmentSubmission>();
        public static ArrayList<AssessmentSubmission> notAccessedList = new ArrayList<AssessmentSubmission>();
        public static FragmentManager fragmentManager;

        String jsonData;
        public AssessmentDetailFragment(){

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            fragmentManager = getFragmentManager();
            //String JSONAssesmentData = "\"{\\\"scoreCardUrl\\\":\\\"http:\\/\\/assessment.lumos.heymath.com\\/showScoreCard.action?userID=\\\",\\\"Info\\\":\\\"[{\\\\\\\"userName\\\\\\\":\\\\\\\"Sheela\\\\\\\",\\\\\\\"testId\\\\\\\":2682,\\\\\\\"userId\\\\\\\":\\\\\\\"sheela\\\\\\\",\\\\\\\"currentQNo\\\\\\\":0,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":0,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"startDateLong\\\\\\\":0,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"4\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"95\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"4\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Pri 2.1\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Vijay R\\\\\\\",\\\\\\\"testId\\\\\\\":2682,\\\\\\\"userId\\\\\\\":\\\\\\\"rvijay\\\\\\\",\\\\\\\"currentQNo\\\\\\\":0,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":0,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"startDateLong\\\\\\\":0,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"4\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"97\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"8\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Pri 2.1\\\\\\\"}]\\\",\\\"userAccess\\\":\\\"{\\\\\\\"totalAccess\\\\\\\":0,\\\\\\\"totalStudent\\\\\\\":2,\\\\\\\"totalSubmit\\\\\\\":0}\\\"}\"";
            String JSONAssesmentData = "\"{\\\"scoreCardUrl\\\":\\\"http:\\/\\/assessment.lumos.heymath.com\\/showScoreCard.action?userID=\\\",\\\"Info\\\":\\\"[{\\\\\\\"userName\\\\\\\":\\\\\\\"Colégio Motivo Student 3\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"motivostu3\\\\\\\",\\\\\\\"currentQNo\\\\\\\":0,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":0,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Not Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"startDateLong\\\\\\\":0,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"4º ano - Turma B\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Colégio Motivo Student 4\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"motivostu4\\\\\\\",\\\\\\\"currentQNo\\\\\\\":0,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":0,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Not Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"startDateLong\\\\\\\":0,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"4º ano - Turma B\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Francisco Elcias Costa Albuquerque\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmfranciscoeca\\\\\\\",\\\\\\\"currentQNo\\\\\\\":0,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":0,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Not Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"startDateLong\\\\\\\":0,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 3\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Victor Bezerra Baptista\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmvictorbb\\\\\\\",\\\\\\\"currentQNo\\\\\\\":0,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":0,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Not Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"startDateLong\\\\\\\":0,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 3\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Julia Benzota De Oliveira Albuquerque\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmjuliabdoa\\\\\\\",\\\\\\\"currentQNo\\\\\\\":0,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":0,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Not Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"startDateLong\\\\\\\":0,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 3\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Inácio de Oliveira Negromonte\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cminaciodon\\\\\\\",\\\\\\\"currentQNo\\\\\\\":0,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":0,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Not Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"startDateLong\\\\\\\":0,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 3\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"João Pedro Dantas dos Santos\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmjoaopdds\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:44\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458665064,\\\\\\\"completedDate\\\\\\\":\\\\\\\"22 Mar 2016 13:53\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1458665620,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"16\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"9\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"64\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"16\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 3\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Marina Duque De Holanda Cavalcanti\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmmarinaddhc\\\\\\\",\\\\\\\"currentQNo\\\\\\\":0,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":0,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Not Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"startDateLong\\\\\\\":0,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Eduardo Grimaldi Leite De Macêdo\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmeduardogldm\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:24\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458663840,\\\\\\\"completedDate\\\\\\\":\\\\\\\"14 Jun 2016 14:02\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1465923736,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"24\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"96\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"24\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Mateus Bradley Chalaça Moreira\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmmateusbcm\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:28\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458664099,\\\\\\\"completedDate\\\\\\\":\\\\\\\"22 Mar 2016 13:50\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1458665429,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"16\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"9\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"64\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"16\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Marina Silveira Viana\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmmarinasv\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:24\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458663872,\\\\\\\"completedDate\\\\\\\":\\\\\\\"22 Mar 2016 13:47\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1458665231,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"19\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"6\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"76\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"19\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Guilherme Mattos Pichin\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmguilhermemp\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:36\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458664583,\\\\\\\"completedDate\\\\\\\":\\\\\\\"07 Jun 2016 13:48\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1465318127,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"9\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"16\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"36\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"9\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Maria Eduarda Martins De Siqueira\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmmariaemds\\\\\\\",\\\\\\\"currentQNo\\\\\\\":2,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"01 Abr 2016 13:53\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1459529600,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Vinícius Oliveira Amorim\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmviniciusoa\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:26\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458663972,\\\\\\\"completedDate\\\\\\\":\\\\\\\"22 Mar 2016 13:43\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1458665025,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"18\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"7\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"72\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"18\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Artur Coutinho Souza Leão\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmarturcsl\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:21\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458663713,\\\\\\\"completedDate\\\\\\\":\\\\\\\"22 Mar 2016 13:39\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1458664780,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"23\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"2\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"92\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"23\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Letícia Catunda Araújo\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmleticiaca\\\\\\\",\\\\\\\"currentQNo\\\\\\\":6,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":2,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:27\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458664069,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Lara Resende Araújo\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmlarara\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:25\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458663907,\\\\\\\"completedDate\\\\\\\":\\\\\\\"22 Mar 2016 13:49\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1458665382,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"18\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"7\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"72\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"18\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Manuela Rezende Florentino\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmmanuelarf\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:27\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458664024,\\\\\\\"completedDate\\\\\\\":\\\\\\\"22 Mar 2016 13:44\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1458665091,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"19\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"6\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"76\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"19\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Gabriel Crispim de Farias Luck\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmgabrielcdfl\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:23\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458663818,\\\\\\\"completedDate\\\\\\\":\\\\\\\"01 Abr 2016 13:59\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1459529977,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"24\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"96\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"24\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Laura Faraoni Rodrigues De Oliveira\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmlaurafrdo\\\\\\\",\\\\\\\"currentQNo\\\\\\\":6,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"01 Abr 2016 13:52\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1459529554,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Gabriela Cristina Pontes Vieira Do Amaral\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmgabrielacpvda\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:25\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458663906,\\\\\\\"completedDate\\\\\\\":\\\\\\\"22 Mar 2016 13:50\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1458665424,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"18\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"7\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"72\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"18\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Júlya Valentina Pereira Ferreira\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmjulyavpf\\\\\\\",\\\\\\\"currentQNo\\\\\\\":6,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:25\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458663950,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Gabriel Henrique Martins Da Silva\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmgabrielhmds\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"01 Abr 2016 13:55\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1459529727,\\\\\\\"completedDate\\\\\\\":\\\\\\\"20 Mai 2016 13:56\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1463763391,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"16\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"9\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"64\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"16\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Filipe De Souza Leão Araújo\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmfilipedsla\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:30\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458664209,\\\\\\\"completedDate\\\\\\\":\\\\\\\"22 Mar 2016 13:51\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1458665493,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"17\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"8\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"68\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"17\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Rogens Emanuel Wanderley Rocha Aragão\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmrogensewra\\\\\\\",\\\\\\\"currentQNo\\\\\\\":15,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"22 Mar 2016 13:28\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1458664083,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Felipe Augusto M. Oliveira\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmfelipeamo\\\\\\\",\\\\\\\"currentQNo\\\\\\\":0,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":0,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Not Accessed\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"startDateLong\\\\\\\":0,\\\\\\\"completedDateLong\\\\\\\":0,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"-\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"},{\\\\\\\"userName\\\\\\\":\\\\\\\"Lara Simões de Barros Andrade\\\\\\\",\\\\\\\"testId\\\\\\\":1481,\\\\\\\"userId\\\\\\\":\\\\\\\"cmlarasdba\\\\\\\",\\\\\\\"currentQNo\\\\\\\":1,\\\\\\\"currentQID\\\\\\\":0,\\\\\\\"currentAttempt\\\\\\\":1,\\\\\\\"totalCorrectAns\\\\\\\":0,\\\\\\\"status\\\\\\\":\\\\\\\"Submitted\\\\\\\",\\\\\\\"startDate\\\\\\\":\\\\\\\"01 Abr 2016 13:49\\\\\\\",\\\\\\\"startDateLong\\\\\\\":1459529369,\\\\\\\"completedDate\\\\\\\":\\\\\\\"08 Abr 2016 13:52\\\\\\\",\\\\\\\"completedDateLong\\\\\\\":1460134330,\\\\\\\"correctQuestions\\\\\\\":\\\\\\\"16\\\\\\\",\\\\\\\"wrongQuestionNo\\\\\\\":\\\\\\\"9\\\\\\\",\\\\\\\"notAttemptedQuestionNo\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"percentage\\\\\\\":\\\\\\\"64\\\\\\\",\\\\\\\"score\\\\\\\":\\\\\\\"16\\\\\\\",\\\\\\\"level\\\\\\\":\\\\\\\"Turma 7\\\\\\\"}]\\\",\\\"userAccess\\\":\\\"{\\\\\\\"totalAccess\\\\\\\":19,\\\\\\\"totalStudent\\\\\\\":27,\\\\\\\"totalSubmit\\\\\\\":14}\\\"}\"";
            Gson gson = new Gson();
            JSONAssesmentData = gson.fromJson(JSONAssesmentData,String.class);
            try {
                JSONObject jsonAssessmentObject = new JSONObject(JSONAssesmentData);
                Log.v("AssessmentTag0 ",jsonAssessmentObject.toString());
                JSONArray jsonAssessmentArray = new JSONArray();
                jsonAssessmentArray = jsonAssessmentObject.getJSONArray("Info");
                Log.v("AssessmentTag1 ",jsonAssessmentArray.toString());
            }catch (JSONException Ex) {
                Log.e("AssessmentTag2 ", Ex.toString());
                JSONAssesmentData = Ex.toString();
                JSONAssesmentData = JSONAssesmentData.substring(30,JSONAssesmentData.length()-66);
                JSONAssesmentData = "{\"array\":"+ JSONAssesmentData + "}";
                jsonData = JSONAssesmentData;
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
                    AssessmentSubmission assessment;
                    String userName = jsonObject1.optString("userName").toString();
                    String testId = jsonObject1.optString("testId").toString();
                    String userId = jsonObject1.optString("userId").toString();
                    String currentQNumber = jsonObject1.optString("currentQNo").toString();
                    String currentQID = jsonObject1.optString("currentQID").toString();
                    String currentAttempt = jsonObject1.optString("currentAttempt").toString();
                    String totalCorrectAns = jsonObject1.optString("totalCorrectAns").toString();
                    String status = jsonObject1.optString("status").toString();
                    String correctQuestions = jsonObject1.optString("correctQuestions").toString();
                    String wrongQuestionNumber = jsonObject1.optString("wrongQuestionNo").toString();
                    String notAttemptedQuestionNo = jsonObject1.optString("notAttemptedQuestionNo").toString();
                    String percentage = jsonObject1.optString("percentage").toString();
                    String score = jsonObject1.optString("score").toString();
                    String level = jsonObject1.optString("level").toString();
                    assessment = new AssessmentSubmission(userName,testId,userId,currentQNumber,currentQID,currentAttempt,totalCorrectAns,status,correctQuestions,wrongQuestionNumber,notAttemptedQuestionNo,percentage,score,level);
                    assessmentList.add(assessment);
                    //Log.v("Name ",assesmentTitle);
                }
            } catch(JSONException Ex) {
                Log.e("JSONException ", Ex.toString());
            }
            AssessmentSubmission assessment = new AssessmentSubmission("Anirudh","101","fulltwist360","2","2","1","2","Accessed","2","0","3","-","","12");
            assessmentList.add(assessment);
            assessment = new AssessmentSubmission("ABC","101","twist360","1","1","1","1","Accessed","1","0","4","-","","12");
            assessmentList.add(assessment);
            assessment = new AssessmentSubmission("Rahul","101","twist360","0","0","0","0","Not Accessed","-","-","-","-","","12");
            assessmentList.add(assessment);
            assessment = new AssessmentSubmission("Ravi","101","twist360","0","0","0","0","Not Accessed","-","-","-","-","","12");
            assessmentList.add(assessment);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragmentassessmentdetail, container, false);
            int countAccessed = 0;
            int countSubmitted = 0;
            int notAccessed = 0;
            PieChart pieChart = (PieChart) rootView.findViewById(R.id.assessmentSubmissionInfoChart);
            BarChart barChart = (BarChart) rootView.findViewById(R.id.assessmentStudentMarksDataChart);
            BarChart barChart1 = (BarChart) rootView.findViewById(R.id.assessmentStudentPercentageChart);

            ArrayList<Entry> entries = new ArrayList<>();
            ArrayList<BarEntry> marks = new ArrayList<>();
            ArrayList<String> labels1 = new ArrayList<String>();
            int marksLength = 0;
            int length = assessmentList.size();
            int A1 = 0;
            int A2 = 0;
            int B1 = 0;
            int B2 = 0;
            int C1 = 0;
            int C2 = 0;
            int D = 0;
            A1ArrayList.clear();
            A2ArrayList.clear();
            B1ArrayList.clear();
            B2ArrayList.clear();
            C1ArrayList.clear();
            C2ArrayList.clear();
            DArrayList.clear();
            accessedList.clear();
            submittedList.clear();
            notAccessedList.clear();
            for(int i=0;i<assessmentList.size();i++) {
                if(assessmentList.get(i).status.matches("Not Accessed")) {
                    notAccessed++;
                    notAccessedList.add(assessmentList.get(i));
                }else {
                    if(assessmentList.get(i).percentage.matches("-")) {
                        countAccessed++;
                        accessedList.add(assessmentList.get(i));
                    }
                    else {
                        countSubmitted++;
                        submittedList.add(assessmentList.get(i));
                        marks.add(new BarEntry(Integer.parseInt(assessmentList.get(i).score),marksLength));
                        marksLength++;
                        labels1.add(assessmentList.get(i).userName);
                        int percent = Integer.parseInt(assessmentList.get(i).percentage);
                        if(percent>90){
                            A1++;
                            A1ArrayList.add(assessmentList.get(i));
                        }
                        else if(percent>80){
                            A2++;
                            A2ArrayList.add(assessmentList.get(i));
                        }
                        else if(percent>70){
                            B1++;
                            B1ArrayList.add(assessmentList.get(i));
                        }
                        else if(percent>60){
                            B2++;
                            B2ArrayList.add(assessmentList.get(i));
                        }
                        else if(percent>50){
                            C1++;
                            C1ArrayList.add(assessmentList.get(i));
                        }
                        else if(percent>40){
                            C2++;
                            C2ArrayList.add(assessmentList.get(i));
                        }
                        else{
                            D++;
                            DArrayList.add(assessmentList.get(i));
                        }
                    }
                }
            }
            //entries.add(new BarEntry(((float)countAccessed/length),0));
            //entries.add(new BarEntry(((float)countSubmitted/length),1));
            ArrayList<String> labels = new ArrayList<String>();
            if(countAccessed!=0) {
                entries.add(new Entry(countAccessed,0));
                labels.add("Accessed");
            }
            if(countSubmitted!=0) {
                entries.add(new Entry(countSubmitted,1));
                labels.add("Submitted");
            }
            if(notAccessed!=0) {
                entries.add(new Entry(notAccessed,2));
                labels.add("Not Accessed");
            }
            PieDataSet dataSet=new PieDataSet(entries,"Students");
            dataSet.setValueTextSize(MainActivity.size);


            PieData data = new PieData(labels, dataSet);
            pieChart.setData(data);
            pieChart.animateY(5000);

            pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                @Override
                public void onValueSelected(Entry entry, int i, Highlight highlight) {
                    if(entry.getXIndex()==0) {
                        /*Toast toast = new Toast(getContext());
                        toast.makeText(getContext(),"Students Accessed!",Toast.LENGTH_SHORT).show(); */
                        Fragment fragment = AssessmentStudentListFragment.newInstance(1, accessedList);
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().remove(fragment).commit();
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("AssessmentStudentListFragment").commit();
                        Log.v("accessedListSize",String.valueOf(accessedList.size()));

                    }else if(entry.getXIndex()==1){
                        /*Toast toast = new Toast(getContext());
                        toast.makeText(getContext(),"Students Submitted!",Toast.LENGTH_SHORT).show(); */
                        Log.v("submittedListSize",String.valueOf(submittedList.size()));
                        Fragment fragment = AssessmentStudentListFragment.newInstance(2, submittedList);
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().remove(fragment).commit();
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("AssessmentStudentListFragment").commit();


                    }else{
                        Fragment fragment = AssessmentStudentListFragment.newInstance(3, notAccessedList);
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().remove(fragment).commit();
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("AssessmentStudentListFragment").commit();
                        Log.v("notAccessedListSize",String.valueOf(notAccessedList.size()));
                    }
                }

                @Override
                public void onNothingSelected() {

                }
            });

            dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

            marks.add(new BarEntry(100,0));
            labels1.add("Sheela");
            marks.add(new BarEntry(95,1));
            labels1.add("Ravi");
            BarDataSet dataSet1 = new BarDataSet(marks,"Student Marks");
            BarData data1 = new BarData(labels1,dataSet1);
            barChart.setData(data1);
            barChart.animateY(5000);
            //dataSet1.setValueTextSize(10f);
            dataSet1.setValueTextSize(MainActivity.size);
            dataSet1.setColors(ColorTemplate.VORDIPLOM_COLORS);

            ArrayList<BarEntry> entries1 = new ArrayList<>();
            entries1.add(new BarEntry(A1, 0));
            entries1.add(new BarEntry(A2, 1));
            entries1.add(new BarEntry(B1, 2));
            entries1.add(new BarEntry(B2, 3));
            entries1.add(new BarEntry(C1, 4));
            entries1.add(new BarEntry(C2, 5));
            entries1.add(new BarEntry(D, 6));


            BarDataSet dataSet2 = new BarDataSet(entries1, "Marks");
            dataSet2.setValueTextSize(MainActivity.size);
            ArrayList<String> labels2 = new ArrayList<String>();
            labels2.add("91-100");
            labels2.add("81-90");
            labels2.add("71-80");
            labels2.add("61-70");
            labels2.add("51-60");
            labels2.add("41-50");
            labels2.add("<40");

            BarData markPercentageRanges = new BarData(labels2, dataSet2);
            barChart1.setData(markPercentageRanges);
            barChart1.animateY(5000);
            barChart1.setOnChartValueSelectedListener(
                    new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry entry, int i, Highlight highlight) {
                            if(entry.getVal()!=0) {
                                /*
                                Fragment fragment = AssessmentStudentListFragment.newInstance(entry.getXIndex());
                                if(getFragmentManager().findFragmentByTag("Fragment!")==null) {
                                } else {
                                        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentByTag("Fragment!")).commit();
                                }
                                android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.fragmentAssessmentDetailLinearLayout, fragment, "Fragment!");
                                ft.addToBackStack("Tag!").commit(); */

                                //Fragment fragment = AssessmentStudentListFragment.newInstance(entry.getXIndex());
                                Fragment fragment = AssessmentStudentListFragment.newInstance(0, A1ArrayList);
                                FragmentManager fragmentManager = getFragmentManager();
                                fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack("AssessmentStudentListFragment").commit();
                                Log.v("A1Size",String.valueOf(A1ArrayList.size()));

                            }
                        }

                        @Override
                        public void onNothingSelected() {

                        }
                    }
            );
            //dataSet2.setValueTextSize(10f);
            dataSet2.setColors(ColorTemplate.VORDIPLOM_COLORS);

            /*A1ArrayList.add(assessmentList.get(0));
            A1ArrayList.add(assessmentList.get(1)); */
            return rootView;
            //return super.onCreateView(inflater, container, savedInstanceState);
        }

        public static AssessmentDetailFragment newInstance(){
            AssessmentDetailFragment assessmentDetailFragment = new AssessmentDetailFragment();
            return assessmentDetailFragment;
        }



}
