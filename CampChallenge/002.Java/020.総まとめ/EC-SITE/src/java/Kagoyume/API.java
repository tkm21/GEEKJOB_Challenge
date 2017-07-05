
package Kagoyume;

import java.io.*;
import java.net.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public class API {
    
    // yahooShoppingURL
    static String yahooShoppingURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/";
    // apiID
    static String apiID = "dj0zaiZpPVQwMmJlQ2tWekI0aiZzPWNvbnN1bWVyc2VjcmV0Jng9Mjg-";
    
    
    // 商品検索
    public static ArrayList<SearchDataBeans> getResult(String query, String category){
        
        // SearchDataBeans
        ArrayList<SearchDataBeans> al = new ArrayList(); 
        
        try {
            
            // keywordをurl用の文字列に変換
            String query4url = URLEncoder.encode(query, "UTF-8");
            
            // jsonを取得するurlの作成
            URL url = new URL(yahooShoppingURL + "itemSearch?appid=" + apiID + "&query=" + query4url + "&category_id=" + category);
            
            // url接続
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            
            InputStreamReader is = new InputStreamReader(con.getInputStream());
            BufferedReader br = new BufferedReader(is);
            String tmp;
            String result = "";
            while ((tmp = br.readLine()) != null) {
                result += tmp;
            }
            
            // resultの解析
            JsonFactory jf = new JsonFactory();
            JsonParser jp = jf.createParser(result);
            ObjectMapper om = new ObjectMapper();
            JsonNode jn = om.readTree(jp);
            
            
            for (int i = 0; i < 20; i ++) {
                SearchDataBeans srb = new SearchDataBeans();
                String num = String.valueOf(i);
                srb.setProductName(jn.get("ResultSet").get("0").get("Result").get(num).get("Name").textValue());
                srb.setProductPrice(jn.get("ResultSet").get("0").get("Result").get(num).get("Price").get("_value").textValue());
                srb.setProductImage(jn.get("ResultSet").get("0").get("Result").get(num).get("Image").get("Medium").textValue());
                srb.setProductCode(jn.get("ResultSet").get("0").get("Result").get(num).get("Code").textValue());
                al.add(srb);
            }
            
            // url接続終了
            br.close();
            con.disconnect();
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        return al;
    }
    
    // 商品コードから詳細取得
    public static SearchDataBeans getDetail(String productCord) {
        
        SearchDataBeans sdb = new SearchDataBeans();
        
        try{
            
            // jsonを取得するurlの作成
            URL url = new URL(yahooShoppingURL + "itemLookup?appid=" + apiID + "&itemcode=" + productCord + "&responsegroup=large");
            
            // url接続
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            
            InputStreamReader is = new InputStreamReader(con.getInputStream());
            BufferedReader br = new BufferedReader(is);
            String tmp;
            String result = "";
            while ((tmp = br.readLine()) != null) {
                result += tmp;
            }
            
            // resultの解析
            JsonFactory jf = new JsonFactory();
            JsonParser jp = jf.createParser(result);
            ObjectMapper om = new ObjectMapper();
            JsonNode jn = om.readTree(jp);
            
            // 商品情報保存
            sdb.setProductName(jn.get("ResultSet").get("0").get("Result").get("0").get("Name").textValue());
            sdb.setProductPrice(jn.get("ResultSet").get("0").get("Result").get("0").get("Price").get("_value").textValue());
            sdb.setProductImage(jn.get("ResultSet").get("0").get("Result").get("0").get("Image").get("Medium").textValue());
            sdb.setProductCode(jn.get("ResultSet").get("0").get("Result").get("0").get("Code").textValue());
            sdb.setProductDescription(jn.get("ResultSet").get("0").get("Result").get("0").get("Description").textValue());
            sdb.setProductRate(jn.get("ResultSet").get("0").get("Result").get("0").get("Review").get("Rate").textValue());
            
            // url接続終了
            br.close();
            con.disconnect();
            
            }catch(Exception e){
                
                e.printStackTrace();
                
            }
        return sdb;
    }
    
    public static int getAmount(JsonNode node){
        return node.get("Resultset").get("totalResultsReturned").intValue();
    }
    
    
    
    
}