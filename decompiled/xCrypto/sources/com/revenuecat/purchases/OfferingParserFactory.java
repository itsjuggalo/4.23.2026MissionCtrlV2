package com.revenuecat.purchases;

import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.amazon.AmazonOfferingParser;
import com.revenuecat.purchases.common.GoogleOfferingParser;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.simulatedstore.SimulatedStoreOfferingParser;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class OfferingParserFactory {
    public static final OfferingParserFactory INSTANCE = new OfferingParserFactory();

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

    private OfferingParserFactory() {
    }

    public final OfferingParser createOfferingParser(Store store, APIKeyValidator.ValidationResult apiKeyValidationResult) {
        r.f(store, "store");
        r.f(apiKeyValidationResult, "apiKeyValidationResult");
        if (apiKeyValidationResult == APIKeyValidator.ValidationResult.SIMULATED_STORE) {
            return new SimulatedStoreOfferingParser();
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        if (i4 == 1) {
            return new GoogleOfferingParser();
        }
        if (i4 == 2) {
            try {
                Object objNewInstance = AmazonOfferingParser.class.getConstructor(new Class[0]).newInstance(new Object[0]);
                r.d(objNewInstance, "null cannot be cast to non-null type com.revenuecat.purchases.common.OfferingParser");
                return (OfferingParser) objNewInstance;
            } catch (ClassNotFoundException e4) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Make sure purchases-amazon is added as dependency", e4);
                throw e4;
            }
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Incompatible store (" + store + ") used", null);
        throw new IllegalArgumentException("Couldn't configure SDK. Incompatible store (" + store + ") used");
    }
}
