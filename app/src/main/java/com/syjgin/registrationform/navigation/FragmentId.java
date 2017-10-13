package com.syjgin.registrationform.navigation;

/**
 * Created by maksimovoleg on 13/10/2017.
 */

public enum FragmentId {
    FRAGMENT_ID_NAME(0),
    FRAGMENT_ID_CONTACTS(1),
    FRAGMENT_ID_ADDRESS(2),
    FRAGMENT_ID_NONE(-1);

    private int value;

    FragmentId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FragmentId valueOf(int value) {
        for (FragmentId id: FragmentId.values()) {
            if(id.value == value)
                return id;
        }
        return FRAGMENT_ID_NONE;
    }
}
