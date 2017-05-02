package app.iecs.fcu.mitsign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import org.w3c.dom.Text;

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
    }
    private OnClickListener letsBack = new OnClickListener() {
        @Override
        public void onClick(View v) {
            finish(); //back
        }
    };

}
