package com.aniket.distributed.local.cache.exception;

/**
 * Created by athigale on 5/12/17.
 */

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
