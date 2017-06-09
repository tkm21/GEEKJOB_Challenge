package jums;

import base.DBManager;
import java.sql.*;

public class UserDataDAO {
    
    
    public static UserDataDAO getInstance() {
        return new UserDataDAO();
    }
    
    // 全検索
    public UserDataBeans select() throws SQLException{
        
        UserDataBeans udb = new UserDataBeans();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet data = null;
        String sql = "select * from user_t";
        
        try {
            
            con = DBManager.getConnection();
            st =  con.prepareStatement(sql);
            data = st.executeQuery();
            
            while(data.next()) {
                udb.setIDs(data.getInt("userID"));
                udb.setNames(data.getString("name"));
                udb.setYears(data.getString("birthday").substring(0,4));
                udb.setTypes(data.getInt("type"));
                udb.setNewDates(data.getString("newDate"));
            }
            return udb;
            
        } catch(SQLException e) {
            
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }

    }
    
    // 検索(条件あり)
    public UserDataBeans select(String name, String year, String type1, String type2, String type3) throws SQLException{
        
        UserDataBeans udb = new UserDataBeans();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet data = null;
        boolean check = false;
        boolean check2 = false;
        String sql = "select * from user_t";
        
        // 条件追加
        if(name.length() != 0 || year.length() != 0 || type1 != null || type2 != null || type3 != null) {
            sql += " where";
        }
        
        // 名前入力あり
        if(name.length() != 0) { 
            sql += " name like '%" + name + "%'";
            check = true;
        }
        
        // 生年入力あり
        if(year.length() != 0) {
            if(check == true) {
                sql += " and";
            }
            sql += " birthday like '%" + year + "%'";
            check = true;
        }
        
        // タイプ入力あり
        if(type1 != null || type2 != null || type3 != null) {
            if(check == true) {
                sql += " and";
            }
            sql += " type in (";
            if(type1 != null) {
                sql += "'1'";
                check2 = true;
            }
            if(type2 != null) {
                if(check2 == true) {
                    sql += ", ";
                }
                sql += "'2'";
                check2 = true;
            }
            if(type3 != null) {
                if(check2 == true) {
                    sql += ", ";
                }
                sql += "'3'";
            }
            sql += ")";
        }
        
        try {
            
            con = DBManager.getConnection();
            st =  con.prepareStatement(sql);
            data = st.executeQuery();
            
            while(data.next()) {
                udb.setIDs(data.getInt("userID"));
                udb.setNames(data.getString("name"));
                udb.setYears(data.getString("birthday").substring(0,4)); // yyyy-MM-ddのyyyyを取り出し
                udb.setTypes(data.getInt("type"));
                udb.setNewDates(data.getString("newDate"));
            }
            return udb;
            
        } catch(SQLException e) {
            
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }

    }
    
    
    // IDから他の情報を取得
    public UserDataBeans select(String id) throws SQLException{
        
        UserDataBeans udb = new UserDataBeans();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet data = null;
        String sql = "select * from user_t where userID = " + id ;
        
        try {
            
            con = DBManager.getConnection();
            st =  con.prepareStatement(sql);
            data = st.executeQuery();
            
            // 取得した情報をudbに保存
            while(data.next()) {
                udb.setID(data.getInt("userID"));
                udb.setName(data.getString("name"));
                udb.setBirthday(data.getString("birthday"));
                udb.setTell(data.getString("tell"));
                udb.setType(data.getInt("type"));
                udb.setComment(data.getString("comment"));
                udb.setNewDate(data.getTimestamp("newDate"));
            }
            
            return udb;
            
        } catch(SQLException e) {
            
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }

    }
    
    
    // 追加
    public void insert(UserDataDTO ud) throws SQLException{
        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "INSERT INTO user_t(name, birthday, tell, type, comment, newDate) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            
            con = DBManager.getConnection();
            st =  con.prepareStatement(sql);
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            
        } catch(SQLException e) {
            
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }

    }
    
    
    // 編集
    public void update(UserDataDTO userdata) throws SQLException{
        
        Connection con = null;
        PreparedStatement st = null;
        String sql = "update user_t set name = ?, birthday = ?, tell = ?, type = ?, comment = ?, newDate = ? where userID = ?";
        try {
            
            con = DBManager.getConnection();
            st =  con.prepareStatement(sql);
            st.setString(1, userdata.getName());
            st.setDate(2, new java.sql.Date(userdata.getBirthday().getTime()));
            st.setString(3, userdata.getTell());
            st.setInt(4, userdata.getType());
            st.setString(5, userdata.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, userdata.getUserID());
            st.executeUpdate();
            
        } catch(SQLException e) {
            
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }

    }
    
    
    // 削除
    public void delete(UserDataDTO userdata) throws SQLException{
        
        Connection con = null;
        PreparedStatement st = null;
        String sql = "delete from user_t where userID = ?";
        
        try {
            
            con = DBManager.getConnection();
            st =  con.prepareStatement(sql);
            st.setInt(1, userdata.getUserID());
            

            
            st.executeUpdate();
            
        } catch(SQLException e) {
            
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }

    }
    
    
}
