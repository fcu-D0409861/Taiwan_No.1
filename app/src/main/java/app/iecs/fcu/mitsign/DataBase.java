package app.iecs.fcu.mitsign;

/* Created by Chuan.an on 2017/5/1. */

public class DataBase {
    public String FindItem (String digit8,String digit5){
        String theResult="",theCompany="unknow",theItem="unknow";

        switch(digit8){
            case "11111111":{
                theCompany = "一路到底公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "22222222":{
                theCompany = "兩全齊美公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "33333333":{
                theCompany = "三陽開泰公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "44444444":{
                theCompany = "四通八達公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "55555555":{
                theCompany = "五福臨門公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "66666666":{
                theCompany = "六六大順公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "77777777":{
                theCompany = "七步成詩公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "88888888":{
                theCompany = "八扒叭仈公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "99999999":{
                theCompany = "九九九九公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "00000000":{
                theCompany = "零零零零公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "12345678":{
                theCompany = "數字好順公司";
                theItem = FindItemSub(digit5);
                break;
            }
            case "55688000":{
                theCompany = "臺灣大車隊";
                theItem = FindItemSub(digit5);
                break;
            }
            case "41298890":{
                theCompany = "必勝客比薩";
                theItem = FindItemSub(digit5);
                break;
            }
            default:{

            }
        }
        theResult = theCompany + " " + theItem;
        return theResult;
    }
    private String FindItemSub (String digit5){
        String theResult="unknow";

        switch(digit5){
            case "12345":{
                theResult="高科技智能毛巾";
                break;
            }
            case "55688":{
                theResult="金屬質感傳輸線";
                break;
            }
            default:{
                theResult="公司上市紀念筆";
                break;
            }
        }

        return theResult;
    }
}
