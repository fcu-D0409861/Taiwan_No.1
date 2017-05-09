package app.iecs.fcu.mitsign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

        ArrayList<HistoryStruct> mylist = new ArrayList<HistoryStruct>();

        mylist.add(new HistoryStruct("12345678 - 12345","數字好順公司 高科技智能毛巾","R7833"));
        mylist.add(new HistoryStruct("55688000 - 55688","臺灣大車隊 金屬質感傳輸線","R7050"));

        HistoryArrayAdapter adapter = new HistoryArrayAdapter(this,mylist);

        theList = (ListView)findViewById(R.id.lv_history);
        theList.setAdapter(adapter);


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
