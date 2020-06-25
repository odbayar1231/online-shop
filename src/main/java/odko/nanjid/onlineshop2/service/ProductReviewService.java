package odko.nanjid.onlineshop2.service;


import odko.nanjid.onlineshop2.domain.ProductReview;

import java.util.List;

public interface ProductReviewService {
    public List<ProductReview> getAll();
    public ProductReview save(ProductReview product);
    public ProductReview find(Long id);
    public ProductReview saveReviewToProduct(ProductReview productReview, Long productId);
}
