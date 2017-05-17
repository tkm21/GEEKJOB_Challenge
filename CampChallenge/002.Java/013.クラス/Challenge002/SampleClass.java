
package org.camp.servlet;

import java.io.PrintWriter;

//クラス
public class SampleClass {
    public String valueA;
    public String valueB;

//メソッド
    public void setData(String A, String B){
        valueA = A;
        valueB = B;
    }
    public void getData(PrintWriter out){
        out.print(valueA + "<br>");
        out.print(valueB + "<br>");
    }
}
