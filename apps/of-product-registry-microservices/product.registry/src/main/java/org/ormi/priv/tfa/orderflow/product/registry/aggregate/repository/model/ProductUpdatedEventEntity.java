package org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model;

public class ProductUpdatedEventEntity extends ProductRegistryEventEntity {
  static final String EVENT_TYPE = "ProductUpdated";

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
  private Payload payload;

  /**
   * Get the payload for the event.
   * 
   * @return The payload for the event.
   */
  public Payload getPayload() {
    return payload;
  }

  /**
   * Set the payload for the event.
   * 
   * @param payload The payload for the event.
   */
  public void setPayload(Payload payload) {
    this.payload = payload;
  }

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
