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
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user_t";
        
        try {
            
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                udb.setIDs(rs.getInt("userID"));
                udb.setNames(rs.getString("name"));
                udb.setYears(rs.getString("birthday").substring(0,4));
                udb.setTypes(rs.getInt("type"));
                udb.setNewDates(rs.getString("newDate"));
            }
            return udb;
            
        } catch(SQLException e) {
            
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
        PreparedStatement ps = null;
        ResultSet rs = null;
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
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                udb.setIDs(rs.getInt("userID"));
                udb.setNames(rs.getString("name"));
                udb.setYears(rs.getString("birthday").substring(0,4));
                udb.setTypes(rs.getInt("type"));
                udb.setNewDates(rs.getString("newDate"));
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
    
    
    // userIDから他の情報を取得
    public UserDataBeans select(String userID) throws SQLException{
        
        UserDataBeans udb = new UserDataBeans();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user_t where userID = " + userID ;
        
        try {
            
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            // 取得した情報をudbに保存
            while(rs.next()) {
                udb.setID(rs.getInt("userID"));
                udb.setName(rs.getString("name"));
                udb.setBirthday(rs.getString("birthday"));
                udb.setYear(Integer.parseInt(udb.getBirthday().substring(0,4)));
                udb.setMonth(Integer.parseInt(udb.getBirthday().substring(5, 7)));
                udb.setDay(Integer.parseInt(udb.getBirthday().substring(8, 10)));
                udb.setTell(rs.getString("tell"));
                udb.setType(rs.getInt("type"));
                udb.setComment(rs.getString("comment"));
                udb.setNewDate(rs.getTimestamp("newDate"));
            }
            
            return udb;
            
        } catch(SQLException e) {
            
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }

    }
    
    
    // 追加
    public UserDataBeans insert(UserDataDTO udd) throws SQLException{
        
        UserDataBeans udb = new UserDataBeans();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO user_t(name, birthday, tell, type, comment, newDate) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            
          
            
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);    
            ps.setString(1, udd.getName());
            ps.setDate(2, new java.sql.Date(udd.getBirthday().getTime()));
            ps.setString(3, udd.getTell());
            ps.setInt(4, udd.getType());
            ps.setString(5, udd.getComment());
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            
            sql = "select * from user_t where userID = @@IDENTITY";
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            // 取得した情報をudbに保存
            while(rs.next()) {
                udb.setID(rs.getInt("userID"));
                udb.setName(rs.getString("name"));
                udb.setBirthday(rs.getString("birthday"));
                udb.setYear(Integer.parseInt(udb.getBirthday().substring(0, 4)));
                udb.setMonth(Integer.parseInt(udb.getBirthday().substring(5, 7)));
                udb.setDay(Integer.parseInt(udb.getBirthday().substring(8, 10)));
                udb.setTell(rs.getString("tell"));
                udb.setType(rs.getInt("type"));
                udb.setComment(rs.getString("comment"));
                udb.setNewDate(rs.getTimestamp("newDate"));
            }
            
            return udb;
            
        } catch(SQLException e) {
            
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
        PreparedStatement ps = null;
        String sql = "update user_t set name = ?, birthday = ?, tell = ?, type = ?, comment = ?, newDate = ? where userID = ?";
        try {
            
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            ps.setString(1, userdata.getName());
            ps.setDate(2, new java.sql.Date(userdata.getBirthday().getTime()));
            ps.setString(3, userdata.getTell());
            ps.setInt(4, userdata.getType());
            ps.setString(5, userdata.getComment());
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            ps.setInt(7, userdata.getUserID());
            ps.executeUpdate();
            
        } catch(SQLException e) {
            
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }

    }
    
    
    // 削除
    public void delete(UserDataDTO udd) throws SQLException{
        
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from user_t where userID = ?";
        
        try {
            
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            ps.setInt(1, udd.getUserID());
            

            
            ps.executeUpdate();
            
        } catch(SQLException e) {
            
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }

    }
    
    // 再追加
    public void deleteCancel(UserDataDTO udd) throws SQLException{
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO user_t(userID, name, birthday, tell, type, comment, newDate) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try {
            
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            ps.setInt(1, udd.getUserID());
            ps.setString(2, udd.getName());
            ps.setDate(3, new java.sql.Date(udd.getBirthday().getTime()));
            ps.setString(4, udd.getTell());
            ps.setInt(5, udd.getType());
            ps.setString(6, udd.getComment());
            ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            
        } catch(SQLException e) {
            
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }

    }
    
    
}
