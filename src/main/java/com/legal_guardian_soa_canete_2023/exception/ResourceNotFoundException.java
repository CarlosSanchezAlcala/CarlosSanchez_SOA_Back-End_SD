package com.legal_guardian_soa_canete_2023.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Resource Not Found Exception";

    public ResourceNotFoundException(String detail) {
        super(String.format("%s - %s", DESCRIPTION, detail));
    }
}
