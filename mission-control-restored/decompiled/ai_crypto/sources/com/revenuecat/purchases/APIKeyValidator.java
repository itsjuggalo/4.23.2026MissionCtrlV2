package com.revenuecat.purchases;

import Z5.t;
import Z5.u;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.strings.ConfigureStrings;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class APIKeyValidator {

    public enum APIKeyPlatform {
        GOOGLE,
        AMAZON,
        LEGACY,
        OTHER_PLATFORM
    }

    public enum ValidationResult {
        VALID,
        GOOGLE_KEY_AMAZON_STORE,
        AMAZON_KEY_GOOGLE_STORE,
        LEGACY,
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
                iArr[ValidationResult.VALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final APIKeyPlatform getApiKeyPlatform(String str) {
        return t.y(str, "goog_", false, 2, null) ? APIKeyPlatform.GOOGLE : t.y(str, "amzn_", false, 2, null) ? APIKeyPlatform.AMAZON : !u.C(str, '_', false, 2, null) ? APIKeyPlatform.LEGACY : APIKeyPlatform.OTHER_PLATFORM;
    }

    public final ValidationResult validate(String apiKey, Store configuredStore) {
        r.f(apiKey, "apiKey");
        r.f(configuredStore, "configuredStore");
        APIKeyPlatform apiKeyPlatform = getApiKeyPlatform(apiKey);
        APIKeyPlatform aPIKeyPlatform = APIKeyPlatform.GOOGLE;
        if (apiKeyPlatform == aPIKeyPlatform && configuredStore == Store.PLAY_STORE) {
            return ValidationResult.VALID;
        }
        APIKeyPlatform aPIKeyPlatform2 = APIKeyPlatform.AMAZON;
        return (apiKeyPlatform == aPIKeyPlatform2 && configuredStore == Store.AMAZON) ? ValidationResult.VALID : (apiKeyPlatform == aPIKeyPlatform && configuredStore == Store.AMAZON) ? ValidationResult.GOOGLE_KEY_AMAZON_STORE : (apiKeyPlatform == aPIKeyPlatform2 && configuredStore == Store.PLAY_STORE) ? ValidationResult.AMAZON_KEY_GOOGLE_STORE : apiKeyPlatform == APIKeyPlatform.LEGACY ? ValidationResult.LEGACY : apiKeyPlatform == APIKeyPlatform.OTHER_PLATFORM ? ValidationResult.OTHER_PLATFORM : ValidationResult.OTHER_PLATFORM;
    }

    public final void validateAndLog(String apiKey, Store configuredStore) {
        r.f(apiKey, "apiKey");
        r.f(configuredStore, "configuredStore");
        int i7 = WhenMappings.$EnumSwitchMapping$0[validate(apiKey, configuredStore).ordinal()];
        if (i7 == 1) {
            LogUtilsKt.errorLog$default(ConfigureStrings.AMAZON_API_KEY_GOOGLE_STORE, null, 2, null);
            return;
        }
        if (i7 == 2) {
            LogUtilsKt.errorLog$default(ConfigureStrings.GOOGLE_API_KEY_AMAZON_STORE, null, 2, null);
        } else if (i7 == 3) {
            LogUtilsKt.debugLog(ConfigureStrings.LEGACY_API_KEY);
        } else {
            if (i7 != 4) {
                return;
            }
            LogUtilsKt.errorLog$default(ConfigureStrings.INVALID_API_KEY, null, 2, null);
        }
    }
}
