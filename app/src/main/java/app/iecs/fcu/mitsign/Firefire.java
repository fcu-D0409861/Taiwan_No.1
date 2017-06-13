package app.iecs.fcu.mitsign;

import android.text.method.SingleLineTransformationMethod;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Chuan.an on 2017/6/13.
 */

public class Firefire extends Thread{

        private DataSnapshot datasnapshot;
        SignStruct[] mySign = new SignStruct[150];
        private int myValue = 0;


    public Firefire(DataSnapshot datasnapshot) {
        this.datasnapshot = datasnapshot;
    }

    public void run() {
        for(DataSnapshot ds : datasnapshot.getChildren()) {

            DataSnapshot dsSign_number = ds.child("Sign_number");
            String tempSign_number = (String) dsSign_number.getValue();
            DataSnapshot dsBrand = ds.child("Brand");
            String tempBrand = (String) dsBrand.getValue();
            DataSnapshot dsIndustry = ds.child("Industry");
            String tempIndustry = (String) dsIndustry.getValue();
            DataSnapshot dsOthers = ds.child("Others");
            String tempOthers = (String) dsOthers.getValue();
            DataSnapshot dsProduct_name = ds.child("Product_name");
            String tempProduct_name = (String) dsProduct_name.getValue();
            DataSnapshot dsProduct_number = ds.child("Product_number");
            String tempProduct_number = (String) dsProduct_number.getValue();
            DataSnapshot dsSerial_number = ds.child("Serial_number");
            String tempSerial_number = (String) dsSerial_number.getValue();

            mySign[myValue].setSign_number(tempSign_number);
            mySign[myValue].setBrand(tempBrand);
            mySign[myValue].setIndustry(tempIndustry);
            mySign[myValue].setOthers(tempOthers);
            mySign[myValue].setProduct_name(tempProduct_name);
            mySign[myValue].setProduct_number(tempProduct_number);
            mySign[myValue].setSerial_number(tempSerial_number);

            myValue++;

            Log.v("AdoptProduct", tempSign_number);
        }
    }

    public SignStruct searchSign(String tofind){
        boolean finded=false;
        SignStruct findedsign = new SignStruct("null","null","null","null","null","null","null");
        for( int i = 0 ; i < myValue ; i++ ){
            if(tofind == mySign[i].getSign_number()){
                finded=true;
                findedsign=mySign[i];
                break;
            }
        }
        return findedsign;
    }

    public int getMyValue() {
        return myValue;
    }

    public SignStruct ToCouLai(int serial){
        return mySign[serial];
    }
}
