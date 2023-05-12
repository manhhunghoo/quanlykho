package com.example.quanlykhodemo.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblProduct")
public class Product {
    @Id
    private String maxe;
    @Column(nullable = false,unique = true)
    private String tenxe;
    private Double giaxe;

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    private String makho;
    private int soluong;

    public Product(String maxe, String tenxe, Double giaxe, String makho, int soluong) {
        this.maxe = maxe;
        this.tenxe = tenxe;
        this.giaxe = giaxe;
        this.makho = makho;
        this.soluong = soluong;
    }

    public Product() {
    }


    @Override
    public String toString() {
        return "Product{" +
                "maxe='" + maxe + '\'' +
                ", tenxe='" + tenxe + '\'' +
                ", giaxe=" + giaxe +
                ", makho='" + makho + '\'' +
                ", soluong=" + soluong +
                '}';
    }




    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public Double getGiaxe() {
        return giaxe;
    }

    public void setGiaxe(Double giaxe) {
        this.giaxe = giaxe;
    }

    public String getMakho() {
        return makho;
    }

    public void setMakho(String makho) {
        this.makho = makho;
    }

}

