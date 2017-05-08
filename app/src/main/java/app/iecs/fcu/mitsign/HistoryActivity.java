package app.iecs.fcu.mitsign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class HistoryActivity extends AppCompatActivity {

    ListView theList;
    Button theBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        theBack = (Button)findViewById(R.id.bt_h_back);
        theBack.setOnClickListener(click_theBack);
        theBack.setOnLongClickListener(longclick_theBack);
    }
    private OnClickListener click_theBack = new OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
    private OnLongClickListener longclick_theBack = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(HistoryActivity.this, "按人家那麼久幹嘛", Toast.LENGTH_SHORT).show();
            return false;
        }
    };
}
