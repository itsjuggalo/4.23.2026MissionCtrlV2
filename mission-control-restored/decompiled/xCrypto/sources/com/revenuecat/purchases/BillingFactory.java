package com.revenuecat.purchases;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.amazon.AmazonBilling;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.BillingWrapper;
import com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class BillingFactory {
    public static final BillingFactory INSTANCE = new BillingFactory();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.AMAZON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BillingFactory() {
    }

    public final BillingAbstract createBilling(Store store, Application application, BackendHelper backendHelper, DeviceCache cache, boolean z4, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider stateProvider, boolean z5, Backend backend, APIKeyValidator.ValidationResult apiKeyValidationResult) {
        r.f(store, "store");
        r.f(application, "application");
        r.f(backendHelper, "backendHelper");
        r.f(cache, "cache");
        r.f(stateProvider, "stateProvider");
        r.f(backend, "backend");
        r.f(apiKeyValidationResult, "apiKeyValidationResult");
        if (apiKeyValidationResult == APIKeyValidator.ValidationResult.SIMULATED_STORE) {
            return new SimulatedStoreBillingWrapper(cache, new Handler(application.getMainLooper()), stateProvider, backend, null, 16, null);
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        if (i4 == 1) {
            return new BillingWrapper(new BillingWrapper.ClientFactory(application, z5), new Handler(application.getMainLooper()), cache, diagnosticsTracker, stateProvider, null, 32, null);
        }
        if (i4 == 2) {
            try {
                Context applicationContext = application.getApplicationContext();
                r.e(applicationContext, "application.applicationContext");
                return new AmazonBilling(applicationContext, cache, z4, new Handler(application.getMainLooper()), backendHelper, stateProvider, diagnosticsTracker);
            } catch (NoClassDefFoundError e4) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Make sure purchases-amazon is added as dependency", e4);
                throw e4;
            }
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Incompatible store (" + store + ") used", null);
        throw new IllegalArgumentException("Couldn't configure SDK. Incompatible store (" + store + ") used");
    }
}
