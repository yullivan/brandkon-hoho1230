package brandkon.brand;

import brandkon.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    //List<Brand> findByCategoryId(Long id);
    //List<Brand> findByCategorySlug(String slug);

//    @Query("SELECT b FROM Brand b JOIN b.brandCategories bc JOIN bc.category c WHERE c.slug = :slug")
//    List<Brand> findByCategorySlug(@Param("slug") String slug);
//}
}
