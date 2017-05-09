package app.iecs.fcu.mitsign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chuan.an on 2017/5/9.
 */

public class HistoryArrayAdapter extends ArrayAdapter<HistoryStruct> {
    Context context;
    public HistoryArrayAdapter(Context context, ArrayList<HistoryStruct> items){
        super(context,0,items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout itemlayout = null;
        if(convertView == null){
            itemlayout = (LinearLayout) inflater.inflate(R.layout.history_listitem,null);
        }
        else{
            itemlayout = (LinearLayout) convertView;
        }
        HistoryStruct GG3BE0 = (HistoryStruct)getItem(position);

        TextView C_serial_number = (TextView)itemlayout.findViewById(R.id.tv_hli_serial_number);
        C_serial_number.setText(GG3BE0.serial_number);
        TextView C_item_name = (TextView)itemlayout.findViewById(R.id.tv_hli_item_name);
        C_item_name.setText(GG3BE0.item_name);
        TextView C_item_number = (TextView)itemlayout.findViewById(R.id.tv_hli_item_umber);
        C_item_number.setText(GG3BE0.item_number);

        return itemlayout;
    }


}
