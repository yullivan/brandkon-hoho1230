package brandkon.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping("/products")
    public List<ProductResponse> showAll(@RequestParam(required = false) Long brandId){
        if(brandId!=null){
            return service.showBrandId(brandId);
        }
        return service.showAll();
    }
    @GetMapping("/products/popular")
    public List<ProductResponse> showPopular(@RequestParam(required = false) Long categoryId
            ,@RequestParam(required = false) Long brandId){
        if(categoryId!=null) {
            return service.showCategoryPopular(categoryId);
        }else if(brandId!=null) {
            return service.showBrandPopular(brandId);
        }else return service.showAll();


    }
    @GetMapping("/products/{productId}")
    public ProductDetailResponse showId(@PathVariable Long productId){
        return service.showId(productId);
    }

}
