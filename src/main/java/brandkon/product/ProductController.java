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
    public List<ProductResponse> showAll(@RequestParam(required = false) Long Brandid){
        if(Brandid!=null){
            return service.showBrandId(Brandid);
        }
        return service.showAll();
    }
    @GetMapping("/products/popular")
    public List<ProductResponse> showPopular(@RequestParam Long id){
        return service.showPopular(id);
    }
    @GetMapping("/products")
    public ProductResponse showId(@PathVariable Long id){
        return service.showId(id);
    }

}
