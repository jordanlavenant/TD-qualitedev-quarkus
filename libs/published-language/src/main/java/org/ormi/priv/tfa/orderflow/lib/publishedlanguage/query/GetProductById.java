package org.ormi.priv.tfa.orderflow.lib.publishedlanguage.query;

import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.valueobject.ProductId;

/**
 * Query to get product by id.
 */
public final class GetProductById implements ProductRegistryQuery {
  public interface GetProductByIdResult extends ProductRegistryQueryResult {
  }

  /**
   * Product id to base the query on.
   */
  private final ProductId productId;

  /**
   * Create a new instance of the query.
   * 
   * @param productId the product id
   */
  public GetProductById(ProductId productId) {
    this.productId = productId;
  }

  /**
   * Get the product id.
   * 
   * @return the product id
   */
  public ProductId getProductId() {
    return productId;
  }
}
