package brandkon.brand;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController {
    BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @GetMapping("/brands")
    public List<BrandResponse> showAll(@RequestParam(required = false) String categorySlug){
        if(categorySlug!=null) {
            return service.showCategory(categorySlug);
        }else return service.showAll();
    }
    @GetMapping("/brands/{brandId}")
    public BrandResponse showId(@PathVariable Long brandId){
        return service.showId(brandId);
    }
}
