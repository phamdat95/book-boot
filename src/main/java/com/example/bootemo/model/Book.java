package com.example.bootemo.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 10,max = 10,message = "need 10 character")
    private String bookCode;
    @Min(1)
    private double price;
    @Min(value = 1)
    @Max(value = 3)
    private int status;
    @Min(0)
    private int discount;
    private String company;
    @Min(0)
    private int number;
    private String desciption;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book() {
    }

    public Book(@NotEmpty @Size(min = 10, max = 11) String bookCode, @Min(value = 0) double price, @Min(value = 1) @Max(value = 3) int status, @Min(0) int discount, String company, @Min(0) int number, String desciption, Category category) {
        this.bookCode = bookCode;
        this.price = price;
        this.status = status;
        this.discount = discount;
        this.company = company;
        this.number = number;
        this.desciption = desciption;
        this.category = category;
    }
}
