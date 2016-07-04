package com.example.varun.reportproject2;

/**
 * Created by varun on 6/29/16.
 */
public class QuestionWiseAssessment {
    String questionNumber;
    String percentageCorrect;
    String percentageWrong;
    String attemptsToCorrect;
    String questionsChosen;
    String testId;

    QuestionWiseAssessment(String tquestionNumber,String tpercentageCorrect,String tpercentageWrong,String tattemptsToCorrect,String tquestionsChosen,String ttestId){
        questionNumber = tquestionNumber;
        percentageCorrect = tpercentageCorrect;
        percentageWrong = tpercentageWrong;
        attemptsToCorrect = tattemptsToCorrect;
        questionsChosen = tquestionsChosen;
        testId = ttestId;
    }
}
