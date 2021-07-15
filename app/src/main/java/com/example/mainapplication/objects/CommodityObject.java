package com.example.mainapplication.objects;

public class CommodityObject
{
    private String phoneNumber;
    private String name;
    private int price;
    private String category;
    private String image;
    private String customer;
    private String seller;

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
