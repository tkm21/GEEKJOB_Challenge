
package org.camp.blackjack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.camp.blackjack.Dealer;

public class BlackJack extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>課題-BlackJack-</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>");
            
            // ディーラー
            ArrayList<String> dealerHands = new ArrayList<String>();
            out.print("【Ｄｅａｌｅｒ】<br>");
            Dealer dealer = new Dealer(); // ディーラーの作成
            dealerHands = dealer.deal(); // ディール
            int dealerSum = dealer.open(dealerHands); // ポイント計算
            out.print(dealerHands + "　＝＞　" + changeNumHalfToFull(Integer.toString(dealerSum)) + "<br>"); 
            while(dealer.checkSum(dealerHands) == true) { // ポイントが17未満の場合ヒットし続ける
                dealerHands.add(dealer.hit()); // ヒット
                dealerSum = dealer.open(dealerHands); // ポイント計算
                out.print(dealerHands + "　＝＞　" + changeNumHalfToFull(Integer.toString(dealerSum)) + "<br>"); 
            }
            
            out.print("<br>");
            
            // ユーザー
            ArrayList<String> userHands = new ArrayList<String>();
            out.print("【Ｕｓｅｒ】<br>");
            Dealer user = new Dealer(); //ユーザーの作成
            userHands = dealer.deal(); // ディール
            int userSum = user.open(userHands); // ポイント計算
            out.print(userHands + "　＝＞　" + changeNumHalfToFull(Integer.toString(userSum)) + "<br>");
            while(user.checkSum(userHands) == true) { // ポイントが17未満の場合ヒットし続ける
                userHands.add(dealer.hit()); // ヒット
                userSum = user.open(userHands); // ポイント計算
                out.print(userHands + "　＝＞　" + changeNumHalfToFull(Integer.toString(userSum)) + "<br>"); 
            }
            
            out.print("<br>");
            
            // 勝敗
            out.print("【Ｒｅｓｕｌｔ】<br>");
            if(userSum <= 21 && dealerSum < userSum || userSum <= 21 && dealerSum > 21) {
                out.print("Ｕｓｅｒ　Ｗｉｎ！！！");
            } else if(dealerSum == userSum && userSum <= 21) {
                if(userHands.size() < dealerHands.size()) {
                    out.print("Ｕｓｅｒ　Ｗｉｎ！！！");
                } else if(userHands.size() == dealerHands.size()) {
                    out.print("Ｄｒａｗ");
                } else {
                    out.print("Ｕｓｅｒ　Ｌｏｓｅ．．．");
                }
            } else {
                out.print("Ｕｓｅｒ　Ｌｏｓｅ．．．");
            } 
            
            
            
            out.println("</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
        }
    }
    
    public static String changeNumHalfToFull(String str) {
		String result = null;
		if(str != null) {
		    StringBuilder sb = new StringBuilder(str);
		    for (int i = 0; i < sb.length(); i++) {
		        int c = (int) sb.charAt(i);
		        if (c >= 0x30 && c <= 0x39) {
		            sb.setCharAt(i, (char) (c + 0xFEE0));
		        }
		    }
		    result = sb.toString();
		}
	    return result;
	}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
