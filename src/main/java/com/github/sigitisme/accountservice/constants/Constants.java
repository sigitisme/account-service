package com.github.sigitisme.accountservice.constants;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final int SUCCESS = 1;
    public static final int REVERSED = 2;
    public static final int INVALID_ACCOUNT = 3;
    public static final int ACCOUNT_IS_NOT_ACTIVE = 4;
    public static final int INSUFFICIENT_AMOUNT = 5;

    public static final Map<Integer, String> STATUS_DESCRIPTION = new HashMap<Integer, String>(){
        {
            put(SUCCESS, "SUCCESS");
            put(REVERSED, "REVERSED");
            put(INVALID_ACCOUNT, "INVALID_ACCOUNT");
            put(ACCOUNT_IS_NOT_ACTIVE, "ACCOUNT_IS_NOT_ACTIVE");
            put(INSUFFICIENT_AMOUNT, "INSUFFICIENT_AMOUNT");
        }

    };
}
