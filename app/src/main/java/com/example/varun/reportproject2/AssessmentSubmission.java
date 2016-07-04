package com.example.varun.reportproject2;

/**
 * Created by varun on 6/27/16.
 */
public class AssessmentSubmission {
    public String userName;
    public String testId;
    public String userId;
    public String currentQNumber;
    public String currentQID;
    public String currentAttempt;
    public String totalCorrectAns;
    public String status;
    public String correctQuestions;
    public String wrongQuestionNumber;
    public String notAttemptedQuestionNumber;
    public String percentage;
    public String score;
    public String level;

    AssessmentSubmission(String tuserName,String ttestId,String tuserId,String tcurrentQNumber,String tcurrentQID,String tcurrentAttempt, String ttotalCorrectAns, String tstatus,String tcorrectQuestions,String twrongQuestionNumber,String tnotAttemptedQuestionNumber,String tpercentage,String tscore,String tlevel){
        userName = tuserName;
        testId = ttestId;
        userId = tuserId;
        currentQNumber = tcurrentQNumber;
        currentQID = tcurrentQID;
        currentAttempt = tcurrentAttempt;
        totalCorrectAns = ttotalCorrectAns;
        status = tstatus;
        correctQuestions = tcorrectQuestions;
        wrongQuestionNumber = twrongQuestionNumber;
        notAttemptedQuestionNumber = tnotAttemptedQuestionNumber;
        percentage = tpercentage;
        score = tscore;
        level = tlevel;
    }
}
