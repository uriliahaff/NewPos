package com.example.newpos;

public class itemCV {
    private String itemCVId;
    private String itemCVTypeId;
    private String itemCVTittle;
    private String itemCVStart;
    private String itemCVEnd;
    private String itemCVSubTittle;
    private String itemCVHabilidad;
    private String documentPath;
//Constructor
    public itemCV(){

    }
//GETTER AND SETTER

 //itemCVId
public String get_itemCVId (){return itemCVId;}

//itemCVTypeId
public String get_itemCVTypeId (){return itemCVTypeId;}
public void set_itemCVTypeId (String itemCVTypeId){this.itemCVTypeId=itemCVTypeId;}

//itemCVTittle
public String get_itemCVTittle (){return itemCVTittle;}
public void set_itemCVTittle (String itemCVTittle){this.itemCVTittle=itemCVTittle;}

//itemCVStart
public String get_itemCVStart (){return itemCVStart;}
public void set_itemCVStart (String itemCVStart){this.itemCVStart=itemCVStart;}

//itemCVEnd
public String get_itemCVEnd(){return itemCVEnd;}
public void set_itemCVEnd (String itemCVEnd){this.itemCVEnd=itemCVEnd;}

//itemCVSubTittle
public String get_itemCVSubTittle (){return itemCVSubTittle;}
public void set_itemCVSubTittle (String itemCVSubTittle){this.itemCVSubTittle=itemCVSubTittle;}

//itemCVHabilidad
public String get_itemCVHabilidad (){return  itemCVHabilidad;}
public void set_itemCVHabilidad (String itemCVHabilidad){this.itemCVHabilidad=itemCVHabilidad;}

//documentPath
public String get_documentPath (){return documentPath;}
public void set_documentPath (String documentPath){this.documentPath=documentPath;}
}
