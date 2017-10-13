package com.syjgin.registrationform.model;

/**
 * Created by maksimovoleg on 13/10/2017.
 */

public class ValidationEvent {
    private boolean isValidationSuccess;

    public boolean isValidationSuccess() {
        return isValidationSuccess;
    }

    public ValidationEvent(boolean success) {
        isValidationSuccess = success;
    }
}
