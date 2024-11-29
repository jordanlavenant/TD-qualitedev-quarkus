package org.ormi.priv.tfa.orderflow.api.gateway.productregistry.adapter.inbound.http.resource.exception;

public class ProductPulsarClientException extends RuntimeException {

    public ProductPulsarClientException(String message) {
        super(message);
    }

    public ProductPulsarClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
