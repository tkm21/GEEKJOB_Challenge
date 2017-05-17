
package org.camp.blackjack;

import java.util.*;
import org.camp.blackjack.Human;

public class User extends Human {
    
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
    
    // セット
    public void setCards(ArrayList<String> cd) {
        for(int i = 0; i < cd.size(); i ++) {
            myCards.add(cd.get(i));
        }
    }
    
    // ヒット or ステイ
    public boolean checkSum(ArrayList<String> cd) {
        if(open(cd) <= 15) {
            return false;
        } else {
            return true;
        }
    } 
}
