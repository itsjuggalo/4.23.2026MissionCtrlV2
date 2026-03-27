package com.revenuecat.purchases.paywalls.components;

import W2.m;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class DisplacementStrategyDeserializer extends EnumDeserializerWithDefault<PaywallTransition.DisplacementStrategy> {
    public static final DisplacementStrategyDeserializer INSTANCE = new DisplacementStrategyDeserializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.DisplacementStrategyDeserializer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.DisplacementStrategyDeserializer$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PaywallTransition.DisplacementStrategy.values().length];
                try {
                    iArr[PaywallTransition.DisplacementStrategy.GREEDY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PaywallTransition.DisplacementStrategy.LAZY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // i3.k
        public final String invoke(PaywallTransition.DisplacementStrategy value) {
            r.f(value, "value");
            int i4 = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            if (i4 == 1) {
                return "greedy";
            }
            if (i4 == 2) {
                return "lazy";
            }
            throw new m();
        }
    }

    private DisplacementStrategyDeserializer() {
        super(PaywallTransition.DisplacementStrategy.GREEDY, AnonymousClass1.INSTANCE);
    }
}
