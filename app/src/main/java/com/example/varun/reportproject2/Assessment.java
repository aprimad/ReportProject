package com.example.varun.reportproject2;

/**
 * Created by varun on 6/24/16.
 */
public class Assessment {
    public String assessmentTitle;
    public String status;
    public String teacher;
    public String dueDate;
    public String issuedDate;
    public String submittedDate;
    public String topic;
    public String subject;
    public String questionCount;
    public String marks;

    //For CompleteAssessment
    public String assignedDate;
    public String type;
    public String level;
    public String assessmentType;
    public String assessmentMode;
    public String randomType;
    public String assignedTo;

    Assessment(){

    }
    Assessment(String tassessmentTitle,String tteacher,String tstatus,String tdueDate,String tissuedDate,String tsubmittedDate, String ttopic, String tsubject, String tquestionCount, String tmarks){
        assessmentTitle = tassessmentTitle;
        status = tstatus;
        teacher = tteacher;
        dueDate = tdueDate;
        issuedDate = tissuedDate;
        submittedDate = tsubmittedDate;
        topic = ttopic;
        subject = tsubject;
        questionCount = tquestionCount;
        marks = tmarks;
    }

    Assessment(String ttitle, String tteacher, String tassignedDate,String tissuedDate,String tsubmittedDate, String ttype, String tquestionCount, String ttopic,String tlevel,String tsubject,String tassessmentType, String tassessmentMode, String trandomType, String tassignedTo){
        assessmentTitle = ttitle;
        teacher = tteacher;
        assignedDate = tassignedDate;
        issuedDate = tissuedDate;
        submittedDate = tsubmittedDate;
        type = ttype;
        questionCount = tquestionCount;
        topic = ttopic;
        level = tlevel;
        subject = tsubject;
        assessmentType = tassessmentType;
        assessmentMode = tassessmentMode;
        randomType = trandomType;
        assignedTo = tassignedTo;
    }

}
