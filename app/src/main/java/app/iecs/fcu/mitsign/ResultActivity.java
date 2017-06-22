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
        String sign_num = myIntent.getStringExtra("Sign_number");
        String product_name = myIntent.getStringExtra("Product_name");
        String product_number = myIntent.getStringExtra("Product_number");
        String brand = myIntent.getStringExtra("Brand");
        String other = myIntent.getStringExtra("Other");

        TextView mySignumber = (TextView)findViewById(R.id.tv_serial_number);
        TextView myProductName = (TextView)findViewById(R.id.tv_product_name);
        TextView myProductNumber = (TextView)findViewById(R.id.tv_product_number);
        TextView myBrand = (TextView)findViewById(R.id.tv_brand);
        TextView myOthers = (TextView)findViewById(R.id.tv_others);

        mySignumber.setText(sign_num);
        myProductName.setText(product_name);
        myProductNumber.setText(product_number);
        myBrand.setText(brand);
        myOthers.setText(other);
    }
    private OnClickListener letsBack = new OnClickListener() {
        @Override
        public void onClick(View v) {
            finish(); //back
        }
    };
}
