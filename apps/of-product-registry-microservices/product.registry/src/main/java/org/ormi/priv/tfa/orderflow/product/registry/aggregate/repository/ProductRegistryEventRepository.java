package org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

import org.ormi.priv.tfa.orderflow.lib.event.sourcing.store.EventStore;
import org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model.ProductRegistryEventEntity;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class ProductRegistryEventRepository
    implements EventStore<ProductRegistryEventEntity>,
    PanacheMongoRepository<ProductRegistryEventEntity> {

  /**
   * Save the event.
   * 
   * @param event The event to save.
   */
  @Override
  public void saveEvent(ProductRegistryEventEntity event) {
    persist(event);
  }

  /**
   * Find the events for the aggregate root id.
   * 
   * @param aggregateRootId The aggregate root id.
   * @param startingVersion The starting version.
   * @return The events for the aggregate root id.
   */
  @Override
  public List<ProductRegistryEventEntity> findEventsByAggregateRootIdAndStartingVersion(String aggregateRootId,
      long startingVersion) {
    return find(
        "aggregateRootId = ?1 and version > ?2",
        aggregateRootId,
        startingVersion,
        Sort.by("version"))
        .list();
  }

}
