package AnaliseDeVendas2.entities;

import java.util.Objects;

public class Sale {
    private Integer month;
    private Integer year;
    private String seller;
    private Integer items;
    private Double total;

    public Sale() {

    }

    public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
        this.month = month;
        this.year = year;
        this.seller = seller;
        this.items = items;
        this.total = total;
    }

    //getters and setters
    public int getMonth() { return month; }
    public void setMonth(Integer month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public String getSeller() { return seller; }
    public void setSeller(String seller) { this.seller = seller; }

    public int getItems() { return items; }
    public void setItems(Integer items) { this.items = items; }

    public double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public double averagePrice() {
        return (items == 0) ? 0 : (total / items);
    }

    @Override
    public String toString() {
        return  String.format("%d/%d, %s, %.2f, pm = %.2f",
                month, year, seller, total, averagePrice());
    }
}
