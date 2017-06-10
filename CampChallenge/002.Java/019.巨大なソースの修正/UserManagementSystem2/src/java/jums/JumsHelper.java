
package jums;

import java.util.Date;

public class JumsHelper {
    
    //トップ
    private final String homeURL = "index.jsp";
    
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String home() {
        return "<a href=\"" + homeURL + "\">トップへ戻る</a>";
    }
    
    public boolean check(String name, int year, int month, int day, int type, String tell, String comment) {
        if(!name.equals("") && year != 0 && month != 0 && day != 0 && type != 0 && !tell.equals("") && !comment.equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
    public UserDataBeans udbSet(UserDataBeans udb, String name, int year, int month, int day, int type, String tell, String comment) {
        udb.setName(name);
        udb.setYear(year);
        udb.setMonth(month);
        udb.setDay(day);
        if(year != 0 && month != 0 && day != 0){
            udb.setBirthday(year, month, day);
        }
        udb.setType(type);
        udb.setTell(tell);
        udb.setComment(comment);
        udb.setFlag(true);
        return udb;
    }
    
    public UserDataDTO uddSet(UserDataDTO udd, UserDataBeans udb) {
        udd.setUserID(udb.getID());
        udd.setName(udb.getName());
        udd.setBirthday(udb.getYear(), udb.getMonth(), udb.getDay());
        udd.setType(udb.getType());
        udd.setTell(udb.getTell());
        udd.setComment(udb.getComment());
        return udd;
    }
    
    
    
    
}
