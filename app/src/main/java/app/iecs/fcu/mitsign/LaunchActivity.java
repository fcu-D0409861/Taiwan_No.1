package app.iecs.fcu.mitsign;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_launch, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.mi_history:
                Intent goHistory = new Intent();
                goHistory.setClass(LaunchActivity.this,HistoryActivity.class);
                startActivity(goHistory);
                break;
            case R.id.mi_about:
                AlertDialog.Builder myAlertBullder = new AlertDialog.Builder(LaunchActivity.this);
                myAlertBullder.setTitle("關於本程式")
                        .setMessage("　MIT標章查詢\n" +
                                    "開發者：賴傳安(d0486467)\n" +
                                    "　　　　蕭賀吉(d0409861)\n" +
                                    "　　　　侯景勛(d0409679)\n\n" +
                                    "聯絡信箱：d0486467@mail.fcu.edu.tw\n\n" +
                                    "逢甲大學 行動應用程式 課程專題")
                        .setPositiveButton("確認",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //none to do
                            }
                        })
                        .show();
        }
        return super.onOptionsItemSelected(item);
    }
}
