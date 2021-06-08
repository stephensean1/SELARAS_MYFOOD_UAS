package umn.ac.id.Models;

import umn.ac.id.Database.SQLiteHelper;
import umn.ac.id.Adapter.CartListAdapter;
import umn.ac.id.CartList;
import umn.ac.id.FoodDetail;

public class Cart {
    private int id;
    private String name;
    private String quantity;
    private String price;

    public Cart(int id, String name, String quantity, String price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
