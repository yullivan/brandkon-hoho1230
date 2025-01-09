package brandkon.product;

import brandkon.brand.Brand;
import brandkon.category.Category;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Long price;
    private Long expirationDays;
    private String imageUrl;
    @ManyToOne
    private Brand brand;

    private Long saleCount;


    public Product() {
    }

    public Product(String productName, Long price, Long expirationDays, String imageUrl, Brand brand,Long saleCount) {
        this.productName = productName;
        this.price = price;
        this.expirationDays = expirationDays;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.saleCount=saleCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Long getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(Long expirationDays) {
        this.expirationDays = expirationDays;
    }

    public Long getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Long saleCount) {
        this.saleCount = saleCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(productName, product.productName) && Objects.equals(price, product.price) && Objects.equals(expirationDays, product.expirationDays) && Objects.equals(imageUrl, product.imageUrl) && Objects.equals(brand, product.brand) && Objects.equals(saleCount, product.saleCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, price, expirationDays, imageUrl, brand, saleCount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", expirationDays=" + expirationDays +
                ", imageUrl='" + imageUrl + '\'' +
                ", brand=" + brand +
                ", saleCount=" + saleCount +
                '}';
    }
}
