package com.makers.qa.utils;

public final class TestData {
    public static final String BASE_URL = "https://www.saucedemo.com/";

    public static final String VALID_USERNAME = "standard_user";
    public static final String VALID_PASSWORD = "secret_sauce";

    public static final String INVALID_PASSWORD = "wrong_pass";

    public static final String ERROR_INVALID_CREDENTIALS =
            "Username and password do not match";
    public static final String ERROR_USERNAME_REQUIRED = "Username is required";
    public static final String ERROR_PASSWORD_REQUIRED = "Password is required";

    private TestData() {
    }
}


