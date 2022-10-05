package com.ltp.globalsuperstore;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class Item {
  private String category;
  private String name;
  private double price;
  private double discount;
  private String id;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;

  public Item() {
    this.id = UUID.randomUUID().toString();
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
