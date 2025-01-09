package brandkon.brand;

import brandkon.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    List<Brand> findByCategoryId(Long id);
    List<Brand> findByCategorySlug(String slug);
}
