package brandkon.product;

public record ProductDetailResponse(
        Long productId,
        String productName,
        Long price,
        BrandDetailResponses brand,
        Long expirationDays
) {
}
