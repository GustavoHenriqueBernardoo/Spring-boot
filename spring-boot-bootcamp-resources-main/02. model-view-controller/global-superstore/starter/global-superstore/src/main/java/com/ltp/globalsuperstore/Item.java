package com.ltp.globalsuperstore;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Item {
  private String category;
  private String name;
  private double price;
  private double discount;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;

  public Item(String category, String name, double price, double discount, Date date) {
    this.category = category;
    this.name = name;
    this.price = price;
    this.discount = discount;
    this.date = date;
  }

  public Item() {

  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getDiscount() {
    return this.discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "{" +
        " category='" + getCategory() + "'" +
        ", name='" + getName() + "'" +
        ", price='" + getPrice() + "'" +
        ", discount='" + getDiscount() + "'" +
        ", date='" + getDate() + "'" +
        "}";
  }

}
