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




    }
    private OnClickListener letsBack = new OnClickListener() {
        @Override
        public void onClick(View v) {
            finish(); //back
        }
    };
}
