
package Kagoyume;

import java.util.*;

public class JavaBeans {
    
    // newで実行
    public JavaBeans() {
        this.setLoginUserName("");
        this.setLoginPassword("");
        this.setRegistrationUserName("");
        this.setRegistrationPassword("");
        this.setRegistrationPasswordConfirm("");
        this.setRegistrationMail("");
        this.setRegistrationAddress("");
    }
    
    
    // ログイン状態保持
    private boolean logFlag;
    public void setLogFlag(boolean logFlag) {
        this.logFlag = logFlag;
    }
    public boolean getLogFlag() {
        return logFlag;
    }
    // ログイン状態の時userID保持
    private String userID;
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getUserID() {
        return userID;
    }
    
    // ログイン失敗時に保持
    private boolean loginErrorFlag;
    public void setLoginErrorFlag(boolean loginErrorFlag) {
        this.loginErrorFlag = loginErrorFlag;
    }
    public boolean getLoginErrorFlag() {
        return loginErrorFlag;
    }
    
    // ログイン試行時に保持
    // ユーザー名
    private String loginUserName;
    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }
    public String getLoginUserName() {
        return loginUserName;
    }
    // パスワード
    private String loginPassword;
    public void setLoginPassword(String loginPassword) {
        this.loginPassword=loginPassword;
    }
    public String getLoginPassword() {
        return loginPassword;
    }
    
    
    // 新規登録失敗時に保持
    private boolean registrationErrorFlag;
    public void setRegistrationErrorFlag(boolean registrationErrorFlag) {
        this.registrationErrorFlag = registrationErrorFlag;
    }
    public boolean getRegistrationErrorFlag() {
        return registrationErrorFlag;
    }
    
    // 新規登録試行時に保持
    // ユーザー名
    private String registrationUserName;
    public void setRegistrationUserName(String registrationUserName) {
        this.registrationUserName = registrationUserName;
    }
    public String getRegistrationUserName() {
        return registrationUserName;
    }
    // パスワード
    private String registrationPassword;
    public void setRegistrationPassword(String registrationPassword) {
        this.registrationPassword = registrationPassword;
    }
    public String getRegistrationPassword() {
        return registrationPassword;
    }
    // パスワード確認用
    private String registrationPasswordConfirm;
    public void setRegistrationPasswordConfirm(String registrationPasswordConfirm) {
        this.registrationPasswordConfirm = registrationPasswordConfirm;
    }
    public String getRegistrationPasswordConfirm() {
        return registrationPasswordConfirm;
    }
    // メールアドレス
    private String registrationMail;
    public void setRegistrationMail(String registrationMail) {
        this.registrationMail = registrationMail;
    }
    public String getRegistrationMail() {
        return registrationMail;
    }
    // 住所
    private String registrationAddress;
    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }
    public String getRegistrationAddress() {
        return registrationAddress;
    }
    
    // 検索実行時に保持
    private boolean searchFlag;
    public void setSearchFlag(boolean searchFlag) {
        this.searchFlag = searchFlag;
    }
    public boolean getSearchFlag() {
        return searchFlag;
    }
    
    // 商品表示時に保持
    private boolean itemDisplay;
    public void setItemDisplay(boolean itemDisplay) {
        this.itemDisplay = itemDisplay;
    }
    public boolean getItemDisplay() {
        return itemDisplay;
    }
    
    // カート表示時に保持
    private boolean cartDisplay;
    public void setCartDisplay(boolean cartDisplay) {
        this.cartDisplay = cartDisplay;
    }
    public boolean getCartDisplay() {
        return cartDisplay;
    }
    
    // 注文画面表示時に保持
    private boolean buyDisplay;
    public void setBuyDisplay(boolean buyDisplay) {
        this.buyDisplay = buyDisplay;
    }
    public boolean getBuyDisplay() {
        return buyDisplay;
    }
    
    // 注文確定画面表示時に保持
    private boolean buyCompleteDisplay;
    public void setBuyCompleteDisplay(boolean buyCompleteDisplay) {
        this.buyCompleteDisplay = buyCompleteDisplay;
    }
    public boolean getBuyCompleteDisplay() {
        return buyCompleteDisplay;
    }
    
    // 履歴表示時に保持
    private boolean myHistoryDisplay;
    public void setMyHistoryDisplay(boolean myHistoryDisplay) {
        this.myHistoryDisplay = myHistoryDisplay;
    }
    public boolean getMyHistoryDisplay() {
        return myHistoryDisplay;
    }
    
    // マイページ表示時に保持
    private boolean accountDisplay;
    public void setAccountDisplay(boolean accountDisplay) {
        this.accountDisplay = accountDisplay;
    }
    public boolean getAccountDisplay() {
        return accountDisplay;
    }
    
    // 編集画面表示時に保持
    private boolean updateDisplay;
    public void setUpdateDisplay(boolean updateDisplay) {
        this.updateDisplay = updateDisplay;
    }
    public boolean getUpdateDisplay() {
        return updateDisplay;
    }
    
    
    // カートの中身を保持
    private HashMap<String, Integer> cart = new HashMap();
    // カートに追加
    public void addCart(String productCode, int i) {
        this.cart.put(productCode, i);
    }
    public HashMap<String, Integer> getCart() {
        return cart;
    }
    public void deleteCart(String productCode) {
        this.cart.remove(productCode);
    }
    public void clearCart() {
        this.cart.clear();
    }
    
    
    
    
    private ArrayList<SearchDataBeans> itemDatas = new ArrayList();
    public void clearItemData() {
        this.itemDatas.clear();
    }
    public void setItemData(SearchDataBeans itemData) {
        this.itemDatas.add(itemData);
    }
    public ArrayList<SearchDataBeans> getItemDatas() {
        return itemDatas;
    }
    
    private HashMap<String, String> history = new HashMap();
    public void setHistory(HashMap<String, String> history) {
        this.history = history;
    }
    public HashMap<String, String> getHistory() {
        return history;
    }
    
    
    public String mail;
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getMail() {
        return mail;
    }
    
    public String address;
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    
}
