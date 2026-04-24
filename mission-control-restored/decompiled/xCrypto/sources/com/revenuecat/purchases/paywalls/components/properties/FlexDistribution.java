package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import W2.j;
import W2.k;
import W2.l;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public enum FlexDistribution {
    START,
    END,
    CENTER,
    SPACE_BETWEEN,
    SPACE_AROUND,
    SPACE_EVENLY;

    public static final Companion Companion = new Companion(null);
    private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FlexDistribution$Companion$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return FlexDistributionDeserializer.INSTANCE;
            }
        }

        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) FlexDistribution.$cachedSerializer$delegate.getValue();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }
}
