package com.example.mainapplication.objects;

public class CommodityObject
{
    private String name;
    private int price;
    private String category;
    private String image;
    private String customer;
    private String seller;
    private String admin;

    public void setName(String name) {
        this.name = name;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getAdmin() {
        return admin;
    }

    public String getCategory() {
        return category;
    }

    public String getCustomer() {
        return customer;
    }

    public String getImage() {
        return image;
    }

    public String getSeller() {
        return seller;
    }
}
