
package Kagoyume;

public class SearchDataBeans {
    
    // newで実行
    public SearchDataBeans(){
        this.productName = "";
        this.productPrice = "";
        this.productCode = "";
        this.productImage = "";
        this.productDescription = "";
        this.productRate = "";
    }
    
    // 商品名
    private String productName;
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }
    
    // 商品価格
    private String productPrice;
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    public String getProductPrice() {
        return productPrice;
    }
    
    // 商品コード
    private String productCode;
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductCode() {
        return productCode;
    }
    
    // 商品画像
    private String productImage;
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
    public String getProductImage() {
        return productImage;
    }
    
    // 商品説明
    private String productDescription;
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public String getProductDescrition() {
        return productDescription;
    }
    
    // 商品評価
    private String productRate;
    public void setProductRate(String productRate) {
        this.productRate = productRate;
    }
    public String getProductRate() {
        return productRate;
    }
    
    
    
}
