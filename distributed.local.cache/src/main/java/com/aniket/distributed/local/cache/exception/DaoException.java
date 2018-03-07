package com.aniket.distributed.local.cache.exception;

public class DaoException extends Exception {
    private String message;
    private Throwable throwable;

    public DaoException(String message) {
        this.message = message;
    }

    public DaoException(String message, Throwable th) {
        this.message = message;
        this.throwable = th;
    }

    public DaoException(Throwable th) {
        this.throwable = th;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DaoException{");
        sb.append("message='").append(message).append('\'');
        sb.append(", throwable=").append(throwable);
        sb.append('}');
        return sb.toString();
    }
}