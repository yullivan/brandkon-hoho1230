package brandkon.brand;

import brandkon.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    BrandRepository repository;
    CategoryRepository categoryRepository;

    public BrandService(BrandRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
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
        return repository.findByCategory(name)
                .stream()
                .map(brand -> new BrandResponse(
                        brand.getId(),
                        brand.getName(),
                        brand.getImageUrl()
                )).toList();
    }

    BrandResponse showId(Long id){
        Brand brand = repository.findById(id).orElseThrow();
        return new BrandResponse(brand.getId(), brand.getName(), brand.getImageUrl());
    }
}
