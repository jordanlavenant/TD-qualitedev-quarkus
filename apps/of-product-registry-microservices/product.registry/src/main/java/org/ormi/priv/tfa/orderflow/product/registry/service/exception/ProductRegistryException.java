package org.ormi.priv.tfa.orderflow.product.registry.service.exception;

public class ProductRegistryException extends RuntimeException {

    public ProductRegistryException(String message) {
        super(message);
    }

    public ProductRegistryException(String message, Throwable cause) {
        super(message, cause);
    }

}
