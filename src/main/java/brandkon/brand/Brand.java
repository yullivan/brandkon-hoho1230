package brandkon.brand;

import brandkon.category.Category;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imageUrl;
    @ManyToOne
    private Category category;
    private String guideLines;

    public Brand(String name, String imageUrl, Category category, String guideLines) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.guideLines = guideLines;
    }

    public Brand() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGuideLines() {
        return guideLines;
    }

    public void setGuideLines(String guideLines) {
        this.guideLines = guideLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id) && Objects.equals(name, brand.name) && Objects.equals(imageUrl, brand.imageUrl) && Objects.equals(category, brand.category) && Objects.equals(guideLines, brand.guideLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageUrl, category, guideLines);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category=" + category +
                ", guideLines='" + guideLines + '\'' +
                '}';
    }
}
