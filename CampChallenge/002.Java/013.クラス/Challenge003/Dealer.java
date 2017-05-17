
package org.camp.blackjack;

import java.util.*;
import org.camp.blackjack.Human;

public class Dealer extends Human {
    
    ArrayList<String> spadesCards = new ArrayList<String>() {{
        add("Ａ"); add("２"); add("３"); add("４"); add("５"); add("６"); add("７"); add("８"); add("９"); add("１０"); add("Ｊ"); add("Ｑ"); add("Ｋ");
    }};
    ArrayList<String> diamondsCards = new ArrayList<String>() {{
        add("Ａ"); add("２"); add("３"); add("４"); add("５"); add("６"); add("７"); add("８"); add("９"); add("１０"); add("Ｊ"); add("Ｑ"); add("Ｋ");
    }};
    ArrayList<String> clubsCards = new ArrayList<String>() {{
        add("Ａ"); add("２"); add("３"); add("４"); add("５"); add("６"); add("７"); add("８"); add("９"); add("１０"); add("Ｊ"); add("Ｑ"); add("Ｋ");
    }};
    ArrayList<String> heartsCards = new ArrayList<String>() {{
        add("Ａ"); add("２"); add("３"); add("４"); add("５"); add("６"); add("７"); add("８"); add("９"); add("１０"); add("Ｊ"); add("Ｑ"); add("Ｋ");
    }};
    
    // ディール
    public ArrayList<String> deal() {
//        ArrayList<String> temp1 = new ArrayList<String>(); // リターン用1
        ArrayList<String> temp2 = new ArrayList<String>(); // リターン用2
        for(int i = 0; i < 2; i ++) {
            Random rand = new Random();
            int index = rand.nextInt(3);
            switch(index) {
                case 0: // スペード
                    index = rand.nextInt(spadesCards.size());
//                    temp1.add("♠" + spadesCards.get(index));
                    temp2.add(spadesCards.get(index));
                    spadesCards.remove(index);
                    break;
                case 1: // ダイヤ
                    index = rand.nextInt(diamondsCards.size());
//                    temp1.add("♦" + diamondsCards.get(index));
                    temp2.add(diamondsCards.get(index));
                    diamondsCards.remove(index);
                    break;
                case 2: // クラブ
                    index = rand.nextInt(clubsCards.size());
//                    temp1.add("♣" + clubsCards.get(index));
                    temp2.add(clubsCards.get(index));
                    clubsCards.remove(index);
                    break;
                case 3: // ハート
                    index = rand.nextInt(heartsCards.size());
//                    temp1.add("❤" + heartsCards.get(index));
                    temp2.add(heartsCards.get(index));
                    heartsCards.remove(index);
                    break;
            }
        }
        return temp2;
    }
    
    // ヒット
    public String hit() {
        String temp1 = "";
        String temp2 = "";
        
        Random rand = new Random();
        int index = rand.nextInt(3);
        switch(index) {
            case 0: // スペード
                index = rand.nextInt(spadesCards.size());
                temp1 = "♠" + spadesCards.get(index);
                temp2 = spadesCards.get(index);
                spadesCards.remove(index);
                break;
            case 1: // ダイヤ
                index = rand.nextInt(diamondsCards.size());
                temp1 = "♦" + diamondsCards.get(index);
                temp2 = diamondsCards.get(index);
                diamondsCards.remove(index);
                break;
            case 2: // クラブ
                index = rand.nextInt(clubsCards.size());
                temp1 = "♣" + clubsCards.get(index);
                temp2 = clubsCards.get(index);
                clubsCards.remove(index);
                break;
            case 3: // ハート
                index = rand.nextInt(heartsCards.size());
                temp1 = "❤" + heartsCards.get(index);
                temp2 = heartsCards.get(index);
                heartsCards.remove(index);
                break;
        }        
        return temp2;
    }
    
    // セット
    public void setCards(ArrayList<String> cd) {
        for(int i = 0; i < cd.size(); i ++){
            myCards.add(cd.get(i));
        }
    }
    
    // ポイント計算
    public int open(ArrayList<String> cd) {
        int sum = 0;
        int countA = 0;
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < cd.size(); i ++) {
            if(cd.get(i) == "Ｊ" || cd.get(i) == "Ｑ" || cd.get(i) == "Ｋ") {
                sum += 10; // J,Q,Kは10として計算
            } else if(cd.get(i) != "Ａ") {
                sum += Integer.parseInt(cd.get(i)); // Integer.parseInt("String") => "String"をintに変換
            } else {
                countA ++;
            }
            final int SUM = sum;
            switch(countA) {
                case 0: 
                    break;
                case 1: // 11として計算した時、21以下なら11 超えたなら1
                    sum1 = SUM + 1; // 1として
                    sum2 = SUM + 11; // 11として
                    if (sum2 > 21) {
                    sum = sum1;
                    } else {
                        sum = sum2;
                    }
                    break;
                case 2: // 1枚は1として計算 2枚目を11として計算した時、21以下なら11 超えたなら1
                    sum1 = SUM + 2; // 2枚とも1
                    sum2 = SUM + 12; // 1枚を11 1枚を1
                    if (sum2 > 21){
                        sum = sum1;
                    }else{
                        sum = sum2;
                    }
                    break;
                case 3: // 2枚は1として計算 もう1枚を11として計算した時、21以下なら11 超えたなら1
                    sum1 = SUM + 3; // 3枚とも1
                    sum2 = SUM + 13; // 1枚を11 2枚を1
                    if (sum2 > 21){
                        sum = sum1;
                    }else{
                        sum = sum2;
                    }
                    break;
                case 4: // 3枚は1として計算 もう1枚を11として計算した時。21以下なら11 超えたなら1
                    sum1 = SUM + 4; // 4枚とも1
                    sum2 = SUM + 14; // 1枚を11 3枚を1
                    if (sum2 > 21) {
                        sum = sum1;
                    } else {
                        sum = sum2;
                    }
                    break;
            }    
        }
        return sum;
    }
    
    // ヒット or ステイ (ディーラーは１７未満の場合必ずヒットしなくてはいけない)
    public boolean checkSum(ArrayList<String> cd) {
        
        if(open(cd) < 17){
            return true;
        } else {
            return false;
        }     
    } 
    
}