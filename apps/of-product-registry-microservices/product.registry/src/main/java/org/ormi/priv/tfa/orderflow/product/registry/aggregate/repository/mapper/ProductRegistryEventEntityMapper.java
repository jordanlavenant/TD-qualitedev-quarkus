package org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.event.ProductRegistered;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.event.ProductRemoved;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.event.ProductUpdated;
import org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model.ProductRegisteredEventEntity;
import org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model.ProductRemovedEventEntity;
import org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model.ProductUpdatedEventEntity;

@Mapper(uses = {ProductRegistryEventPayloadMapper.class})
public interface ProductRegistryEventEntityMapper {

  ProductRegistryEventEntityMapper INSTANCE = Mappers.getMapper(ProductRegistryEventEntityMapper.class);

  @Mapping(target = "eventId", source = "id")
  @Mapping(target = "eventType", source = "eventType")
  @Mapping(target = "aggregateRootId", source = "aggregateId")
  @Mapping(target = "version", source = "version")
  @Mapping(target = "timestamp", source = "timestamp")
  @Mapping(target = "payload", source = "payload", qualifiedByName = "productRegisteredEventPayloadToEntity")
  ProductRegisteredEventEntity toEntity(ProductRegistered evt);

  @Mapping(target = "id", source = "eventId")
  @Mapping(target = "eventType", source = "eventType")
  @Mapping(target = "aggregateId", source = "aggregateRootId")
  @Mapping(target = "version", source = "version")
  @Mapping(target = "timestamp", source = "timestamp")
  @Mapping(target = "payload", source = "payload", qualifiedByName = "productRegisteredEventPayloadToEvent")
  ProductRegistered toEvent(ProductRegisteredEventEntity entity);

  @Mapping(target = "eventId", source = "id")
  @Mapping(target = "eventType", source = "eventType")
  @Mapping(target = "aggregateRootId", source = "aggregateId")
  @Mapping(target = "version", source = "version")
  @Mapping(target = "timestamp", source = "timestamp")
  @Mapping(target = "payload", source = "payload", qualifiedByName = "productUpdatedEventEntityToEntity")
  ProductUpdatedEventEntity toEntity(ProductUpdated evt);

  @Mapping(target = "id", source = "eventId")
  @Mapping(target = "eventType", source = "eventType")
  @Mapping(target = "aggregateId", source = "aggregateRootId")
  @Mapping(target = "version", source = "version")
  @Mapping(target = "timestamp", source = "timestamp")
  @Mapping(target = "payload", source = "payload", qualifiedByName = "productUpdatedEventPayloadToEvent")
  ProductUpdated toEvent(ProductUpdatedEventEntity entity);

  @Mapping(target = "eventId", source = "id")
  @Mapping(target = "eventType", source = "eventType")
  @Mapping(target = "aggregateRootId", source = "aggregateId")
  @Mapping(target = "version", source = "version")
  @Mapping(target = "timestamp", source = "timestamp")
  @Mapping(target = "payload", source = "payload", qualifiedByName = "productRemovedEventPayloadToEntity")
  ProductRemovedEventEntity toEntity(ProductRemoved evt);

  @Mapping(target = "id", source = "eventId")
  @Mapping(target = "eventType", source = "eventType")
  @Mapping(target = "aggregateId", source = "aggregateRootId")
  @Mapping(target = "version", source = "version")
  @Mapping(target = "timestamp", source = "timestamp")
  @Mapping(target = "payload", source = "payload", qualifiedByName = "productRemovedEventPayloadToEvent")
  ProductRemoved toEvent(ProductRemovedEventEntity entity);
}
