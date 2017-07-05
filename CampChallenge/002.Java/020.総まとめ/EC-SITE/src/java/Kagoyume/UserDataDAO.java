
package Kagoyume;

import base.DBManager;
import java.sql.*;
import java.util.HashMap;

public class UserDataDAO {
    
    public static UserDataDAO getInstance() {
        return new UserDataDAO();
    }
    
    // ログインチェック
    public boolean login(String loginUserName, String loginPassword) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select name, password, deleteFlg from user_t";
        
        try {
            
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                if(rs.getString("deleteFlg").equals("0")) {
                    if(loginUserName.equals(rs.getString("name")) && loginPassword.equals(rs.getString("password"))) {
                        return true;
                    }
                }
            }
            return false;
            
        } catch(SQLException e) {
            
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }
        
    }
    
    // UserID取得
    public JavaBeans getUserID(String loginUserName, JavaBeans jb) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select userID from user_t where name ='" + loginUserName + "'";
        try {
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                jb.setUserID(rs.getString("userID"));
            }
            return jb;
        } catch(SQLException e) {
            throw new SQLException(e);
        } finally {
            if(con != null) {
                con.close();
            }
        }
    }
    
    
    // ユーザーidから詳細情報取得（更新用に取得）
    public JavaBeans getUserData(String userID, JavaBeans jb) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select name, password, mail, address from user_t where userID ='" + userID + "'";
        
        try {
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                jb.setLoginUserName(rs.getString("name"));
                jb.setLoginPassword(rs.getString("password"));
                jb.setMail(rs.getString("mail"));
                jb.setAddress(rs.getString("address"));
            }
            return jb;
        } catch(SQLException e) {
            throw new SQLException(e);
        } finally {
            if(con != null) {
                con.close();
            }
        }
    }
    
    
    // ユーザー名が登録済みかチェック
    public boolean checkuserName(String userName) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select name, deleteFlg from user_t";
        
        try {
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                if(rs.getString("deleteFlg").equals("0")) {
                    if(userName.equals(rs.getString("name"))) {
                        return true;
                    }
                }
            }
            return false;
            
        } catch(SQLException e) {
            
            throw new SQLException(e);
            
        } finally {
            
            if(con != null) {
                con.close();
            }
            
        }
        
    }
    
    // ユーザー追加
    public void insert(UserDataDTO udd) throws SQLException{
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO user_t(name, password, mail, address, newDate) VALUES(?, ?, ?, ?, ?)";
        
        try {
            
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            
            ps.setString(1, udd.getUserName());
            ps.setString(2, udd.getPassword());
            ps.setString(3, udd.getMail());
            ps.setString(4, udd.getAddress());
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            
        } catch(SQLException e) {
            throw new SQLException(e);
        } finally {
            if(con != null) {
                con.close();
            }   
        }
    }
    
    
    // ユーザー削除
    public void delete(UserDataDTO udd) throws SQLException{
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update user_t set deleteFlg = 1 where userID = " + udd.getUserID();
        
        try {
            
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            
            ps.executeUpdate();
            
        } catch(SQLException e) {
            throw new SQLException(e);
        } finally {
            if(con != null) {
                con.close();
            }   
        }
    }
    
    
    
    
    // 購入履歴の追加
    public void buy(UserDataDTO udd, String price) throws SQLException{
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        
        try {
            
            sql = "INSERT INTO buy_t(UserID, itemCode, type, buyDate) VALUES(?, ?, ?, ?)";
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            
            ps.setString(1, udd.getUserID());
            ps.setString(2, udd.getItemCode());
            ps.setInt(3, 1); // 未実装
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            
            sql = "update user_t set total = total + " + price + " where userID = '" + udd.getUserID() + "'";
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch(SQLException e) {
            throw new SQLException(e);
        } finally {
            if(con != null) {
                con.close();
            }   
        }
    }
    
    // 購入履歴の取得
    public HashMap<String, String> MyHistory(String userID) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select itemCode, buyDate from buy_t where userID = '" + userID + "' order by buyDate desc";
        HashMap<String,String> history = new HashMap();
        try {
            
            con = DBManager.getConnection();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                history.put(rs.getString("itemCode"), rs.getString("buyDate"));
            }
            return history;
            
        } catch(SQLException e) {
            throw new SQLException(e);
        } finally {
            if(con != null) {
                con.close();
            }   
        }
    
    }
    
}

