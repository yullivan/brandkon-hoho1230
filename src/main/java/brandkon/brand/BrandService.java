package brandkon.brand;

import brandkon.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    BrandRepository repository;
    CategoryRepository categoryRepository;
    BrandCategoryRepository bcRepository;

    public BrandService(BrandRepository repository, CategoryRepository categoryRepository, BrandCategoryRepository bcRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.bcRepository = bcRepository;
    }

    List<BrandResponse> showAll(){
       return repository.findAll()
               .stream()
               .map(brand -> new BrandResponse(
                       brand.getId(),
                       brand.getName(),
                       brand.getImageUrl()
               )).toList();
    }
    List<BrandResponse> showCategory(String name){
        List<BrandCategory> byCategorySlug = bcRepository.findByCategorySlug(name);
        return byCategorySlug
                .stream()
                .map(brand -> new BrandResponse(
                        brand.getBrand().getId(),
                        brand.getBrand().getName(),
                        brand.getBrand().getImageUrl()
                )).toList();
    }

    BrandResponse showId(Long id){
        Brand brand = repository.findById(id).orElseThrow();
        return new BrandResponse(brand.getId(), brand.getName(), brand.getImageUrl());
    }
}
