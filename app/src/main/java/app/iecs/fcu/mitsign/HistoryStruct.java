package app.iecs.fcu.mitsign;

/**
 * Created by Chuan.an on 2017/5/9.
 */

public class HistoryStruct {
    String serial_number,item_name,item_number;
    public HistoryStruct(String serial_number, String item_name, String item_number) {
        this.serial_number = serial_number;
        this.item_name = item_name;
        this.item_number = item_number;
    }
}
