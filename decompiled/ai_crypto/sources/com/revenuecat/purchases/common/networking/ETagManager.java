package com.revenuecat.purchases.common.networking;

import E5.j;
import E5.k;
import E5.m;
import E5.o;
import E5.t;
import F5.J;
import android.content.Context;
import android.content.SharedPreferences;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.strings.NetworkStrings;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class ETagManager {
    public static final Companion Companion = new Companion(null);
    private final DateProvider dateProvider;
    private final j prefs;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.networking.ETagManager$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            return ETagManager.Companion.initializeSharedPreferences(this.$context);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final SharedPreferences initializeSharedPreferences(Context context) {
            r.f(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences_etags", 0);
            r.e(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VerificationResult.values().length];
            try {
                iArr[VerificationResult.VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerificationResult.NOT_REQUESTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerificationResult.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VerificationResult.VERIFIED_ON_DEVICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ETagManager(Context context, j prefs, DateProvider dateProvider) {
        r.f(context, "context");
        r.f(prefs, "prefs");
        r.f(dateProvider, "dateProvider");
        this.prefs = prefs;
        this.dateProvider = dateProvider;
    }

    public static /* synthetic */ Map getETagHeaders$purchases_defaultsRelease$default(ETagManager eTagManager, String str, boolean z7, boolean z8, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z8 = false;
        }
        return eTagManager.getETagHeaders$purchases_defaultsRelease(str, z7, z8);
    }

    private final HTTPResultWithETag getStoredResultSavedInSharedPreferences(String str) {
        String string = ((SharedPreferences) this.prefs.getValue()).getString(str, null);
        if (string != null) {
            return HTTPResultWithETag.Companion.deserialize(string);
        }
        return null;
    }

    private final boolean shouldStoreBackendResult(HTTPResult hTTPResult) {
        int responseCode = hTTPResult.getResponseCode();
        return (responseCode == 304 || responseCode >= 500 || hTTPResult.getVerificationResult() == VerificationResult.FAILED) ? false : true;
    }

    private final boolean shouldUseETag(HTTPResultWithETag hTTPResultWithETag, boolean z7) {
        int i7 = WhenMappings.$EnumSwitchMapping$0[hTTPResultWithETag.getHttpResult().getVerificationResult().ordinal()];
        if (i7 == 1) {
            return true;
        }
        if (i7 != 2) {
            if (i7 != 3 && i7 != 4) {
                throw new m();
            }
        } else if (!z7) {
            return true;
        }
        return false;
    }

    private final synchronized void storeResult(String str, HTTPResult hTTPResult, String str2) {
        ((SharedPreferences) this.prefs.getValue()).edit().putString(str, new HTTPResultWithETag(new ETagData(str2, this.dateProvider.getNow()), HTTPResult.copy$default(hTTPResult, 0, null, HTTPResult.Origin.CACHE, null, null, 27, null)).serialize()).apply();
    }

    public final synchronized void clearCaches$purchases_defaultsRelease() {
        ((SharedPreferences) this.prefs.getValue()).edit().clear().apply();
    }

    public final Map<String, String> getETagHeaders$purchases_defaultsRelease(String path, boolean z7, boolean z8) {
        ETagData eTagData;
        Date lastRefreshTime;
        r.f(path, "path");
        String string = null;
        HTTPResultWithETag storedResultSavedInSharedPreferences = z8 ? null : getStoredResultSavedInSharedPreferences(path);
        if (storedResultSavedInSharedPreferences == null || (eTagData = storedResultSavedInSharedPreferences.getETagData()) == null || !shouldUseETag(storedResultSavedInSharedPreferences, z7)) {
            eTagData = null;
        }
        String eTag = eTagData != null ? eTagData.getETag() : null;
        if (eTag == null) {
            eTag = "";
        }
        o oVarA = t.a("X-RevenueCat-ETag", eTag);
        if (eTagData != null && (lastRefreshTime = eTagData.getLastRefreshTime()) != null) {
            string = Long.valueOf(lastRefreshTime.getTime()).toString();
        }
        return J.g(oVarA, t.a(HTTPRequest.ETAG_LAST_REFRESH_NAME, string));
    }

    public final HTTPResult getHTTPResultFromCacheOrBackend$purchases_defaultsRelease(int i7, String payload, String str, String urlPathWithVersion, boolean z7, Date date, VerificationResult verificationResult) {
        HTTPResult hTTPResultCopy$default;
        r.f(payload, "payload");
        r.f(urlPathWithVersion, "urlPathWithVersion");
        r.f(verificationResult, "verificationResult");
        HTTPResult hTTPResult = new HTTPResult(i7, payload, HTTPResult.Origin.BACKEND, date, verificationResult);
        if (str != null) {
            if (shouldUseCachedVersion$purchases_defaultsRelease(i7)) {
                HTTPResult storedResult$purchases_defaultsRelease = getStoredResult$purchases_defaultsRelease(urlPathWithVersion);
                if (storedResult$purchases_defaultsRelease != null) {
                    hTTPResultCopy$default = HTTPResult.copy$default(storedResult$purchases_defaultsRelease, 0, null, null, date == null ? storedResult$purchases_defaultsRelease.getRequestDate() : date, verificationResult, 7, null);
                } else {
                    hTTPResultCopy$default = null;
                }
                if (hTTPResultCopy$default != null) {
                    return hTTPResultCopy$default;
                }
                if (!z7) {
                    return null;
                }
                LogIntent logIntent = LogIntent.WARNING;
                String str2 = String.format(NetworkStrings.ETAG_CALL_ALREADY_RETRIED, Arrays.copyOf(new Object[]{hTTPResult}, 1));
                r.e(str2, "format(this, *args)");
                LogWrapperKt.log(logIntent, str2);
                return hTTPResult;
            }
            storeBackendResultIfNoError$purchases_defaultsRelease(urlPathWithVersion, hTTPResult, str);
        }
        return hTTPResult;
    }

    public final HTTPResult getStoredResult$purchases_defaultsRelease(String path) {
        r.f(path, "path");
        HTTPResultWithETag storedResultSavedInSharedPreferences = getStoredResultSavedInSharedPreferences(path);
        if (storedResultSavedInSharedPreferences != null) {
            return storedResultSavedInSharedPreferences.getHttpResult();
        }
        return null;
    }

    public final boolean shouldUseCachedVersion$purchases_defaultsRelease(int i7) {
        return i7 == 304;
    }

    public final void storeBackendResultIfNoError$purchases_defaultsRelease(String path, HTTPResult resultFromBackend, String eTagInResponse) {
        r.f(path, "path");
        r.f(resultFromBackend, "resultFromBackend");
        r.f(eTagInResponse, "eTagInResponse");
        if (shouldStoreBackendResult(resultFromBackend)) {
            storeResult(path, resultFromBackend, eTagInResponse);
        }
    }

    public /* synthetic */ ETagManager(Context context, j jVar, DateProvider dateProvider, int i7, AbstractC2148j abstractC2148j) {
        this(context, (i7 & 2) != 0 ? k.b(new AnonymousClass1(context)) : jVar, (i7 & 4) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
