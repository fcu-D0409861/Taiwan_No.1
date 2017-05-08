package app.iecs.fcu.mitsign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LaunchActivity extends AppCompatActivity {
    //物件宣告
    EditText Serial_A;
    EditText Serial_B;
    Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //物件指向View元件
        Serial_A = (EditText)findViewById(R.id.et_serial_A);
        Serial_B = (EditText)findViewById(R.id.et_serial_B);
        Submit = (Button)findViewById(R.id.bt_submit);

        //設定OnClickListener
        Submit.setOnClickListener(submit_click);
    }
    private View.OnClickListener submit_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String number_A = Serial_A.getText().toString();
            String number_B = Serial_B.getText().toString();
            if(number_A.length() != 8 ){ //第一欄防呆
                Toast.makeText(LaunchActivity.this, "請在第一欄輸入正確的 8 位數字", Toast.LENGTH_SHORT).show();
                //Serial_A.setText("");
            }
            else if(number_B.length() != 5 ){ //第二欄防呆
                Toast.makeText(LaunchActivity.this, "請在第二欄輸入正確的 5 位數字", Toast.LENGTH_SHORT).show();
                //Serial_B.setText("");
            }
            else{ //通過防呆測試
                Intent myIntent = new Intent();
                myIntent.setClass(LaunchActivity.this,ResultActivity.class);
                myIntent.putExtra("Serial_A",number_A);
                myIntent.putExtra("Serial_B",number_B);
                startActivity(myIntent); //跳至結果頁面
            }
        }
    };
}
