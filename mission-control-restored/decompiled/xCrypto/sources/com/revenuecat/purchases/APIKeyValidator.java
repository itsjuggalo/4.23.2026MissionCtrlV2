package com.revenuecat.purchases;

import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.ConfigureStrings;
import kotlin.jvm.internal.r;
import r3.AbstractC1753A;
import r3.x;

/* JADX INFO: loaded from: classes.dex */
public final class APIKeyValidator {

    public enum APIKeyPlatform {
        GOOGLE,
        AMAZON,
        LEGACY,
        TEST,
        OTHER_PLATFORM
    }

    public enum ValidationResult {
        VALID,
        GOOGLE_KEY_AMAZON_STORE,
        AMAZON_KEY_GOOGLE_STORE,
        LEGACY,
        SIMULATED_STORE,
        OTHER_PLATFORM
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ValidationResult.values().length];
            try {
                iArr[ValidationResult.AMAZON_KEY_GOOGLE_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ValidationResult.GOOGLE_KEY_AMAZON_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ValidationResult.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ValidationResult.OTHER_PLATFORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ValidationResult.SIMULATED_STORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ValidationResult.VALID.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final APIKeyPlatform getApiKeyPlatform(String str) {
        return x.C(str, "goog_", false, 2, null) ? APIKeyPlatform.GOOGLE : x.C(str, "amzn_", false, 2, null) ? APIKeyPlatform.AMAZON : x.C(str, "test_", false, 2, null) ? APIKeyPlatform.TEST : !AbstractC1753A.H(str, '_', false, 2, null) ? APIKeyPlatform.LEGACY : APIKeyPlatform.OTHER_PLATFORM;
    }

    private final void logValidationResult(ValidationResult validationResult) {
        int i4 = WhenMappings.$EnumSwitchMapping$0[validationResult.ordinal()];
        if (i4 == 1) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.AMAZON_API_KEY_GOOGLE_STORE, null);
            return;
        }
        if (i4 == 2) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.GOOGLE_API_KEY_AMAZON_STORE, null);
            return;
        }
        if (i4 == 3) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), ConfigureStrings.LEGACY_API_KEY);
                return;
            }
            return;
        }
        if (i4 == 4) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.INVALID_API_KEY, null);
            return;
        }
        if (i4 != 5) {
            return;
        }
        LogLevel logLevel2 = LogLevel.WARN;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), ConfigureStrings.SIMULATED_STORE_API_KEY);
        }
    }

    private final ValidationResult validate(String str, Store store) {
        APIKeyPlatform apiKeyPlatform = getApiKeyPlatform(str);
        if (apiKeyPlatform == APIKeyPlatform.TEST) {
            return ValidationResult.SIMULATED_STORE;
        }
        APIKeyPlatform aPIKeyPlatform = APIKeyPlatform.GOOGLE;
        if (apiKeyPlatform == aPIKeyPlatform && store == Store.PLAY_STORE) {
            return ValidationResult.VALID;
        }
        APIKeyPlatform aPIKeyPlatform2 = APIKeyPlatform.AMAZON;
        return (apiKeyPlatform == aPIKeyPlatform2 && store == Store.AMAZON) ? ValidationResult.VALID : (apiKeyPlatform == aPIKeyPlatform && store == Store.AMAZON) ? ValidationResult.GOOGLE_KEY_AMAZON_STORE : (apiKeyPlatform == aPIKeyPlatform2 && store == Store.PLAY_STORE) ? ValidationResult.AMAZON_KEY_GOOGLE_STORE : apiKeyPlatform == APIKeyPlatform.LEGACY ? ValidationResult.LEGACY : apiKeyPlatform == APIKeyPlatform.OTHER_PLATFORM ? ValidationResult.OTHER_PLATFORM : ValidationResult.OTHER_PLATFORM;
    }

    public final ValidationResult validateAndLog(String apiKey, Store configuredStore) {
        r.f(apiKey, "apiKey");
        r.f(configuredStore, "configuredStore");
        ValidationResult validationResultValidate = validate(apiKey, configuredStore);
        logValidationResult(validationResultValidate);
        return validationResultValidate;
    }
}
