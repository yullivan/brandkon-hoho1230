package brandkon.product;

import brandkon.brand.Brand;
import brandkon.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByBrandId(Long BrandId);
    //List<Product> findByBrand_Category_Id(Long categoryId);
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);
}
