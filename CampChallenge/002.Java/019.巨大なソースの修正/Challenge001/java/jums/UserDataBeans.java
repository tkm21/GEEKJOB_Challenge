
package jums;

import java.sql.*;
import java.text.*;
import java.util.*;

public class UserDataBeans {
    
    private int id;
    private String name;
    private String birthday;
    private int year;
    private int month;
    private int day;
    private int type;
    private String tell;
    private String comment;
    private boolean flag;
    private Timestamp newdate;
    private ArrayList<Integer> ids = new ArrayList();
    private ArrayList<String> names = new ArrayList();
    private ArrayList<String> years = new ArrayList();
    private ArrayList<Integer> types = new ArrayList();
    private ArrayList<String> newdates = new ArrayList();
    
    // setter
    public void setID(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public void setBirthday(int year, int month, int day){
        Calendar date = Calendar.getInstance();
        date.set(year, month - 1, day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.birthday = sdf.format(date.getTime());
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public void setTell(String tell) {
        this.tell = tell;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public void setNewDate(Timestamp newdate) {
        this.newdate = newdate;
    }
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    public void setIDs(int id) {
        this.ids.add(id);
    }
    
    public void setNames(String names) {
        this.names.add(names);
    }
    
    public void setYears(String years) {
        this.years.add(years);
    }
    
    public void setTypes(int types) {
        this.types.add(types);
    }
    
    public void setNewDates(String newdates) {
        this.newdates.add(newdates);
    }
    
    
    //getter
    
    
    public String getName(){
        return name;
    }
    
    public int getID(){
        return id;
    }
    
    public String getBirthday(){
        return birthday;
    }
    
    public int getYear(){
        return year;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getDay(){
        return day;
    }
    
    public int getType(){
        return type;
    }
    
    public String getTell(){
        return tell;
    }
    
    public String getComment(){
        return comment;
    }
    
    public Timestamp getNewDate(){
        return newdate;
    }
    
    
    public boolean getFlag() {
        return flag;
    }
    
    public ArrayList<Integer> getIDs(){
        return ids;
    }
    
    public ArrayList<String> getNames() {
        return names;
    }
    
    public ArrayList<String> getYears() {
        return years;
    }
    
    public ArrayList<Integer> getTypes() {
        return types;
    }
    
    public ArrayList<String> getNewDates() {
        return newdates;
    }
    
}
