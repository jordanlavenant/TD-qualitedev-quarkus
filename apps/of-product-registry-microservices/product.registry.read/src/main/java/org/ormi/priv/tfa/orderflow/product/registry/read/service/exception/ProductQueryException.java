package org.ormi.priv.tfa.orderflow.product.registry.read.service.exception;

public class ProductQueryException extends RuntimeException {

    public ProductQueryException(String message) {
        super(message);
    }

    public ProductQueryException(String message, Throwable cause) {
        super(message, cause);
    }
}
