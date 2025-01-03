package brandkon.product;

public record ProductResponse(
        Long id,
        String brandName,
        String productName,
        Long price,
        String imageUrl
){
}
