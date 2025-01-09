package brandkon.product;

import brandkon.brand.Brand;
import brandkon.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByBrandId(Long BrandId);
    List<Product> findByBrand_Category_Id(Long categoryId);
}
