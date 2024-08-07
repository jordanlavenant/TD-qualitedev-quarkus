package org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.event.ProductRegistered;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.event.ProductRemoved;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.event.ProductUpdated;
import org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model.ProductRegisteredEventEntity;
import org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model.ProductRemovedEventEntity;
import org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model.ProductUpdatedEventEntity;

@Mapper
public interface ProductRegistryEventPayloadMapper {
  
  @Named("productRegisteredEventPayloadToEntity")
  @Mapping(target = "productId", source = "productId")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "productDescription", source = "productDescription")
  public ProductRegisteredEventEntity.Payload toEntity(ProductRegistered.Payload eventPayload);

  @Named("productRegisteredEventPayloadtoEvent")
  @Mapping(target = "productId", source = "productId")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "productDescription", source = "productDescription")
  public ProductRegistered.Payload toEvent(ProductRegisteredEventEntity.Payload entityPayload);

  @Named("productUpdatedEventEntityToEntity")
  @Mapping(target = "productId", source = "productId")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "productDescription", source = "productDescription")
  public ProductUpdatedEventEntity.Payload toDto(ProductUpdated.Payload eventPayload);

  @Named("productUpdatedEventPayloadToEvent")
  @Mapping(target = "productId", source = "productId")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "productDescription", source = "productDescription")
  public ProductUpdated.Payload toEntity(ProductUpdatedEventEntity.Payload entityPayload);

  @Named("productRemovedEventPayloadToEntity")
  @Mapping(target = "productId", source = "productId")
  public ProductRemovedEventEntity.Payload toEntity(ProductRemoved.Payload eventPayload);

  @Named("productRemovedEventPayloadToEvent")
  @Mapping(target = "productId", source = "productId")
  public ProductRemoved.Payload toEvent(ProductRemovedEventEntity.Payload entityPayload);
}
