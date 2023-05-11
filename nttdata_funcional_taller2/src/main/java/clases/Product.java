package clases;

import java.math.BigDecimal;

enum Tax {
    SUPERREDUCED(4),
    REDUCED(10),
    NORMAL(21);

    private int percent;

    Tax(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }
}

class Product {
    private String name;
    private BigDecimal price;
    private Tax tax;

    public Product(String name, BigDecimal price, Tax tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }
}
