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
    public List<BrandResponse> showAll(@RequestParam(required = false) String categoryName){
        if(categoryName!=null) {
            return service.showCategory(categoryName);
        }else return service.showAll();
    }
    @GetMapping("/brands")
    public BrandResponse showId(@PathVariable Long id){
        return service.showId(id);
    }
}
