package brandkon.product;

import brandkon.brand.Brand;
import brandkon.brand.BrandRepository;
import brandkon.category.Category;
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
    ProductDetailResponse showId(Long id){

        Product product = productRepository.findById(id).orElseThrow();
        Brand brand = brandRepository.findById(product.getBrand().getId()).orElseThrow();
        return new ProductDetailResponse(product.getId(),
                product.getBrand().getName(),
                product.getPrice(),
                new BrandDetailResponses(brand.getId(), brand.getName(), brand.getGuideLines()),
                product.getExpirationDays());
    }
    List<ProductResponse> showCategoryPopular(Long id){
        Category category = categoryRepository.findById(id).orElseThrow();
        return  productRepository.findByBrand_Category_Id(category.getId()).stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getBrand().getName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl()
                )).toList();
    }
    List<ProductResponse> showBrandPopular(Long id){
        Brand brand = brandRepository.findById(id).orElseThrow();
        return  productRepository.findByBrandId(brand.getId()).stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getBrand().getName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl()
                )).toList();
    }

    List<ProductResponse> showBrandId(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow();
        return productRepository.findByBrandId(brand.getId())
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
