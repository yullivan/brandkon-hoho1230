package brandkon.brand;

import brandkon.category.Category;
import jakarta.persistence.*;

@Entity
public class BrandCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    //@JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    //@JoinColumn(name = "category_id")
    private Category category;


    public BrandCategory() {
    }

    public BrandCategory(Brand brand, Category category) {
        this.brand = brand;
        this.category = category;
    }



    public Long getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public Category getCategory() {
        return category;
    }
}
