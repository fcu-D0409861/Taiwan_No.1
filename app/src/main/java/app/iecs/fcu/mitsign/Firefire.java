package app.iecs.fcu.mitsign;

import android.content.Intent;
import android.text.method.SingleLineTransformationMethod;
import android.util.Log;
import android.widget.Toast;

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
        // data struct
        private  SignStruct mySign = new SignStruct(null,null,null,null,null,null,null);


    public Firefire(DataSnapshot datasnapshot) {
        this.datasnapshot = datasnapshot;
    }

    private String Serial_number  ;
    public void setSerial_number (String str)
    {
        Serial_number = str;
    }

    @Override
    public void run() {
        for(DataSnapshot ds : datasnapshot.getChildren()) {

            //Sign_number
            DataSnapshot dsSign_number = ds.child("標章編號");
            String tempSign_number =  dsSign_number.getValue().toString();
            Log.e("Data",tempSign_number+" "+Serial_number);
            if(tempSign_number.equals(Serial_number))
            {
                //Serial_number
                DataSnapshot dsSerial_number = ds.child("序號");
                String tempSerial_number = dsSerial_number.getValue().toString();
                //產業別<-不重要所以省略

                // Product_name
                DataSnapshot dsProduct_name = ds.child("產品名稱");
                String tempProduct_name = dsProduct_name.getValue().toString();

                //Product_number
                DataSnapshot dsProduct_number = ds.child("產品型號");
                String tempProduct_number = dsProduct_number.getValue().toString();
                // Brand
                DataSnapshot dsBrand = ds.child("品牌名稱");
                String tempBrand =  dsBrand.getValue().toString();
                DataSnapshot dsOther = ds.child("備註");
                String tempOther = dsOther.getValue().toString();

                mySign.setSign_number(tempSign_number);
                mySign.setBrand(tempBrand);
                //   mySign[myValue].setIndustry(tempIndustry);
                mySign.setProduct_name(tempProduct_name);
                mySign.setProduct_number(tempProduct_number);
                mySign.setSerial_number(tempSerial_number);

                Intent reslut_intent = new Intent();
                reslut_intent.putExtra("Sign_number",tempSign_number); //標章編號
                reslut_intent.putExtra("Product_name",tempProduct_name);//產品名稱
                reslut_intent.putExtra("Product_number",tempProduct_number);//產品型號
                reslut_intent.putExtra("Brand",tempBrand);//品牌名稱
                reslut_intent.putExtra("Other",tempOther);//備註
                break;
            }


        }
    }

    public SignStruct ToCouLai(){
        return mySign;
    }
}
