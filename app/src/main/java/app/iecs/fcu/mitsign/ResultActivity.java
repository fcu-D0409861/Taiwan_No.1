package app.iecs.fcu.mitsign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    Button getBack;

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

        TextView serial_number = (TextView)findViewById(R.id.tv_result_int);
        serial_number.setText(Company + " - " + Product);

        DataBase myBase = new DataBase(); //New DataBase
        String theResult = myBase.FindItem(Company,Product); //取得結果
        TextView F_result = (TextView)findViewById(R.id.tv_result);
            F_result.setText(theResult);
        TextView rannumber = (TextView)findViewById(R.id.tv_serialnumber);
        if(theResult.compareTo("查無目標")==1){
            rannumber.setText("查無目標");
        }
        else{
            rannumber.setText(getRamdon());
        }

    }
    private OnClickListener letsBack = new OnClickListener() {
        @Override
        public void onClick(View v) {
            finish(); //back
        }
    };
    private String getRamdon (){
        Random ran = new Random();
        String fi="";
        int temp=0;
        char CH0,CH1,CH2,CH3,CH4;
        temp = ran.nextInt(26)+65;
        CH0 = (char)temp;
        temp = ran.nextInt(10)+48;
        CH1 = (char)temp;
        temp = ran.nextInt(10)+48;
        CH2 = (char)temp;
        temp = ran.nextInt(10)+48;
        CH3 = (char)temp;
        temp = ran.nextInt(10)+48;
        CH4 = (char)temp;

        fi = String.valueOf(CH0)+
             String.valueOf(CH1)+
             String.valueOf(CH2)+
             String.valueOf(CH3)+
             String.valueOf(CH4);
        return fi;
    };
}
