/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AssN7B.model;

import java.util.Objects;

/**
 *
 * @author OS
 */
public class Course {
    private String title;
    private String author;
    private int publishedYear;
    private double unitPrice;
    private int quantity;

    public Course(String title, String author, int publishedYear, double unitPrice, int quantity) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-15s | %-15s | %-15s | %-15s | ", // định dạng cái table
               title,author,publishedYear,unitPrice, quantity );
    }
    
    public double calculateTotalPrice() {
        return quantity * unitPrice;
    }

    public double calculateTransportPrice() {
        if (quantity <= 50) {
            return 0;
        } else if (quantity <= 500) {
            return 0.02 * calculateTotalPrice();
        } else {
            return 0.05 * calculateTotalPrice();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        return Objects.equals(this.title, other.title);
    }
}
