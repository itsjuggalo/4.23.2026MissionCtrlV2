package com.google.firebase.appcheck.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.appcheck.AppCheckToken;
import com.google.firebase.appcheck.internal.util.Logger;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public class StorageHelper {
    static final String PREFS_TEMPLATE = "com.google.firebase.appcheck.store.%s";
    static final String TOKEN_KEY = "com.google.firebase.appcheck.APP_CHECK_TOKEN";
    static final String TOKEN_TYPE_KEY = "com.google.firebase.appcheck.TOKEN_TYPE";
    private static final Logger logger = new Logger(StorageHelper.class.getSimpleName());
    private Lazy<SharedPreferences> sharedPreferences;

    /* JADX INFO: renamed from: com.google.firebase.appcheck.internal.StorageHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$appcheck$internal$StorageHelper$TokenType;

        static {
            int[] iArr = new int[TokenType.values().length];
            $SwitchMap$com$google$firebase$appcheck$internal$StorageHelper$TokenType = iArr;
            try {
                iArr[TokenType.DEFAULT_APP_CHECK_TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$appcheck$internal$StorageHelper$TokenType[TokenType.UNKNOWN_APP_CHECK_TOKEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum TokenType {
        DEFAULT_APP_CHECK_TOKEN,
        UNKNOWN_APP_CHECK_TOKEN
    }

    public StorageHelper(final Context context, String str) {
        AbstractC0940s.k(context);
        AbstractC0940s.e(str);
        final String str2 = String.format(PREFS_TEMPLATE, str);
        this.sharedPreferences = new Lazy<>(new Provider() { // from class: com.google.firebase.appcheck.internal.j
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return context.getSharedPreferences(str2, 0);
            }
        });
    }

    public void clearSharedPrefs() {
        this.sharedPreferences.get().edit().remove(TOKEN_KEY).remove(TOKEN_TYPE_KEY).apply();
    }

    public AppCheckToken retrieveAppCheckToken() {
        String string = this.sharedPreferences.get().getString(TOKEN_TYPE_KEY, null);
        String string2 = this.sharedPreferences.get().getString(TOKEN_KEY, null);
        if (string != null && string2 != null) {
            try {
                int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$appcheck$internal$StorageHelper$TokenType[TokenType.valueOf(string).ordinal()];
                if (i4 == 1) {
                    return DefaultAppCheckToken.deserializeTokenFromJsonString(string2);
                }
                if (i4 == 2) {
                    return DefaultAppCheckToken.constructFromRawToken(string2);
                }
                logger.e("Reached unreachable section in #retrieveAppCheckToken()");
                return null;
            } catch (IllegalArgumentException e4) {
                logger.e("Failed to parse TokenType of stored token  with type [" + string + "] with exception: " + e4.getMessage());
                clearSharedPrefs();
            }
        }
        return null;
    }

    public void saveAppCheckToken(AppCheckToken appCheckToken) {
        if (appCheckToken instanceof DefaultAppCheckToken) {
            this.sharedPreferences.get().edit().putString(TOKEN_KEY, ((DefaultAppCheckToken) appCheckToken).serializeTokenToString()).putString(TOKEN_TYPE_KEY, TokenType.DEFAULT_APP_CHECK_TOKEN.name()).apply();
        } else {
            this.sharedPreferences.get().edit().putString(TOKEN_KEY, appCheckToken.getToken()).putString(TOKEN_TYPE_KEY, TokenType.UNKNOWN_APP_CHECK_TOKEN.name()).apply();
        }
    }
}
