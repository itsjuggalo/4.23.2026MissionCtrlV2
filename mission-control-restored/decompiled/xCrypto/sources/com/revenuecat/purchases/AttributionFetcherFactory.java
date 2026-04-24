package com.revenuecat.purchases;

import com.revenuecat.purchases.amazon.attribution.AmazonDeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class AttributionFetcherFactory {
    public static final AttributionFetcherFactory INSTANCE = new AttributionFetcherFactory();

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

    private AttributionFetcherFactory() {
    }

    public final DeviceIdentifiersFetcher createAttributionFetcher(Store store, Dispatcher dispatcher) {
        r.f(store, "store");
        r.f(dispatcher, "dispatcher");
        int i4 = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        if (i4 == 1) {
            return new GoogleDeviceIdentifiersFetcher(dispatcher);
        }
        if (i4 == 2) {
            try {
                Object objNewInstance = AmazonDeviceIdentifiersFetcher.class.getConstructor(new Class[0]).newInstance(new Object[0]);
                r.d(objNewInstance, "null cannot be cast to non-null type com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher");
                return (DeviceIdentifiersFetcher) objNewInstance;
            } catch (ClassNotFoundException e4) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Make sure purchases-amazon is added as dependency", e4);
                throw e4;
            }
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Incompatible store (" + store + ") used", null);
        throw new IllegalArgumentException("Couldn't configure SDK. Incompatible store (" + store + ") used");
    }
}
