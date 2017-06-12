package app.iecs.fcu.mitsign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    Button getBack;
    String mynumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getBack = (Button)findViewById(R.id.bt_back);
        getBack.setOnClickListener(letsBack);
        Intent myIntent = getIntent();
        String Company = myIntent.getStringExtra("Serial_A");
        String Product = myIntent.getStringExtra("Serial_B");
        // 取得來自MainActivity的兩組號碼 Serial_A & Serial_B
        mynumber = Company +'-'+ Product;
        TextView myIndustry = (TextView)findViewById(R.id.tv_industry_plus);
        TextView mybrand = (TextView)findViewById(R.id.tv_brand);
        TextView myproductnumber = (TextView)findViewById(R.id.tv_product_number);
        TextView myothers = (TextView)findViewById(R.id.tv_others);
        TextView serial_number = (TextView)findViewById(R.id.tv_serial_number);
        serial_number.setText(mynumber);

        SignStruct[] gg3be0;
        int ggvalue=0;

        FirebaseDatabase fbdb = FirebaseDatabase.getInstance();
        DatabaseReference myRef = fbdb.getReference("");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){

                    DataSnapshot dsSign_number = ds.child("Sign_number");
                    String tempSign_number = (String)dsSign_number.getValue();

                    DataSnapshot dsBrand = ds.child("Brand");
                    String tempBrand = (String)dsBrand.getValue();

                    DataSnapshot dsIndustry = ds.child("Industry");
                    String tempIndustry = (String)dsIndustry.getValue();

                    DataSnapshot dsOthers = ds.child("Others");
                    String tempOthers = (String)dsOthers.getValue();

                    DataSnapshot dsProduct_name = ds.child("Product_name");
                    String tempProduct_name = (String)dsProduct_name.getValue();

                    DataSnapshot dsProduct_number = ds.child("Product_number");
                    String tempProduct_number = (String)dsProduct_number.getValue();

                    DataSnapshot dsSerial_number = ds.child("Serial_number");
                    String tempSerial_number = (String)dsSerial_number.getValue();

                    gg3be0

                    Log.v("AdoptProduct",tempSign_number + " to " + mynumber);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("AdoptProduct",databaseError.getMessage());
            }
        });


    }
    private OnClickListener letsBack = new OnClickListener() {
        @Override
        public void onClick(View v) {
            finish(); //back
        }
    };
}
