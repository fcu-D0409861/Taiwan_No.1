package app.iecs.fcu.mitsign;

/**
 * Created by Chuan.an on 2017/6/13.
 */

public  class SignStruct
//  datastruct
{
    private String Serial_number;   //序號
    private String Sign_number;     //標章編號
    private String Product_number; //產品名稱
    private String Product_name;   //產品型號
    private String Brand;           //品牌名稱
    private String Others;          //備註
    private String Industry;



    public SignStruct(String brand, String industry, String others, String product_name, String product_number, String serial_number, String sign_number) {

        Serial_number = serial_number;
        Sign_number = sign_number;
        Product_number = product_number;
        Product_name = product_name;
        Brand = brand;
        Others = others;
        Industry = industry;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setIndustry(String industry) {
        Industry = industry;
    }

    public String getOthers() {
        return Others;
    }

    public void setOthers(String others) {
        Others = others;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getProduct_number() {
        return Product_number;
    }

    public void setProduct_number(String product_number) {
        Product_number = product_number;
    }

    public String getSerial_number() {
        return Serial_number;
    }

    public void setSerial_number(String serial_number) {
        Serial_number = serial_number;
    }

    public String getSign_number() {
        return Sign_number;
    }

    public void setSign_number(String sign_number) {
        Sign_number = sign_number;
    }
}
