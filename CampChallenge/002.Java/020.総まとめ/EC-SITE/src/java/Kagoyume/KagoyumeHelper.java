
package Kagoyume;

import java.util.*;

public class KagoyumeHelper {
    
    // インスタンスを作成
    public static KagoyumeHelper getInstance() {
        return new KagoyumeHelper();
    }
    
    //　追加用のuddにセット
    public UserDataDTO setudd(JavaBeans jb, UserDataDTO udd) {
        udd.setUserID(jb.getUserID());
        udd.setUserName(jb.getRegistrationUserName());
        udd.setPassword(jb.getRegistrationPassword());
        udd.setMail(jb.getRegistrationMail());
        udd.setAddress(jb.getRegistrationAddress());
        return udd;
    }
    
    
    // カテゴリーの定義
    public HashMap<Integer, String> category() {
        HashMap<Integer, String> category = new HashMap();
        category.put(1, "すべてのカテゴリ");
        category.put(13457, "ファッション");
        category.put(2498, "食品");
        category.put(2500, "ダイエット、健康");
        category.put(2501, "コスメ、香水");
        category.put(2502, "パソコン、周辺機器");
        category.put(2504, "AV機器、カメラ");
        category.put(2505, "家電");
        category.put(2506, "家具、インテリア");
        category.put(2507, "花、ガーデニング");
        category.put(2508, "キッチン、生活雑貨、日用品");
        category.put(2503, "DIY、工具、文具");
        category.put(2509, "ペット用品、生き物");
        category.put(2510, "楽器、趣味、学習");
        category.put(2511, "ゲーム、おもちゃ");
        category.put(2497, "ベビー、キッズ、マタニティ");
        category.put(2512, "スポーツ");
        category.put(2513, "レジャー、アウトドア");
        category.put(2514, "CD、音楽ソフト");
        category.put(2516, "自転車、車、バイク用品");
        category.put(2517, "DVD、映像ソフト");
        category.put(10002, "本、雑誌、コミック");
        return category;
    }
    
    public JavaBeans moveTop(JavaBeans jb) {
        jb.setSearchFlag(false);
        jb.setItemDisplay(false);
        jb.setCartDisplay(false);
        jb.setBuyDisplay(false);
        jb.setBuyCompleteDisplay(false);
        jb.setAccountDisplay(false);
        jb.setMyHistoryDisplay(false);
        jb.setUpdateDisplay(false);
        return jb;
    }
    
}
