package umn.ac.id.Models;

public class Food {
    final private int NO_IMAGE = -1;
    private String foodName;
    public void setType(String type) {
        this.type = type;
    }
    private String type;
    private int mImageResouce = NO_IMAGE;
    private int foodPrice;

    public Food(String foodName, String type, int mImageResouce, int foodPrice) {
        this.foodName = foodName;
        this.type = type;
        this.mImageResouce = mImageResouce;
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }
    public String getType() {
        return type;
    }
    public int getmImageResouce() {
        return mImageResouce;
    }
    public int getFoodPrice() {
        return foodPrice;
    }

    /*public int getNO_IMAGE() {
        return NO_IMAGE;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public void setmImageResouce(int mImageResouce) {
        this.mImageResouce = mImageResouce;
    }
    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }*/
}

