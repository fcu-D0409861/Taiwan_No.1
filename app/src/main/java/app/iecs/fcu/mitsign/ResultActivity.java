package app.iecs.fcu.mitsign;

import android.content.Intent;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent myIntent = getIntent();
        String Serial_A = myIntent.getStringExtra("Serial_A");
        String Serial_B = myIntent.getStringExtra("Serial_B");
        // 取得來自MainActivity的兩組號碼 Serial_A & Serial_B

        TextView tv4 = (TextView)findViewById(R.id.textView4);
        tv4.setText(Serial_A);
        TextView tv5 = (TextView)findViewById(R.id.textView5);
        tv5.setText(Serial_B);

        DataBase myBase = new DataBase(); //New DataBase
        String theResult = myBase.FindItem(Serial_A,Serial_B); //取得結果
        TextView tv6 = (TextView)findViewById(R.id.textView6);
        tv6.setText(theResult);
    }
}
