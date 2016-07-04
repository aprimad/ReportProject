package com.example.varun.reportproject2;

/**
 * Created by varun on 6/23/16.
 */
public class Student {
    public String userName;
    public String userID;
    public String loginCount;
    public String lessonAccess;
    public String assessmentCount;
    public String levelSection;
    public String levelName;
    public String loginDuration;

    public Student(){

    }
    public Student(String name,String id,String login,String lesson, String ac,String ls, String ln, String ld){
        userName = name;
        userID = id;
        loginCount = login;
        lessonAccess = lesson;
        assessmentCount = ac;
        levelSection = ls;
        levelName = ln;
        loginDuration = ld;
    }
}
