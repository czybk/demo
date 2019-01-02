package main.java.com.fly.decorator;

/**
 * User: Administrator
 * Date: 2018/12/10
 * Time: 16:30
 */
public class Item {
    private Integer id;
    private Integer productID;

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Item(Integer id, Integer productID){
        this.id = id;
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", productID=" + productID +
                '}';
    }
}
