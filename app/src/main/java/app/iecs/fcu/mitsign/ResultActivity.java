package app.iecs.fcu.mitsign;

import android.content.Intent;
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
    }
}
