package brandkon.product;

public record ProductDetailResponse(
        Long id,
        String productName,
        Long price,
        BrandDetailResponses responses,
        int expirationDays
) {
}
