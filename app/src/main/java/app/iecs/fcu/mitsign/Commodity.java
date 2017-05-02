package app.iecs.fcu.mitsign;

/**
 * Created by User on 2017/5/1.
 */

public class Commodity {
    String T1Name,T2Name;
    int T1Point,T2Point;
    int T1Pic,T2Pic;
    Commodity(int T1Pic,String T1Name,int T1Point,int T2Pic,String T2Name,int T2Point){
        this.T1Name=T1Name;
        this.T1Pic=T1Pic;
        this.T1Point=T1Point;
        this.T2Name=T2Name;
        this.T2Pic=T2Pic;
        this.T2Point=T2Point;
    }
}
