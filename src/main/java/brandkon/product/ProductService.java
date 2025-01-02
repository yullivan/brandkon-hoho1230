package brandkon.product;

import brandkon.brand.BrandRepository;
import brandkon.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;
    BrandRepository brandRepository;
    CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }


    List<ProductResponse> showAll(){
       return productRepository.findAll()
               .stream()
               .map(product -> new ProductResponse(
                       product.getId(),
                       product.getBrand().getName(),
                       product.getProductName(),
                       product.getPrice(),
                       product.getImageUrl()
               )).toList();
    }
    ProductResponse showId(Long id){
        Product product = productRepository.findById(id).orElseThrow();
        return new ProductResponse(product.getId(),
                product.getBrand().getName(),
                product.getProductName(),
                product.getPrice(),
                product.getImageUrl());
    }
    List<ProductResponse> showPopular(Long id){
        return productRepository.findById(id)
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getBrand().getName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl()
                )).toList();
    }

    List<ProductResponse> showBrandId(Long brandid) {
        return productRepository.findByBrandId(brandid)
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getBrand().getName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl()
                )).toList();

    }
}
