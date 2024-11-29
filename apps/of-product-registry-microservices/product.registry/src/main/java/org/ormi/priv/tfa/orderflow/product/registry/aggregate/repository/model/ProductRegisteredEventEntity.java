package org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model;

public class ProductRegisteredEventEntity extends ProductRegistryEventEntity {
  static final String EVENT_TYPE = "ProductRegistered";

  /**
   * Payload for the event.
   */
  public static record Payload(
      String productId,
      String name,
      String productDescription) {
  }

  /**
   * The payload for the event.
   */
  public Payload payload;

  /**
   * Get the event type.
   * 
   * @return The event type.
   */
  @Override
  public String getEventType() {
    return EVENT_TYPE;
  }
}
