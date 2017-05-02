package app.iecs.fcu.mitsign;

import android.content.Intent;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    //物件宣告
    Button Submit;
    String Serial_A;
    String Serial_B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //建立一個按鈕，可進行傳播
        //Submit = (Button)findViewById(R.id.bt_submit);
        //設定OnClickListener
        //Submit.setOnClickListener(submit_click);

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
    private View.OnClickListener submit_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent();
            //myIntent.setAction("lincyu.NOTIFICATION");
            myIntent.putExtra("Serial_A",Serial_A);
            myIntent.putExtra("Serial_B",Serial_B);
            //myIntent.setAction("lincyu.NOTIFICATION");//呼叫接收者的通關密語
            //sendBroadcast(myIntent);
           //Toast.makeText(ResultActivity.this, "廣播已發送 : "+Serial_A+Serial_B, Toast.LENGTH_SHORT).show();//測試用

        }
    };
}
