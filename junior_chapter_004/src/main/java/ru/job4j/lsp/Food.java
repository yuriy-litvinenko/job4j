package ru.job4j.lsp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

abstract class Food {
    private String name;
    private Calendar createDate;
    private Calendar expireDate;
    private double price;
    private double discount;

    Food(String name, Calendar createDate, Calendar expireDate, double price, double discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    void useDiscount() {
        this.price = this.price - this.discount;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "Food{" + "name='" + name + '\''
                + ", createDate=" + sdf.format(createDate.getTime())
                + ", expireDate=" + sdf.format(expireDate.getTime())
                + ", price=" + price
                + ", discount=" + discount + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public void setExpireDate(Calendar expireDate) {
        this.expireDate = expireDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    Calendar getCreateDate() {
        return createDate;
    }

    Calendar getExpireDate() {
        return expireDate;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0
                && Double.compare(food.discount, discount) == 0
                && name.equals(food.name)
                && createDate.equals(food.createDate)
                && expireDate.equals(food.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expireDate, price, discount);
    }
}
