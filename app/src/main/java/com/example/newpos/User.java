package com.example.newpos;

public class User {
    //PRIMERA PARTE
    private String userId;
    private String userName;
    private String userLastName;
    private String userEmail;
    private String userBirthDate;
    private String userNationality;
    private String userResidenceCountry;
    private String userProvince;
    private String userAdrees;
    private String userPhoneNumber;
    private String userTelephoneNumber;
    private String userProfilePicture;
    private String userDescription;

    //SEGUNDA PARTE
    private String userPassword;

    //TERCERA PARTE
    //Certificado
    private String userText;

    //Constructor
    public User(){

    }

    //GETTER AND SETTER

    //userId
    public String get_userid (){return userId;}

    //userName
    public String get_userName (){return userName;}
    public void set_userName (String userName){this.userName=userName;}

    //userProfilePicture
    public String get_userProfilePicture (){return userProfilePicture;}
    public void set_userProfilePicture (String userProfilePicture){this.userProfilePicture=userProfilePicture;}

    //userLastName
    public String get_userLastName(){return userLastName;}
    public void set_userLastName (String userLastName){this.userLastName=userLastName;}

    //userEmail
    public String get_userEmail (){return userEmail;}
    public void set_userEmail (String userEmail){this.userEmail=userEmail;}

    //userBirthDate
    public String get_userBirthDate(){return userBirthDate;}
    public void set_userBirthDate(String userBirthDate){this.userBirthDate=userBirthDate;}

    //userNationality
    public String get_userNationality (){return userNationality;}
    public void set_userNationality (String userNationality){this.userNationality=userNationality;}

    //userResidenceCountry
    public String get_userResidenceCountry(){return userResidenceCountry;}
    public void set_userResidenceCountry (String userResidenceCountry){this.userResidenceCountry=userResidenceCountry;}

    //userProvince
    public String get_userProvince (){return userProvince;}
    public void set_userProvince(String userProvince){this.userProvince=userProvince;}

    //userAdrees
    public String get_userAdrees(){return userAdrees;}
    public void set_userAdrees(String userAdrees){this.userAdrees=userAdrees;}

    //userPhoneNumber
    public String get_userPhoneNumber (){return userPhoneNumber;}
    public void set_userPhoneNumber (String userPhoneNumber){this.userPhoneNumber=userPhoneNumber;}

    //userTelephoneNumber
    public String get_userTelephoneNumber(){return userTelephoneNumber;}
    public void set_userTelephoneNumber (String userTelephoneNumber){this.userTelephoneNumber=userTelephoneNumber;}

    //userDescription
    public String get_userDescription(){return userDescription;}
    public void set_userDescription (String userDescription){this.userDescription=userDescription;}


    //userPassword
    public String get_userPassword(){return userPassword;}
    public void set_userPassword (String userPassword){this.userPassword=userPassword;}

}
