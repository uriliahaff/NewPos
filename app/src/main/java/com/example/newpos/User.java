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
    private String userStreet;
    private String userAddress;
    private int userPhoneNumber;
    private int userTelephoneNumber;

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

    //userLastName
    public String get_userLastName(){return userLastName;}
    public void set_userLastName (String userLastName){this.userLastName=userLastName;}

    //itemCVStart
    public String get_itemCVStart (){return userId;}
    public void set_itemCVStart (String itemCVStart){this.userId=itemCVStart;}

    //itemCVEnd
    public String get_itemCVEnd(){return userId;}
    public void set_itemCVEnd (String itemCVEnd){this.userId=itemCVEnd;}

    //itemCVSubTittle
    public String get_itemCVSubTittle (){return userId;}
    public void set_itemCVSubTittle (String itemCVSubTittle){this.userId=itemCVSubTittle;}

}
