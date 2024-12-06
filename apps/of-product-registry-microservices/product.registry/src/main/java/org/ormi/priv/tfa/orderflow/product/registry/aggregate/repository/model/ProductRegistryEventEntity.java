package org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "product_registry_events")
public abstract class ProductRegistryEventEntity {
  private ObjectId id;
  private String eventId;
  private String eventType = getEventType();
  private String aggregateRootId;
  private long version;
  private long timestamp;

  /**
   * Get the event id.
   * 
   * @return The event id.
   */
  public ObjectId getId() {
    return id;
  }

  /**
   * Set the event id.
   * 
   * @param id The event id.
   */
  public void setId(ObjectId id) {
    this.id = id;
  }

  /**
   * Get the event id.
   * 
   * @return The event id.
   */
  public String getEventId() {
    return eventId;
  }

  /**
   * Set the event id.
   * 
   * @param eventId The event id.
   */
  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  /**
   * Get the event type.
   * 
   * @return The event type.
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * Set the event type.
   * 
   * @param eventType The event type.
   */
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  /**
   * Get the aggregate root id.
   * 
   * @return The aggregate root id.
   */
  public String getAggregateRootId() {
    return aggregateRootId;
  }

  /**
   * Set the aggregate root id.
   * 
   * @param aggregateRootId The aggregate root id.
   */
  public void setAggregateRootId(String aggregateRootId) {
    this.aggregateRootId = aggregateRootId;
  }

  /**
   * Get the version.
   * 
   * @return The version.
   */
  public long getVersion() {
    return version;
  }

  /**
   * Set the version.
   * 
   * @param version The version.
   */
  public void setVersion(long version) {
    this.version = version;
  }

  /**
   * Get the timestamp.
   * 
   * @return The timestamp.
   */
  public long getTimestamp() {
    return timestamp;
  }

  /**
   * Set the timestamp.
   * 
   * @param timestamp The timestamp.
   */
  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}