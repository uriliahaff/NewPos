package com.example.newpos;

import android.graphics.Bitmap;

public class job {
    private String jobCompany;
    private String jobName;
    private String jobRequired;
    private String jobCity;
    private String jobAdress;
    private String jobDays;
    private String jobTime;
    private Bitmap jobImage1;
    private Bitmap jobImage2;
    private String documentPath;
//Constructor
    public job(){

    }
//GETTER AND SETTER

//jobCompany
public String get_jobCompany (){return jobCompany;}
public void set_jobCompany (String jobCompany){this.jobCompany=jobCompany;}

//jobName
public String get_jobName (){return jobName;}
public void set_jobName (String jobName){this.jobName=jobName;}

//jobRequired
public String get_jobRequired (){return jobRequired;}
public void set_jobRequired (String jobRequired){this.jobRequired=jobRequired;}

//jobCity
public String get_jobCity(){return jobCity;}
public void set_jobCity (String jobCity){this.jobCity=jobCity;}

//jobAdress
public String get_jobAdress (){return jobAdress;}
public void set_jobAdress (String jobAdress){this.jobAdress=jobAdress;}

//jobDays
public String get_jobDays (){return  jobDays;}
public void set_jobDays (String jobDays){this.jobDays=jobDays;}

//jobTime
public String get_jobTime (){return  jobTime;}
public void set_jobTime (String jobTime){this.jobTime=jobTime;}

//documentPath
public String get_documentPath (){return documentPath;}
public void set_documentPath (String documentPath){this.documentPath=documentPath;}
}
